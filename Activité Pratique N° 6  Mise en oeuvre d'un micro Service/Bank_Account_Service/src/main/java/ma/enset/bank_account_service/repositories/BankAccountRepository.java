package ma.enset.bank_account_service.repositories;

import ma.enset.bank_account_service.entities.AccountType;
import ma.enset.bank_account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
   //private BankAccount findById(String id);
    List<BankAccount> findByAccountType(AccountType accountType);
}
