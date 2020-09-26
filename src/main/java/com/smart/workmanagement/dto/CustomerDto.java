package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Contact;
import com.smart.workmanagement.model.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

    private Long id;

    private String name;

    private List<ContactDto> contacts;

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);

        List<Contact> contacts = new ArrayList<>();
        customer.setContacts(contacts);

        return customer;
    }

    public static CustomerDto fromCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setContacts(ContactDto.contactDtoList(customer.getContacts()));

        return customerDto;
    }

    public static List<CustomerDto> customerDtoList(List<Customer> customers) {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customers.forEach(customer -> customerDtoList.add(fromCustomer(customer)));
        return customerDtoList;
    }
}
