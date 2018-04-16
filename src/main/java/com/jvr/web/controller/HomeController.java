package com.jvr.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jvr.entity.Booking;
import com.jvr.entity.Offering;
import com.jvr.entity.User;
import com.jvr.entity.UserRole;
import com.jvr.repo.BookingRepository;
import com.jvr.repo.OfferingRepository;
import com.jvr.repo.ServiceRepository;
import com.jvr.repo.UserRepository;
import com.jvr.repo.UserRolesRepository;

@Controller     
public class HomeController {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private UserRolesRepository rolesRepo;
    
    @Autowired
    private OfferingRepository offeringRepo;
    
    @Autowired
    private ServiceRepository serviceRepo;
    
    @Autowired
    private BookingRepository bookingRepo;

 
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showHomePage(ModelMap model, HttpServletRequest request) {
        UserRole userRole = rolesRepo.findByUserID(request.getUserPrincipal().getName());
        System.out.println("Message from Home Controller User Name:" + request.getUserPrincipal().getName() + "...User role:" + userRole.getRole());
        model.addAttribute("fromcontroller", "Message from Web Controller");
        if ("ROLE_PROVIDER".equalsIgnoreCase(userRole.getRole())) {
            model.addAttribute("offering", new Offering());
            model.addAttribute("serviceTypes", serviceRepo.findAll());
            return "providerhome";
        } else if ("ROLE_RECEIVER".equalsIgnoreCase(userRole.getRole())) {
            model.addAttribute("offerings", offeringRepo.findAll());
            return "receiverhome";
        }
        return "home";
    }
    
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        System.out.println("Message from Home Controller for hello page");
        model.addAttribute("fromcontroller", "Message from Web Controller for hello page");
        return "hello";
    }
    
    @RequestMapping(value="/saveserviceoffer", method = RequestMethod.POST)
    public String saveServiceOffer(@ModelAttribute Offering offering, HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        System.out.println("Message from Save Service Offer:" +  request.getParameter("serviceID") + "..Start time:" + request.getParameter("starttime"));
        String sStartTime = request.getParameter("starttime");
        String sEndTime = request.getParameter("endtime");
        try {
            System.out.println("sStartTime:" + sStartTime + "...Formatted date:" + sdf.parse(sStartTime));
        
        
        User user = userRepo.findByUserID(request.getUserPrincipal().getName());
        offering.setUser(user);
        Offering o1 = new Offering();
        o1.setServiceID(Integer.parseInt(request.getParameter("serviceID")));
        o1.setStartTime(sdf.parse(sStartTime));
        o1.setEndTime(sdf.parse(sEndTime));
        o1.setUser(user);
        offeringRepo.save(o1);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "providerhome";
    }
    
    @RequestMapping(value="/savebooking", method = RequestMethod.POST)
    public String saveBooking(HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        System.out.println("Message from Save Booking:" +  request.getParameter("offeringid"));
        User user = userRepo.findByUserID(request.getUserPrincipal().getName());
        Booking booking = new Booking(Long.parseLong(request.getParameter("offeringid")), user.getId());
        bookingRepo.save(booking);
        
        System.out.println("==== Printing Bookings post save ====");
        for (Booking booking1 : bookingRepo.findAll()) {
            System.out.println("Booking:" + booking1);
        }
        
        return "receiverhome";
    }
    
}
