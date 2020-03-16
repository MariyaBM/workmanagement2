package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact, Long> {
}
