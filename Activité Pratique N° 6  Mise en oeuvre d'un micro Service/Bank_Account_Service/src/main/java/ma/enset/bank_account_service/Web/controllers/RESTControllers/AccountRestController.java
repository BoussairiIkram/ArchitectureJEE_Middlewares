package ma.enset.bank_account_service.Web.controllers.RESTControllers;

import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.dto.requests.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.responses.BankAccountResponseDTO;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import ma.enset.bank_account_service.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts(){
        return bankAccountService.getAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO bankAccount(@PathVariable String id){
        return bankAccountService.getAccount(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = bankAccountService.addAccount(bankAccount);
        return bankAccountResponseDTO;
    }

    @PostMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO updateAccount(@PathVariable String id,@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return bankAccountService.updateBankAccount(id,bankAccountRequestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountService.deleteAccount(id);
    }

}
