package com.desafio.banco.services;

import com.desafio.banco.entities.Role;
import com.desafio.banco.entities.User;
import com.desafio.banco.projections.UserDetailsProjection;
import com.desafio.banco.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> result = userRepository.searchuserAndRolesByEmail(username);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User nor found!");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.get(0).getPassword());

        for (UserDetailsProjection projection : result) {
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }
}
