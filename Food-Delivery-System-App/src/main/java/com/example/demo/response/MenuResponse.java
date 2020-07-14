package com.example.demo.response;

import com.example.demo.request.MenuRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {

	private Long id;
	private String foodName;
	private Long rating;
	private Long price;
	private String feedback;
}
