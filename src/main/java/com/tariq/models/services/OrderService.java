package com.tariq.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ketu.model.beans.Order;
// Import Donation Bean
//
import com.tariq.models.repos.OrderRepo;

public class OrderService implements OrderRepo {
	
	@Autowired
	private OrderRepo or;

	@Override
	public <S extends Order> S save(S entity) {
		// TODO Auto-generated method stub
		return or.save(entity);
	}

	@Override
	public <S extends Order> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return or.saveAll(entities);
	}

	@Override
	public Optional<Order> findById(Long id) {
		// TODO Auto-generated method stub
		return or.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return or.existsById(id);
	}

	@Override
	public Iterable<Order> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return or.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return or.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		or.deleteById(id);
		
	}

	@Override
	public void delete(Order entity) {
		// TODO Auto-generated method stub
		or.delete(entity);;
		
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		// TODO Auto-generated method stub
		or.deleteAll(entities);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		or.deleteAll();
		
	}

	@Override
	public Order findById(long id) {
		// TODO Auto-generated method stub
		return or.findById(id);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return or.findAll();
	}


}
