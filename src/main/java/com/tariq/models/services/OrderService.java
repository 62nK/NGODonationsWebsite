package com.tariq.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// Import Donation Bean
//
import com.tariq.models.repos.OrderRepo;

public class OrderService implements OrderRepo {
	
	@Autowired
	private OrderRepo or;


}
