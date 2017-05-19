package org.tymfry.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.dto.CustomerDto;
import org.tymfry.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Wrzucić na widok
	@RequestMapping(value = "/show-all-customers", method = RequestMethod.GET)
	public ModelAndView showAllCustomers(ModelMap modelMap) {
		modelMap.addAttribute("customerDto", customerService.getAllCustomers());
		return new ModelAndView("customer/allcustomers", modelMap);
	}

	@RequestMapping(value = "/add-customer", method = RequestMethod.GET)
	public ModelAndView showAddCustomerForm(ModelMap modelMap) {
		modelMap.addAttribute("customerDto", new CustomerDto());
		return new ModelAndView("customer/addcustomer", modelMap);
	}

	@RequestMapping(value = "/add-customer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customerDto") @Valid CustomerDto customerDto, BindingResult result) {
		if (result.hasErrors()) {
			return "customer/addcustomer";
		}
		customerService.saveCustomer(customerDto);
		return "redirect:/";
	}

}
