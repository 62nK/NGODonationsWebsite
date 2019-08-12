package com.tariq.models.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.ketu.model.beans.User;

public interface UserRepo extends CrudRepository<User, Long>{
	
//	List<ProductEntity> findByName(String name);
	User findById(long id);
	List<User> findAll();
	User findByUsername(String username);
	
}

