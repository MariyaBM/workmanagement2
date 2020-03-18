package com.smart.workmanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }

    public static List<UserDto> userDtoList(List<User> users) {
        List<UserDto> userList = new ArrayList<>();
        users.forEach(user -> userList.add(fromUser(user)));
        return userList;
    }
}
