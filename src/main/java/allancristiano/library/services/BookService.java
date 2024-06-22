package allancristiano.library.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import allancristiano.library.domain.book.Book;
import allancristiano.library.repositories.BookRepository;
import jakarta.transaction.Transactional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book booksave(Book book){
        try {
            if(book.getAuthor() != null){
               return bookRepository.save(book);
                
            }else{
                throw new IllegalArgumentException("Autor não encontrado");
            }
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Cadastro não realizado");
        }
    }
    
    public List<Book> bookList(){
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book bookUpdate(Book book){
        try {
            return bookRepository.save(book);
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Falha na atualização");
        }
    }

    @Transactional
    public void bookDelete(UUID id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Livro não encontrado");
        }
    }

    
    public Optional<Book> bookFindById(UUID id){
      Optional<Book> book = bookRepository.findById(id);
      return book;
    }
}
