package com.jvr;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jvr.entity.Booking;
import com.jvr.entity.Offering;
import com.jvr.entity.Service;
import com.jvr.entity.User;
import com.jvr.entity.UserTypes;
import com.jvr.entity.UserRole;
import com.jvr.repo.BookingRepository;
import com.jvr.repo.OfferingRepository;
import com.jvr.repo.ServiceRepository;
import com.jvr.repo.UserRepository;
import com.jvr.repo.UserRolesRepository;
import com.jvr.repo.UserTypesRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	        System.out.println("========== Starting of DemoApplication with login============" + System.getProperty("java.io.tmpdir"));
	       
	    
		ApplicationContext app = SpringApplication.run(DemoApplication.class, args);
		
		//Create Services master
		ServiceRepository serviceRepository = app.getBean(ServiceRepository.class);
		serviceRepository.save(new Service("Plumber"));
		serviceRepository.save(new Service("Carpenter"));
		serviceRepository.save(new Service("Waiter"));
		System.out.println("==== Printing Services ====");
                for (Service service : serviceRepository.findAll()) {
                    System.out.println("Service:" + service.getServiceName());
                }
		
		//Create User Types
		UserTypesRepository userTypesRepository = app.getBean(UserTypesRepository.class);
		userTypesRepository.save(new UserTypes("Provider"));
		userTypesRepository.save(new UserTypes("Receiver"));
		
		System.out.println("==== Printing User types ====");
		for (UserTypes userTypes : userTypesRepository.findAll()) {
                    System.out.println("User Type:" + userTypes.getUserType());
		}
		
		//Create Sample Users
                UserRepository userRepository = app.getBean(UserRepository.class);
                User user1 = new User("Onep", "Demo", "Provider", "onep@gmail.com", "1", "password");
                userRepository.save(user1);
                User user2 = new User("Oner", "Demo", "Receiver", "oner@gmail.com", "2", "password");
                userRepository.save(user2);
                
                System.out.println("==== Printing Users ====");
                for (User user : userRepository.findAll()) {
                    System.out.println("User:" + user.getUserID());
                }
                
                //Map Users to roles
                UserRolesRepository userRolesRepository = app.getBean(UserRolesRepository.class);
                userRolesRepository.save(new UserRole("Onep", "ROLE_Provider"));
                userRolesRepository.save(new UserRole("Oner", "ROLE_Receiver"));
                System.out.println("==== Printing User Roles ====");
                for (UserRole userRole : userRolesRepository.findAll()) {
                    System.out.println("User Role:" + userRole.getUserID() + "...." + userRole.getRole());
                }
                
                //Create Sample Offerings
                OfferingRepository offeringRepository = app.getBean(OfferingRepository.class);
                Offering offering1 = new Offering(1, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
                offering1.setUser(user1);
                offeringRepository.save(offering1);
                Offering offering2 = new Offering(2, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
                offering2.setUser(user2);
                offeringRepository.save(offering2);
                
                System.out.println("==== Printing Offerings ====");
                for (Offering offering : offeringRepository.findAll()) {
                    System.out.println("Offering:" + offering);
                }
                
               //Create Sample Bookings
                BookingRepository bookingRepository = app.getBean(BookingRepository.class);
                bookingRepository.save(new Booking((long)1, (long)1));
                bookingRepository.save(new Booking((long)2, (long)2));
                
                System.out.println("==== Printing Bookings ====");
                for (Booking booking : bookingRepository.findAll()) {
                    System.out.println("Booking:" + booking);
                }
	}
}
