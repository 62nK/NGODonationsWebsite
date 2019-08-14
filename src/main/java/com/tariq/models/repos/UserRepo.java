package com.tariq.models.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.TypedQuery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ketu.model.beans.User;

public interface UserRepo extends CrudRepository<User, Long>{
	
//	List<ProductEntity> findByName(String name);
	User findById(long id);
	List<User> findAll();

	User findByUsername(String username);
}

