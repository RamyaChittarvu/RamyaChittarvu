package com.CustomerOperation.webservice.Service;

import com.CustomerOperation.webservice.Model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {


    List<Customer> customerList();

    Customer getCustomerID(UUID id);
}
