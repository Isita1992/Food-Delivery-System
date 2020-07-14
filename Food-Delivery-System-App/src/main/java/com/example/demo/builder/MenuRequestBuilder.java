package com.example.demo.builder;

import com.example.demo.request.MenuRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequestBuilder {

	private Long id;
	private String foodName;
	private Long rating;
	private Long price;
	private String feedback;

	public void setId(Long id) {
		this.id = id;
	}

	public MenuRequestBuilder setFoodName(String foodName) {
		this.foodName = foodName;
		return this;
	}

	public MenuRequestBuilder setRating(Long rating) {
		this.rating = rating;
		return this;
	}

	public MenuRequestBuilder setPrice(Long price) {
		this.price = price;
		return this;
	}

	public MenuRequestBuilder setFeedback(String feedback) {
		this.feedback = feedback;
		return this;
	}

	public MenuRequest build() {
		return new MenuRequest(id, foodName, rating, price, feedback);
	}
}
