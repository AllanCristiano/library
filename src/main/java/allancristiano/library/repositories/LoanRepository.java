package allancristiano.library.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import allancristiano.library.domain.book.Book;
import allancristiano.library.domain.loan.Loan;

public interface LoanRepository extends JpaRepository<Loan, UUID>{
    List<Loan> findByReturnDateIsNull();
    List<Loan> findByBookAndReturnDateIsNull(Book book);
}
