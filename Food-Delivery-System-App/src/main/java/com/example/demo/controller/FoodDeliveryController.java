package com.example.demo.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BadRequestException;
import com.example.demo.modal.MenuEntity;
import com.example.demo.request.AuthRequest;
import com.example.demo.request.MenuRequest;
import com.example.demo.response.MenuResponse;
import com.example.demo.service.MenuService;
import com.example.demo.util.JwtUtil;

/**
 * @author isili
 *
 */
@Validated
@RestController
public class FoodDeliveryController {

	Logger logger = LoggerFactory.getLogger(FoodDeliveryController.class);
	@Autowired
	MenuService menuService;
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	/* Api to create token to secure remaining apis */
	@PostMapping("/token")
	public ResponseEntity<String> authentic(@RequestBody AuthRequest authRequst) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequst.getUserName(), authRequst.getPassword()));

		} catch (Exception e) {
			throw new Exception("Invaled username and password");
		}
		String token = jwtUtil.generateToken(authRequst.getUserName());
		return new ResponseEntity<String>(token, HttpStatus.OK);

	}

	/* Api to save menu details into Db */
	@PostMapping("/menuCreate")
	public ResponseEntity<List<MenuResponse>> saveFood(@RequestBody List<@Valid MenuRequest> menu) {
		logger.info("menu created!");
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<MenuResponse>>() {
		}.getType();
		List<MenuEntity> menuEntity = menuService.createMenu(menu);
		List<MenuResponse> response = mapper.map(menuEntity, listType);
		if (menuEntity.isEmpty()) {
			throw new BadRequestException("Bad Request!");
		}
		return new ResponseEntity<List<MenuResponse>>(response, HttpStatus.CREATED);
	}

	/* Api to fetch catlog detatis from DB */
	@GetMapping("/catlog")
	public ResponseEntity<List<MenuResponse>> catlog() {
		logger.info("Find all menu");
		List<MenuEntity> menuDetails = menuService.catlog();
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<MenuResponse>>() {
		}.getType();
		List<MenuResponse> response = mapper.map(menuDetails, listType);
		return new ResponseEntity<List<MenuResponse>>(response, HttpStatus.OK);

	}

	/* Api to fetch menu based on rating and price */
	@GetMapping("/basedOnRP/{rating}/{price}")
	public ResponseEntity<List<MenuResponse>> findByRatingAndPrice(@PathVariable Long rating,
			@PathVariable Long price) {
		logger.info("retrive items from catlog based on rating and price");
		List<MenuEntity> FilterByRatingAndPrice = menuService.basedOnRattingAndPrice(rating, price);
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<MenuResponse>>() {
		}.getType();
		List<MenuResponse> response = mapper.map(FilterByRatingAndPrice, listType);
		return new ResponseEntity<List<MenuResponse>>(response, HttpStatus.OK);

	}

	/* Api to save customer details */
	/*
	 * @PostMapping("/userWithFood") public void storedCustomerDetails(@RequestBody
	 * CustomerDetails customerDetails) { yet to implemented }
	 */
}
