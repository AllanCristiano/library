package allancristiano.library.domain.book;

import java.util.UUID;

import allancristiano.library.domain.author.Author;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "book")
@Entity

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String genre;
    private Integer publicationYear;

    @ManyToOne
    private Author author;
}
