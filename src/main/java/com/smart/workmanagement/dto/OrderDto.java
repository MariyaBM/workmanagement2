package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    private Long id;
    private String extId;
    private Date creationDate;
    private UserDto author;
    private Date startDate;
    private WorkGroupDto workGroup;
    private CustomerDto customer;
    private Date endDate;
    private Date verificationDate;
    private UserDto verificationName;
}
