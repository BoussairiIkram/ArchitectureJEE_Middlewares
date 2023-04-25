package ma.enset.bank_account_service.Web.controllers;

import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AccountRestController {

    BankAccountRepository bankAccountRepository;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Account %S NOT FOUND",id))
        );
    }

    @PostMapping("/bankAccounts")
    public BankAccount saveAccount(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }

    @PostMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if(account!=null && bankAccount!=null ){
            if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
            if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
            if(bankAccount.getAccountType()!=null) account.setAccountType(bankAccount.getAccountType());
            if(bankAccount.getCreateAt()!=null) account.setCreateAt(bankAccount.getCreateAt());
            bankAccountRepository.save(account);
        }
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

}
