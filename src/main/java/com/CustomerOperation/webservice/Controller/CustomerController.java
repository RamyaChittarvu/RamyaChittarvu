package com.CustomerOperation.webservice.Controller;

import com.CustomerOperation.webservice.Model.Customer;
import com.CustomerOperation.webservice.Service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
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

    @DeleteMapping("{custId}")
    public ResponseEntity updateCustomerById(@PathVariable("custId") UUID custId)
    {
        customerService.deleteByCustomerId(custId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{custId}")
    public ResponseEntity updateCustomerById(@PathVariable("custId") UUID custId,@RequestBody Customer customer)
    {
        customerService.updateCustomer(custId,customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("{custId}")
    public ResponseEntity patchUpdateCustomerById(@PathVariable("custId") UUID custId,@RequestBody Customer customer)
    {
        customerService.patchUpdateCustomerById(custId,customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer)
    {
        Customer customerSaved= customerService.saveNewCustomer(customer);

        HttpHeaders headers= new HttpHeaders();
        headers.add("Location","/api/v1/customer/"+customerSaved.getId().toString());
         return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="{custId}",method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("custId") UUID Id)
    {
        log.debug("Controller Customer-check123345");
        return customerService.getCustomerID(Id);
    }

}
