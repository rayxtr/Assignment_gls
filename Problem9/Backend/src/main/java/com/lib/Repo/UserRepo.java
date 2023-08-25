package com.lib.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.Entity.User;

public interface UserRepo extends JpaRepository<User,String>{

	User findByEmail(String email);

	
}
