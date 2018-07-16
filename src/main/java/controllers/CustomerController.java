package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CustomerService;

/**
 * Customer controller. Show data about customers.
 * @author vrnsky.
 * @version 0.1.
 */
@Controller
public class CustomerController {

    /**
     * Service for customer interaction.
     */
    private CustomerService customerService;

    /**
     * Create a new controller with given service.
     * @param service implementation of the customer service.
     */
    @Autowired
    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    /**
     * Show a list with all customers.
     * @param model object of spring mvc.
     * @return show user page with all users.
     */
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String showAllCustomers(Model model) {
        model.addAttribute("customers", this.customerService.getAllCustomers());
        return "customers";
    }
}
