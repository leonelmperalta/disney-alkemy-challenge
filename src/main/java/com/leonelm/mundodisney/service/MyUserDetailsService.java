package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.MyUserDetail;
import com.leonelm.mundodisney.model.User;
import com.leonelm.mundodisney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username).orElseThrow(
               () -> new UsernameNotFoundException("Not found: " + username)
       );
       return new MyUserDetail(user);
    }

    public User registerUser(String username, String password) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(bcryptEncoder.encode(password));
        return userRepository.save(newUser);
    }
}
