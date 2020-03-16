package com.smart.workmanagement.security.jwt;

import com.smart.workmanagement.model.Role;
import com.smart.workmanagement.model.Status;
import com.smart.workmanagement.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getUpdatedDate(),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthority(new ArrayList<>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoles())).collect(Collectors.toList());
    }
}
