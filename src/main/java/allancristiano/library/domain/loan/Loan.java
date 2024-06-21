package allancristiano.library.domain.loan;

import java.time.LocalDate;
import java.util.UUID;

import allancristiano.library.domain.book.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "loan")
@Entity

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Loan {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private String borrower;
}
