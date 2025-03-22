package com.food.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;


import com.food.model.User_ROLE;
import com.food.model.User;
import com.food.repository.UserRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        User_ROLE role = user.getRole();
        

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  // ✅ Correct
        authorities.add(new SimpleGrantedAuthority(role.toString()));  // ✅ No error
                

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(), authorities
        );
    }
}

