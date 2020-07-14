package com.example.demo.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequest {
	
	
	private Long id;
	@NotNull
	private String foodName;
	private Long rating;
	private Long price;
	private String feedback;

}
