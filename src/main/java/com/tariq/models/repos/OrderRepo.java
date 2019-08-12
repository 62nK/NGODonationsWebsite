package com.tariq.models.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//Fix Import --> change to Order; Import Order bean
import com.ketu.model.beans.Order;

public interface OrderRepo extends CrudRepository<Order, Long>{
	
//	List<ProductEntity> findByName(String name);
	Order findById(long id);
	List<Order> findAll();

}
