package com.example.demo.serviceImpl.Test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.demo.builder.MenuRequestBuilder;
import com.example.demo.modal.MenuEntity;
import com.example.demo.request.MenuRequest;
import com.example.demo.serviceImpl.MenuServiceImpl;


@RunWith(PowerMockRunner.class)
@PrepareForTest({MenuServiceImpl.class})

public class MenuServiceImplTest {

	
	@InjectMocks
	MenuServiceImpl menuServiceImpl;
	
	MenuRequest menuRequestBuilder;
	MenuEntity menuEntity;
	List<MenuRequest> list;
	List<MenuEntity> menuEList;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		menuServiceImpl=new MenuServiceImpl();
		menuRequestBuilder=new MenuRequestBuilder(1l, "pizza", 4l, 500l, "Delicious").build();
		menuEntity=new MenuEntity();
		list=new ArrayList<MenuRequest>();
		list.add(menuRequestBuilder);
		menuEList=new ArrayList<>();
		menuEList.add(menuEntity);
		
		
	}
	@Test
	public void createMenuTest(List<MenuRequest> req) {
		Object obj=PowerMockito.when(menuServiceImpl.createMenu(list)).thenReturn(menuEList);
		Assert.assertNotNull(obj);
	}
	
	
}
