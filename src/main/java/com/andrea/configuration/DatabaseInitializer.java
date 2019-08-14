package com.andrea.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ketu.model.beans.User;
import com.tariq.models.services.UserService;

@Component
public class DatabaseInitializer {

   @Autowired
   private UserService userService;


   @EventListener
   public void onApplicationEvent(ContextStartedEvent event) {

       //Write your business logic here.
       if (userService.count() <= 0) {
           createDefaultAdmin();
       }
   }

    private void createDefaultAdmin() {
       User admin = new User();
       admin.setUsername("admin");
       admin.setPassword("default");
   }
}