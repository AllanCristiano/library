package allancristiano.library.domain.author;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "author")
@Entity

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Author {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String nationality;
}
