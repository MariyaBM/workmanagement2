package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContact();

    Contact getById(Long id);

    void create(Contact contact);

    void delete(Long id);
}