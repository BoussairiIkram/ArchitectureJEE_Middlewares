package ma.enset.bank_account_service.Web.controllers.graghQLControllers;

import lombok.AllArgsConstructor;
import ma.enset.bank_account_service.dto.requests.BankAccountRequestDTO;
import ma.enset.bank_account_service.dto.responses.BankAccountResponseDTO;
import ma.enset.bank_account_service.entities.BankAccount;
import ma.enset.bank_account_service.entities.Customer;
import ma.enset.bank_account_service.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller @AllArgsConstructor
public class CustomerGraphQLController {

    private CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> ListCustomers() {
        return customerRepository.findAll();
    }


}
