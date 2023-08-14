package com.julian.registration.repositories;


import org.springframework.data.repository.CrudRepository;

import com.julian.registration.models.User;

public interface userRepo extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	

}