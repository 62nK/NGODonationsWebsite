package com.tariq.models.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//Fix Import --> change to Donation; Import Donation bean
import com.ketu.model.beans.Donation;

public interface DonationRepo extends CrudRepository<Donation, Long>{
	
//	List<ProductEntity> findByName(String name);
	Donation findById(long id);
	List<Donation> findAll();

}
