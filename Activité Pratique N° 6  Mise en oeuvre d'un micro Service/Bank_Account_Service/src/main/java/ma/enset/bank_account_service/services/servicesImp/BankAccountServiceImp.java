package ma.enset.bank_account_service.services.servicesImp;

import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.dto.requests.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.responses.BankAccountResponseDTO;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.mappers.AccountMapper;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import ma.enset.bank_account_service.services.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional @AllArgsConstructor
public class BankAccountServiceImp implements BankAccountService {

   private BankAccountRepository bankAccountRepository;
   private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .accountType(bankAccountRequestDTO.getAccountType())
                .build();

       BankAccount saveAccount= bankAccountRepository.save(bankAccount);
       /* BankAccountResponseDTO bankAccountResponseDTO= BankAccountResponseDTO.builder()
                .id(saveAccount.getId())
                .balance(saveAccount.getBalance())
                .createAt(saveAccount.getCreateAt())
                .accountType(saveAccount.getAccountType())
                .currency(saveAccount.getCurrency())
                .build();*/

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveAccount);

        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO, @Argument String id){
        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .accountType(bankAccountRequestDTO.getAccountType())
                .build();

        BankAccount saveAccount= bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveAccount);

        return bankAccountResponseDTO;
    }

}
