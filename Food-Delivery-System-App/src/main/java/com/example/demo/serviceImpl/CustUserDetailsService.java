package com.example.demo.serviceImpl;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.modal.UserEntity;
import com.example.demo.repository.UserRepo;
  
@Service 
public class CustUserDetailsService implements UserDetailsService{ 

	@Autowired
	UserRepo userRepo;
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByuserName(userName);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}