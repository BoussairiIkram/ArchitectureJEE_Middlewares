package ma.enset.bank_account_service.services;

import ma.enset.bank_account_service.dto.requests.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.responses.BankAccountResponseDTO;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

public interface BankAccountService {
    BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO updateBankAccount( @Argument String id, @Argument BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO getAccount(@Argument String id);
    List<BankAccountResponseDTO> getAccounts();

    void deleteAccount(@Argument String id);


}
