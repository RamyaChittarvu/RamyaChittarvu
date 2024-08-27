package com.CustomerOperation.webservice.Controller;

import com.CustomerOperation.webservice.Model.Customer;
import com.CustomerOperation.webservice.Service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {


    @Autowired
   private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers()
    {
return customerService.customerList();
    }

    @RequestMapping(value="{custId}",method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("custId") UUID Id)
    {
        return customerService.getCustomerID(Id);
    }

}
