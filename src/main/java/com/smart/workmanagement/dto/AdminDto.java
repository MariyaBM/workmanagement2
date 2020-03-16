package com.smart.workmanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Status;
import com.smart.workmanagement.model.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminDto {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));

        return user;
    }

    public static AdminDto fromUser(User user) {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(user.getId());
        adminDto.setUsername(user.getUsername());
        adminDto.setFirstName(user.getFirstName());
        adminDto.setLastName(user.getLastName());
        adminDto.setEmail(user.getEmail());
        adminDto.setStatus(user.getStatus().name());

        return adminDto;
    }
}
