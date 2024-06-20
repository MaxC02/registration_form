package aeroparker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import aeroparker.model.Customer;
import aeroparker.service.CustomerService;
import jakarta.validation.Valid;

/**
 * Controller for handling customer registration related requests.
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
     * Displays the customer registration form.
     *
     * @param model: the model to add attributes to
     * @return the name of the registration view
     */
	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "registration";
	}

	/**
     * Processes the customer registration form.
     *
     * @param customer: the customer to register
     * @param result: the binding result for validation
     * @param model: the model to add attributes to
     * @return the name of the success view if registration is successful,
     *         or the registration view if validation fails
     */
	@PostMapping("/registration")
	public String registerCustomer(@Valid Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "registration";
		}

		if (customerService.emailExists(customer.getEmailAddress())) {
			result.rejectValue("emailAddress", null, "There is already an account registered with that email");
			return "redirect:/error";
		}

		customerService.save(customer);
		return "success";
	}

	/**
     * Displays the success page after successful registration.
     *
     * @return the name of the success view
     */
	@GetMapping("/success")
	public String showSuccessPage() {
		return "success";
	}
	
	/**
     * Displays the error page if registration fails due to existing email.
     *
     * @return the name of the error view
     */
	@GetMapping("/error")
	public String showErrorPage() {
		return "error";
	}


}
