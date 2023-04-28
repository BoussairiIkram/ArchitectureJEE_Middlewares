package ma.enset.bank_account_service.services;

import ma.enset.bank_account_service.dto.requests.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.responses.BankAccountResponseDTO;
import org.springframework.graphql.data.method.annotation.Argument;

public interface BankAccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO updateBankAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO, @Argument String id);
}
