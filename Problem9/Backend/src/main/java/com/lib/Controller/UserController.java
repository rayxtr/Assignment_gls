package com.lib.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lib.Entity.User;
import com.lib.Exception.InvalidCredentialException;
import com.lib.Repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepo ur;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user)throws Exception{
		
		User us = ur.findByEmail(user.getEmail());
		if(us!=null) {
			return ResponseEntity.badRequest().body("User Already Exist");	
		}
		if(user.getEmail()==null||user.getName()==null||user.getPassword()==null) {
			throw new Exception("Blank data will not save.....");
		}
		
		ur.save(user);
		
		return ResponseEntity.ok("User has been successfully Registered");
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) throws InvalidCredentialException {
	    String email = loginData.get("email");
	    String password = loginData.get("password");

	    User u = ur.findByEmail(email);
	    if (u == null || !u.getPassword().equals(password)) {
	    	return ResponseEntity.badRequest().body("Invalid Credential.");
	    }
	    if (u == null || !u.getPassword().equals(password)) {
	        throw new InvalidCredentialException("Invalid Credential. Please enter valid email and password");
	       
	    }
	    return ResponseEntity.ok("Login Successful");
	}
	
	@GetMapping("/users")
	public ResponseEntity<User> getDetails(@RequestParam String email){
		
		User us = ur.findByEmail(email);
		if(us!=null) {
			return ResponseEntity.ok(us);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
