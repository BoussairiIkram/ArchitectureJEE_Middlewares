package ma.enset.bank_account_service.Web.controllers;

import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.dto.requests.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.responses.BankAccountResponseDTO;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import ma.enset.bank_account_service.services.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class AccountGraphQLController {

    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccount>  ListAccounts(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Account %s  not found",id))
        );
    }

    @MutationMapping
    public BankAccountResponseDTO addBankAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO){
       return  bankAccountService.addAccount(bankAccountRequestDTO);
    }
}
