package com.eugenia.spring.controllers;

import com.eugenia.spring.dao.CustomerDAO;
import com.eugenia.spring.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomersController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping()
    public String index(Model model){
//        show all customers
        model.addAttribute("customers", customerDAO.index());
        return "customers/index";
    }

    @GetMapping("/{id}")
//    use model to show it on the page
    public String show(@PathVariable("id") int id, Model model){
//        Choose one of customers
        model.addAttribute("customer", customerDAO.show(id));
        return "customers/show";
    }

    @GetMapping("/new")
    public String newCust(@ModelAttribute("customer") Customer customer){
        return "customers/new";
    }

    @PostMapping
    public String create(@ModelAttribute("customer") Customer customer){
        customerDAO.save(customer);
//        after adding new cust the page will reload thanks to "redirect" method
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("customer", customerDAO.show(id));
        return "customers/edit";
    }

    @PatchMapping ("/{id}")
    public String update(@ModelAttribute("customer") Customer customer, @PathVariable("id") int id){
        customerDAO.update(id, customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        customerDAO.delete(id);
        return "redirect:/customers";

    }

}
