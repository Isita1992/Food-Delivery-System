package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.MenuEntity;

@Repository
public interface MenuRepositery extends JpaRepository<MenuEntity, Long> {
	
	@Query("SELECT u FROM MenuEntity u WHERE u.rating = :rating and u.price = :price")
	 List<MenuEntity> findMenuEntityByratingAndpriceIn(@Param ("rating") Long rating, @Param ("price") Long price);

}
