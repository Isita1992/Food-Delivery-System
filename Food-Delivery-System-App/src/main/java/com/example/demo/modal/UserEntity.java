package com.example.demo.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
   
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity  
@Table(name="User")
public class UserEntity {

	@Id
	private int id;
	private String userName;
	private String password;
	private String email;
}
