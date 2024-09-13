package com.CustomerOperation.webservice.Service;

import com.CustomerOperation.webservice.Model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public Customer saveNewCustomer(Customer customer) {


        Customer customerSaved= Customer.builder()
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .version(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customerSaved.getId(),customerSaved);

        return customerSaved;
    }

    @Override
    public void updateCustomer(UUID custId, Customer customer) {
        Customer existing = customerMap.get(custId);
        existing.setCustomerName(customer.getCustomerName());
        existing.setVersion(customer.getVersion());

        customerMap.put(existing.getId(),existing);
    }

    @Override
    public void deleteByCustomerId(UUID custId) {
        customerMap.remove(custId);
    }

    @Override
    public void patchUpdateCustomerById(UUID custId, Customer customer) {

        Customer existing = customerMap.get(custId);
        if(StringUtils.hasText(customer.getCustomerName())) {
            existing.setCustomerName(customer.getCustomerName());
        }
        if(customer.getVersion()!=null) {
            existing.setVersion(customer.getVersion());
        }

    }

}
