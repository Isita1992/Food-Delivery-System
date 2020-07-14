package com.example.demo.serviceImpl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.demo.modal.MenuEntity;
import com.example.demo.repository.MenuRepositery;
import com.example.demo.request.MenuRequest;
import com.example.demo.service.MenuService;

@Component
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuRepositery menuRepositery;
	
	@Override
	public List<MenuEntity> createMenu(List<MenuRequest> req) {
		ModelMapper mapper = new ModelMapper();
		Type listType = new TypeToken<List<MenuEntity>>() {
		}.getType();
		
		List<MenuEntity> menuCreate=mapper.map(req, listType);
		List<MenuEntity> create=menuRepositery.saveAll(menuCreate);
		
		return create;
	}

	@Override
	@Cacheable(value="empCache")
	public List<MenuEntity> catlog() {
		System.out.println(" db hit...................");
		return menuRepositery.findAll();
	}

	@Override
	@Cacheable(value="empCache")
	public List<MenuEntity> basedOnRattingAndPrice(Long rating, Long price) {
		List<MenuEntity> listByratingAndPrice=menuRepositery.findMenuEntityByratingAndpriceIn(rating, price);
		return listByratingAndPrice;
	}

	
}
