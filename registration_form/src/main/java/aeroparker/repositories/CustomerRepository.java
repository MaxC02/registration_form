package aeroparker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aeroparker.model.Customer;

/**
 * Repository interface for {@link Customer} instances.
 * Provides basic CRUD operations due to the extension of {@link JpaRepository}.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	/**
     * Checks if a customer exists with the given email address, ignoring case.
     *
     * @param emailAddress: the email address to check
     * @return true if a customer exists with the given email address, false otherwise
     */
	boolean existsByEmailAddressIgnoreCase(String emailAddress);
}