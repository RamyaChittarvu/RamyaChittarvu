package com.CustomerOperation.webservice.Service;

import com.CustomerOperation.webservice.Model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {


    List<Customer> customerList();

    Customer getCustomerID(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomer(UUID custId, Customer customer);

    void deleteByCustomerId(UUID custId);

    void patchUpdateCustomerById(UUID custId, Customer customer);
}
