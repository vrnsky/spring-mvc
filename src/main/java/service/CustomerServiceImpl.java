package service;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.customerRepo = repository;
    }
    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepo.getAllCustomers();
    }
}
