package com.example.demo.util;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.demo.modal.UserEntity;
import com.example.demo.repository.UserRepo;
@Component  
public class UserEntryToDb {
	
	@Autowired 
	UserRepo useRepo;  
	
	@Bean
	public void initUserEntyte() {
		List<UserEntity> list=Stream.of(new UserEntity(101, "isita", "123", "iaita.amrit@gmail.com"),
				new UserEntity(102, "siku", "cq", "siku.amrit@gmail.com"),
				new UserEntity(103, "mummy", "pas", "mummy.12@gmail.com")).collect(Collectors.toList());
		useRepo.saveAll(list);
	}
}