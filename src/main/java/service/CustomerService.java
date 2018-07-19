package service;

import domain.Customer;

import java.util.List;

/**
 * Customer service, wrapper for repository.
 * @author vrnsky.
 * @version 0.1.
 */
public interface CustomerService {

    /**
     * Return all customers.
     * @return list of all customers.
     */
    List<Customer> getAllCustomers();

    void addCustomer(Customer customer);
}
