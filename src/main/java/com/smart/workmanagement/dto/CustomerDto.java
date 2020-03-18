package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Address;
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

    private List<AddressDto> addresses;

    public Customer toCustomer() {
        Customer customer = new Customer();
        List<Contact> contacts = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        customer.setId(id);
        customer.setName(name);
        customer.setContacts(contacts);
        customer.setAddresses(addresses);

        return customer;
    }

    public static CustomerDto fromCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setContacts(ContactDto.contactDtoList(customer.getContacts()));
        customerDto.setAddresses(AddressDto.addressDtoList(customer.getAddresses()));

        return customerDto;
    }

    public static List<CustomerDto> customerDtoList(List<Customer> customers) {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customers.forEach(customer -> customerDtoList.add(fromCustomer(customer)));
        return customerDtoList;
    }
}
