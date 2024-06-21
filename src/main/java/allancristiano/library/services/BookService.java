package allancristiano.library.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import allancristiano.library.domain.book.Book;
import allancristiano.library.repositories.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String booksave(Book book){
        try {
            if(book.getAuthor() != null){
                bookRepository.save(book);
                return "Livro cadastrado";
            }else{
                return "Author não encontrado";
            }
            
        } catch (Exception e) {
            return "Erro: "  + e;
        }
    }
    
    public List<Book> bookList(){
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public String bookUpdate(Book book){
        try {
            bookRepository.save(book);
            return "Livro atualizado";
        } catch (Exception e) {
            return "Erro: " + e;
        }
    }

    public String bookDelete(UUID id){
        try {
            bookRepository.deleteById(id);
            return "Livro deletado";
        } catch (Exception e) {
            return "Erro: " + e;
        }
    }
}
