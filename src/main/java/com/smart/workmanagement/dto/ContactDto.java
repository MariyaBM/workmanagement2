package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Contact;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactDto {

    private Long id;

    private String name;

    private String phone;

    public Contact toContact() {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setPhone(phone);
        return contact;
    }

    public static ContactDto fromContact(Contact contact) {
        ContactDto contactDto = new ContactDto();
        contactDto.setId(contact.getId());
        contactDto.setName(contact.getName());
        contactDto.setPhone(contact.getPhone());
        return contactDto;
    }

    public static List<ContactDto> contactDtoList(List<Contact> contacts) {
        List<ContactDto> contactDtoList = new ArrayList<>();
        contacts.forEach(contact -> contactDtoList.add(fromContact(contact)));
        return contactDtoList;
    }



}
