package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.modal.MenuEntity;
import com.example.demo.request.MenuRequest;

@Service
public interface MenuService {

	public List<MenuEntity> createMenu(List<MenuRequest> req);
	
	public List<MenuEntity> catlog();
	
	public List<MenuEntity> basedOnRattingAndPrice(Long rating, Long price);
	
}
