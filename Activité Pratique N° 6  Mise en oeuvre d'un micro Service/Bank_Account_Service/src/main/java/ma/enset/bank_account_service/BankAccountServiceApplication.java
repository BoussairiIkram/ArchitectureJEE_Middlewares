package ma.enset.bank_account_service;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.entities.AccountType;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class BankAccountServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    BankAccountRepository bankAccountRepository;

    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<10; i++){
            BankAccount bankAccount = BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                    .createAt(new Date())
                    .currency("MAD")
                    .build();
            bankAccountRepository.save(bankAccount);
        }
    }

}
