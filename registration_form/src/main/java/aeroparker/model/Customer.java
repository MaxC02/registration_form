package aeroparker.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Max Clarke
 * @version 10/06/2024
 */


/**
 * Customer entity for the application.
 */
@Entity
@Table(name = "customers")
public class Customer {
	
	/**
     * The unique identifier for a customer.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
     * The date and time when the customer was registered.
     */
	@Column(nullable = false, updatable = false)
	private LocalDateTime registered;

	 /**
     * The email address of the customer.
     * It is stored in lowercase to ensure uniqueness.
     */
	@Column(name = "email_address", nullable = false, unique = true)
	private String emailAddress;

	/**
     * The title of the customer (e.g., Mr., Mrs.).
     */
	@Column(nullable = false)
	private String title;

	/**
     * The first name of the customer.
     */
	@Column(name = "first_name", nullable = false)
	private String firstName;

	/**
     * The last name of the customer.
     */
	@Column(name = "last_name", nullable = false)
	private String lastName;

	/**
     * The first line of the customer's address.
     */
	@Column(name = "address_line_1", nullable = false)
	private String addressLine1;
	
	/**
     * The second line of the customer's address.
     * This field is optional.
     */
	@Column(name = "address_line_2")
	private String addressLine2;

	/**
     * The city where the customer resides.
     * This field is optional.
     */
	private String city;

	/**
     * The postcode of the customer's address.
     */
	@Column(nullable = false)
	private String postcode;
	
	/**
     * The phone number of the customer.
     * This field is optional.
     */
	@Column(name = "phone_number")
	private String phoneNumber;
	
	// Getters and setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getRegistered() {
		return registered;
	}

	public void setRegistered(LocalDateTime registered) {
		this.registered = registered;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	/**
     * Any input is converted to LowerCase.
     */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress.toLowerCase();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	


}
