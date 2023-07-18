package com.LittleFlower.staffinformationsystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LittleFlower.staffinformationsystem.model.User;
import com.LittleFlower.staffinformationsystem.model.UserDetailsImpl;
import com.LittleFlower.staffinformationsystem.repository.UserRepo;

@Service
public class UserDetailServiceImp implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		Optional<User>user = userRepo.findByUsername(username);
		
		user.orElseThrow(()-> new UsernameNotFoundException("NOT FOUND: " + username));
		return user.map(UserDetailsImpl::new).get();
	} 

}
