package com.empire.SpringBootRoleBasedAuthentication.service;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.empire.SpringBootRoleBasedAuthentication.entity.Users;
import com.empire.SpringBootRoleBasedAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userrepo.findByUsername(username);

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());


        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(

                user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }

}
