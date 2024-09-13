package com.CustomerOperation.webservice.Controller;

import com.CustomerOperation.webservice.Model.Customer;
import com.CustomerOperation.webservice.Service.CustomerService;
import com.CustomerOperation.webservice.Service.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
@Captor
ArgumentCaptor<UUID> uuidArgumentCaptor;
@Captor
ArgumentCaptor<Customer> customerArgumentCaptor;
    @Autowired
MockMvc mockMvc;
    @MockBean
    CustomerService customerService;

    @Autowired
    ObjectMapper objectMapper;

    CustomerServiceImpl customerServiceImpl;// new CustomerServiceImpl();

    @BeforeEach
    void setUp() {
        customerServiceImpl= new CustomerServiceImpl();
    }


    @Test
    void testPatchCustomer() throws Exception {
        Customer testCustomer= customerServiceImpl.customerList().get(0);

        Map<String,Object> customerMap = new HashMap<>();
        customerMap.put("customerName","New Name");

        mockMvc.perform(patch("/api/v1/customer/"+testCustomer.getId()).
                        accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerMap)))

                .andExpect(status().isNoContent());
        verify(customerService).patchUpdateCustomerById(uuidArgumentCaptor.capture(),customerArgumentCaptor.capture());
        assertThat(testCustomer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
        assertThat(customerMap.get("customerName")).isEqualTo(customerArgumentCaptor.getValue().getCustomerName());

    }

    @Test
    void testDeleteCustomer() throws Exception {
        Customer testCustomer= customerServiceImpl.customerList().get(0);

        mockMvc.perform(delete("/api/v1/customer/"+testCustomer.getId()).
                        accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isNoContent());
        ArgumentCaptor<UUID> argumentCaptor= ArgumentCaptor.forClass(UUID.class);

        verify(customerService).deleteByCustomerId(argumentCaptor.capture());
        assertThat(testCustomer.getId()).isEqualTo(argumentCaptor.getValue());

    }

    @Test
    void testUpdateCustomer() throws Exception {
        Customer testCustomer= customerServiceImpl.customerList().get(0);

        mockMvc.perform(put("/api/v1/customer/"+testCustomer.getId()).
                        accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).
                        content(objectMapper.writeValueAsString(testCustomer)))
                .andExpect(status().isNoContent());

        verify(customerService).updateCustomer(any(UUID.class),any(Customer.class));

    }

    @Test
    void testCreateNewBeer() throws Exception {
        Customer testCustomer= customerServiceImpl.customerList().get(0);
        testCustomer.setVersion(null);
        testCustomer.setId(null);
        given(customerService.saveNewCustomer(any(Customer.class))).willReturn(customerServiceImpl.customerList().get(1));
        mockMvc.perform(post("/api/v1/customer").
                        accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).
                        content(objectMapper.writeValueAsString(testCustomer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void listCustomers() throws Exception {

        given(customerService.customerList()).willReturn(customerServiceImpl.customerList());
        mockMvc.perform(get("/api/v1/customer").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()",is(3)));
    }

    @Test
    void getCustomerByID()  throws Exception{

        Customer testCustomer= customerServiceImpl.customerList().get(0);
        given(customerService.getCustomerID(testCustomer.getId()))
                .willReturn(testCustomer);
        mockMvc.perform(get("/api/v1/customer/"+testCustomer.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(jsonPath("$.id",is(testCustomer.getId().toString())))
                .andExpect(jsonPath("$.customerName",is(testCustomer.getCustomerName())));


    }
}