package com.smart.workmanagement.repo;

import com.smart.workmanagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
