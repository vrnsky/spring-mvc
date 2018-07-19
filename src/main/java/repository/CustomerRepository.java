package repository;

import domain.Customer;

import java.util.List;

/**
 * Repository for operations on customer.
 * @author vrnsky.
 * @version 0.1.
 */
public interface CustomerRepository {

    /**
     * Return a list of all customers.
     * @return list of all customers.
     */
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);
}
