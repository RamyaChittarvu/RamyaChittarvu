package com.CustomerOperation.webservice.Service;

import com.CustomerOperation.webservice.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {


    Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer cust1= Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Bluey")
                .version(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();


        Customer cust2= Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Bingo")
                .version(2)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        Customer cust3= Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Ruby")
                .version(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();


        customerMap.put(cust1.getId(),cust1);
        customerMap.put(cust2.getId(),cust2);
        customerMap.put(cust3.getId(),cust3);

    }
@Override
public List<Customer> customerList()
{
    return new ArrayList<>(customerMap.values());
}
@Override
public Customer getCustomerID(UUID id)
{
    log.debug("Service getCustomer"+ id.toString());
    return customerMap.get(id);
}

}
