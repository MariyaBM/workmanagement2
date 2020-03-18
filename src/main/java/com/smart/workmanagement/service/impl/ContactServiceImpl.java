package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Contact;
import com.smart.workmanagement.repo.ContactRepo;
import com.smart.workmanagement.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepo contactRepo;

    @Autowired
    public ContactServiceImpl(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public List<Contact> getAllContact() {
        List<Contact> contacts = contactRepo.findAll();
        log.info("IN getAllContact - {} contacts found", contacts.size());
        return contacts;
    }

    @Override
    public Contact findById(Long id) {
        Contact contact = contactRepo.findById(id).orElse(null);
        if (contact == null) {
            log.warn("IN findById - no contact found by id: {}", id);
            return null;
        }
        log.info("IN findById - contact found by id: {}", contact);
        return contact;
    }
}
