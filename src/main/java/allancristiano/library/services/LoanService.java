package allancristiano.library.services;

import org.springframework.stereotype.Service;

import allancristiano.library.repositories.LoanRepository;

@Service
public class LoanService {
    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

           
}
