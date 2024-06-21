package allancristiano.library.services;


import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import allancristiano.library.domain.author.Author;
import allancristiano.library.repositories.AuthorRepository;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public String saveAuthor(Author author){        

        try {
            authorRepository.save(author);
            return "Cadastro Realizado";
        } catch (Exception e) {
            return "Erro: " + e;
        }
        
    }

    public List<Author> listAuthor(){
        List<Author> authors = authorRepository.findAll();
        return authors;
    }


    public String authorUpdate(Author author){
        try {
            authorRepository.save(author);
            return "Atualização Realizada";
        } catch (Exception e) {
            return "Erro: " + e;
        }        
    }

    public String authorDeleteById(UUID id){
        try {
            authorRepository.deleteById(id);
            return "Author Deletado";
        } catch (Exception e) {
            return "Erro: " + e;
        }
    }
    
}
