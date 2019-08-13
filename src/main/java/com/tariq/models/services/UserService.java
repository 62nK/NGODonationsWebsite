package com.tariq.models.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ketu.model.beans.User;
import com.tariq.models.repos.UserRepo;

@Service
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
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return ur.findByUsername(username);
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}
	
<<<<<<< Updated upstream
	public User validateUser(String username, String password){
		return new User();
	}

=======
	public User validateUser(UserRepo ur, String username) {
	    TypedQuery<User> query = ur.createQuery(
	        "SELECT c FROM Country c WHERE c.name = :name", User.class);
	    return query.setParameter("name", username).getSingleResult();
	  } 
	
>>>>>>> Stashed changes

}
