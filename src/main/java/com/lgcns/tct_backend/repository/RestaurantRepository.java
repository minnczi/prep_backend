package com.lgcns.tct_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lgcns.tct_backend.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, String>{

}