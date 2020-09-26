package com.smart.workmanagement.controller;


import com.smart.workmanagement.dto.ContactDto;
import com.smart.workmanagement.model.Contact;
import com.smart.workmanagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/contact/")
public class ContactController {

    private final ContactService contactService;


    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> listContact() {
        List<Contact> contacts = contactService.getAllContact();

        if (contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ContactDto.contactDtoList(contacts), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ContactDto> getContact(@PathVariable(name = "id") Long id) {
        Contact contact = contactService.getById(id);

        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ContactDto result = ContactDto.fromContact(contact);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactDto> saveContact(@RequestBody @Valid Contact contact) {

        if (contact == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        contactService.create(contact);
        return new ResponseEntity<>(ContactDto.fromContact(contact), HttpStatus.OK);
    }
}
