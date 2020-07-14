/*package com.example.demo.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String fullName;
	private Email emial;
	private String address;
	private MenuEntity food;
	

}
*/