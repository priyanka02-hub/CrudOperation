package com.UserDtls.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.UserDtls.Entity.Users;
import com.UserDtls.Repository.UserRepository;

@RestController

public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/api/entity")
	public Users createUsers(@RequestBody Users users) {
		return userRepository.save(users);
		
		}
	@GetMapping("/api/entity")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
		
	}
	@GetMapping("/api/entity/{id}")
    public Optional<Users> getUserById(@PathVariable("id") int id) {
        return userRepository.findById(id);
                
    }
	
	 @PutMapping("/api/entity/{id}")
	    public Users editUsers(@PathVariable("id") int id, @RequestBody Users userDtls) {
	        Users users = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

	        // Update fields
	        users.setName(userDtls.getName());
	        users.setMobileNumber(userDtls.getMobileNumber());
	        users.setEmail(userDtls.getEmail());
	        users.setAddress(userDtls.getAddress());

	        return userRepository.save(users); 
	    }
		
	 
	 @DeleteMapping("/api/entity/{id}")
	 public String deleteUsers(@PathVariable("id") int id) {
		Users user= userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with ID " + id + " not found."));
        
		 userRepository.delete(user);
		 return "user with ID " + id + " has been deleted successfully.";
		 
	 }
	}
	

