package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.UserEntity;

@Repository    
public interface UserRepo extends JpaRepository<UserEntity, Integer>{

	UserEntity findByuserName(String userName);

}
