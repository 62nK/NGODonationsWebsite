package com.tariq.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ketu.model.beans.Donation;
// Import Donation Bean
//
import com.tariq.models.repos.DonationRepo;

public class DonationService implements DonationRepo {
	
	@Autowired
	private DonationRepo dr;

	@Override
	public <S extends Donation> S save(S entity) {
		// TODO Auto-generated method stub
		return dr.save(entity);
	}

	@Override
	public <S extends Donation> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return dr.saveAll(entities);
	}

	@Override
	public Optional<Donation> findById(Long id) {
		// TODO Auto-generated method stub
		return dr.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return dr.existsById(id);
	}

	@Override
	public Iterable<Donation> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return dr.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return dr.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
	}

	@Override
	public void delete(Donation entity) {
		// TODO Auto-generated method stub
		dr.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends Donation> entities) {
		// TODO Auto-generated method stub
		dr.deleteAll(entities);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dr.deleteAll();
		
	}

	@Override
	public Donation findById(long id) {
		// TODO Auto-generated method stub
		return dr.findById(id);
	}

	@Override
	public List<Donation> findAll() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}


}
