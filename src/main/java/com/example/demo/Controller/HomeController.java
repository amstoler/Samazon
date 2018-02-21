package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Repositories.CustomerRepo;
import com.example.demo.Repositories.ShoppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ShoppingRepo shoppingRepo;

    @GetMapping("/")
    public String showHome(){
        return "index";
    }

    @GetMapping("/addCustomer")
    public String customerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @PostMapping("/processCustomer")
    public String customerForm(@Valid @ModelAttribute("customer") Customer customer, Model model,BindingResult result)
    {
        if (result.hasErrors()){
            return "customerForm";
        }

        model.addAttribute("customers",customerRepo.findAll());
        customerRepo.save(customer);
        return "customerList";
    }

    @GetMapping("/listCustomer")
    public String customerList(Model model){
        model.addAttribute("customers",customerRepo.findAll());

        return "customerList";
    }



}
