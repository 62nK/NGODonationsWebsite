package com.tariq.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ketu.model.beans.User;
import com.tariq.models.repos.UserRepo;

public class UserService implements UserRepo {
	
	@Autowired
	private UserRepo ur;
	

	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return ur.save(entity);
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return ur.saveAll(entities);
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return ur.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return ur.existsById(id);
	}

	@Override
	public Iterable<User> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return ur.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return ur.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		ur.deleteById(id);
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		ur.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		ur.deleteAll();
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		ur.deleteAll();
		
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return ur.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}
	

}
