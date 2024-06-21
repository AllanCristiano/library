package allancristiano.library.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import allancristiano.library.domain.book.Book;

public interface BookRepository extends JpaRepository<Book, UUID>{

    
}