package com.patpintar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ketu.model.beans.User;
import com.tariq.models.services.UserService;

@EnableJpaRepositories("com.tariq.models.repos") 
@EntityScan("com.ketu.model.beans")
@ComponentScan({"com.andrea.controllers", "com.tariq.models.services"})
@SpringBootApplication
public class NgoDonationsWebsiteApplication {
	
	@Autowired
	User admin;
	
	@Autowired
	UserService userService;
	
	@Bean
    public User createAdmin(
    		@Value("${admin.username}") String adminusername, 
    		@Value("${admin.password}") String adminpassword,
    		@Value("${admin.name.first}") String adminfirstname,
    		@Value("${admin.name.last}") String adminlastname) {
		User admin = new User();
		admin.setPassword(adminpassword);
		admin.setUsername(adminusername);
		admin.setFirstName(adminfirstname);
		admin.setLastName(adminlastname);
		admin.setRole(User.role1);
		return admin;
    }
	
	@Autowired
	public void initDatabase(User admin) {
		User firstAdmin = userService.findById(1l);
		if(firstAdmin==null) {
			userService.save(admin);
		}
		else if(!firstAdmin.equals(admin)){
			userService.delete(firstAdmin);
			userService.save(admin);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NgoDonationsWebsiteApplication.class, args);
	}
}
