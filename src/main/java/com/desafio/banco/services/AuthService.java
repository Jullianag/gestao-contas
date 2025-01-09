package com.desafio.banco.services;

import com.desafio.banco.entities.User;
import com.desafio.banco.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateForAdmin(long userId) {
        User me = userService.authenticated();

        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied!");
        }
    }
}
