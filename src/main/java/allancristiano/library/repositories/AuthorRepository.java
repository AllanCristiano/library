package allancristiano.library.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import allancristiano.library.domain.author.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID>{
    
}
