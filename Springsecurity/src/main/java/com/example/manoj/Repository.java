package com.example.manoj;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


public interface Repository extends JpaRepository<User, Long> {


	@Query("from User where username=?1 and password=?2")
	public User findByUsernamePassword(String username,String password);

}
