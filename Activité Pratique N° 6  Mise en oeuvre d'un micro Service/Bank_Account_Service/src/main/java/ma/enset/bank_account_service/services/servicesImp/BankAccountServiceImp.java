package ma.enset.bank_account_service.services.servicesImp;

import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.dto.requests.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.responses.BankAccountResponseDTO;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.entities.Customer;
import ma.enset.bank_account_service.mappers.AccountMapper;
import ma.enset.bank_account_service.repositories.BankAccountRepository;
import ma.enset.bank_account_service.repositories.CustomerRepository;
import ma.enset.bank_account_service.services.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional @AllArgsConstructor
public class BankAccountServiceImp implements BankAccountService {

   private BankAccountRepository bankAccountRepository;
   private CustomerRepository customerRepository;
   private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO) {
        Customer customer = customerRepository.findById(1L).orElse(null);

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .accountType(bankAccountRequestDTO.getAccountType())
                .customer(customer)
                .build();

       BankAccount saveAccount= bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveAccount);

        return bankAccountResponseDTO;
    }



    @Override
    public BankAccountResponseDTO updateBankAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount account = new BankAccount();

        if(bankAccountRequestDTO.getBalance()!=null) account.setBalance(bankAccountRequestDTO.getBalance());
        if(bankAccountRequestDTO.getCurrency()!=null) account.setCurrency(bankAccountRequestDTO.getCurrency());
        if(bankAccountRequestDTO.getAccountType()!=null) account.setAccountType(bankAccountRequestDTO.getAccountType());

        account.setId(id);
        account.setCreateAt(bankAccountRepository.findById(id).get().getCreateAt());

        BankAccount saveAccount= bankAccountRepository.save(account);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveAccount);

        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO getAccount(String id) {
        BankAccount bankAccount =  bankAccountRepository.findById(id).orElse(null);

        return accountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public List<BankAccountResponseDTO> getAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();

        List<BankAccountResponseDTO> responseDTOS = new ArrayList<>();

        for (BankAccount acc : bankAccounts) {
            BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
            bankAccountResponseDTO = accountMapper.fromBankAccount(acc);
            responseDTOS.add(bankAccountResponseDTO);
        }

        return responseDTOS;
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

}
