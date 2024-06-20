package aeroparker.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeroparker.model.Customer;
import aeroparker.repositories.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Checks if an email address already exists in the customer repository.
     *
     * @param emailAddress: the email address to check
     * @return true if the email address exists, false otherwise
     */
    public boolean emailExists(String emailAddress) {
        return customerRepository.existsByEmailAddressIgnoreCase(emailAddress);
    }

    /**
     * Saves a new customer to the repository.
     *
     * @param customer: the customer to save
     */
    public Customer save(Customer customer) {
        customer.setRegistered(LocalDateTime.now());
        return customerRepository.save(customer);
    }
}