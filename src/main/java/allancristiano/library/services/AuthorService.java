package allancristiano.library.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import allancristiano.library.domain.author.Author;
import allancristiano.library.repositories.AuthorRepository;
import jakarta.transaction.Transactional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Método para listar todos os autores
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Método para buscar um autor pelo ID
    public Optional<Author> getAuthorById(UUID id) {
        return authorRepository.findById(id);
    }

    // Método para atualizar um autor
    @Transactional
    public Author updateAuthor(UUID id, Author authorDetails) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            author.setName(authorDetails.getName());
            author.setNationality(authorDetails.getNationality());
            return authorRepository.save(author);
        } else {
            throw new IllegalArgumentException("Autor não encontrado");
        }
    }

    // Método para deletar um autor
    @Transactional
    public void deleteAuthor(UUID id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Autor não encontrado");
        }
    }
}
