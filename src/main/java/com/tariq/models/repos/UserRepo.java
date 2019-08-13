package com.tariq.models.repos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.repository.CrudRepository;
import com.ketu.model.beans.User;

public interface UserRepo extends CrudRepository<User, Long>{
	
//	List<ProductEntity> findByName(String name);
	User findById(long id);
	List<User> findAll();
<<<<<<< Updated upstream
	User findByUsername(String username);
	
=======
	TypedQuery<User> createQuery(String string, Class<User> class1);

>>>>>>> Stashed changes
}

