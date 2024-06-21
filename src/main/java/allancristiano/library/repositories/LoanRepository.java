package allancristiano.library.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import allancristiano.library.domain.loan.Loan;

public interface LoanRepository extends JpaRepository<Loan, UUID>{
    
}
