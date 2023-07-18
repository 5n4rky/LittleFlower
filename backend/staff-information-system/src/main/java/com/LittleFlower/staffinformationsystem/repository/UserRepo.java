package com.LittleFlower.staffinformationsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LittleFlower.staffinformationsystem.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	Optional<User>findByUsername(String userName);
	

}
