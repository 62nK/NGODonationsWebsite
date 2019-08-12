package com.tariq.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// Import Donation Bean
//
import com.tariq.models.repos.DonationRepo;

public class DonationService implements DonationRepo {
	
	@Autowired
	private DonationRepo dr;


}
