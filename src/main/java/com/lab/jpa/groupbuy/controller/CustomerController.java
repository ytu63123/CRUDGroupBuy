package com.lab.jpa.groupbuy.controller;

import com.lab.jpa.groupbuy.entities.Customer;
import com.lab.jpa.groupbuy.repository.CustomerRepository;
import com.lab.jpa.groupbuy.validation.CustomerValidation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerValidation validation;

    @GetMapping(value = {"/",
        "/{id}",//根據id查詢單筆使用(修改連結用)
        "/{delete}/{id}"})//根據id查詢單筆使用(給刪除連結用)
    public String read(Model model,
            @PathVariable Optional<Integer> id,
            @PathVariable Optional<String> delete) {
        String _method = "POST";
        List customer_list = customerRepository.queryAllCustomers();
        Customer customer = new Customer();
        if (id.isPresent()) {
            _method = "PUT";
            customer = customerRepository.getCustomer(id.get());

            if (delete.isPresent() && delete.get().equalsIgnoreCase("delete")) {
                _method = "DELETE";
            }

        }
        model.addAttribute("_method", _method);
        model.addAttribute("customer_list", customer_list);
        model.addAttribute("customer", customer);
        return "customer_page";
    }

    @PostMapping(value = {"/"})
    public String create(@ModelAttribute("customer") Customer customer,
            BindingResult result, Model model) {
        // 數據驗證
        validation.validate(customer, result);
        if (result.hasErrors()) {
            model.addAttribute("customer_list", customerRepository.queryAllCustomers());
            model.addAttribute("customer", customer);
            return "customer_page";
        }
        customerRepository.saveCustomer(customer);
        return "redirect: ./";
    }

    @PutMapping(value = {"/"})
    public String update(@ModelAttribute("customer") Customer customer, Model model) {
        customer.setCreateDate(new Date());
        customerRepository.updateCustomer(customer);
        return "redirect: ./";
    }

    @DeleteMapping(value = {"/"})
    public String delete(@ModelAttribute("customer") Customer customer) {
        customerRepository.deleteCustomer(customer.getId());
        return "redirect: ./";
    }
}
