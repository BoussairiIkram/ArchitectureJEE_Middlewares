package ma.enset.bank_account_service;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.entities.AccountType;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.entities.Customer;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import ma.enset.bank_account_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
public class BankAccountServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    BankAccountRepository bankAccountRepository;
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        Stream.of("Ikram","Afaf","Hamza","Rayane").forEach(
                c->{
                    Customer customer =Customer.builder()
                            .name(c)
                            .build();
                    customerRepository.save(customer);
                }
        );

        customerRepository.findAll().forEach(
                customer -> {
                    for(int i=0;i<10; i++){
                        BankAccount bankAccount = BankAccount.builder()
                                .id(UUID.randomUUID().toString())
                                .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                                .createAt(new Date())
                                .currency("MAD")
                                .customer(customer)
                                .build();
                        bankAccountRepository.save(bankAccount);
                    }
                }
        );
    }

}
