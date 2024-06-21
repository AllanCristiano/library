package allancristiano.library.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import allancristiano.library.domain.book.Book;
import allancristiano.library.domain.loan.Loan;
import allancristiano.library.repositories.BookRepository;
import allancristiano.library.repositories.LoanRepository;
import jakarta.transaction.Transactional;

@Service
public class LoanService {
    private LoanRepository loanRepository;
    private BookRepository bookRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Loan creatLoan(UUID id, String borrower){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            throw new IllegalArgumentException("Livro não encontrado");
        }

        Book book = bookOptional.get();
        
        // verificar se livro ja est emprestado
        List<Loan> activeLoan = loanRepository.findByBookAndReturnDateIsNull(book);
        if (!activeLoan.isEmpty()) {
            throw new IllegalArgumentException("Livro já está emprestado");
        }

        // cadastrar dados do emprestimo
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setBorrower(borrower);
        loan.setLoanDate(LocalDate.now());

        // salvar e retornar o emprestimo
        return loanRepository.save(loan);        
    }

    // Método para listar todos os empréstimos ativos
    public List<Loan> getAllActiveLoans() {
        return loanRepository.findByReturnDateIsNull();
    }

    // Método para registrar a devolução de um livro
    @Transactional
    public Loan returnBook(UUID loanId) {
        Optional<Loan> loanOptional = loanRepository.findById(loanId);
        if (!loanOptional.isPresent()) {
            throw new IllegalArgumentException("Empréstimo não encontrado");
        }

        Loan loan = loanOptional.get();
        if (loan.getReturnDate() != null) {
            throw new IllegalArgumentException("Livro já devolvido");
        }

        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }
           
}
