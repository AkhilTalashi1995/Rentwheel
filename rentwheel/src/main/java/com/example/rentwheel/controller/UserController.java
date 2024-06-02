package com.example.rentwheel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
//
//	@GetMapping("/login")
//	public String logIn(){
//		return"login";
//	}
//	@GetMapping("/signup")
//	public String signUp(){
//		return"signup";
//	}
//	@GetMapping("/admin/home")
//	public String adminHome(){
//		return"admin-home";
//	}
//	
	
//	@GetMapping("/admin/manage-locations/update-location")
//	public String updateLocation(){
//		return"update-location";
//	}
////	@GetMapping("/admin/manage-cars")
//	public String manageCars(){
//		return"manage-cars";
//	}
//	@GetMapping("/admin/manage-cars/add-car")
//	public String addCar(){
//		return"add-car";
//	}
//	@GetMapping("/admin/manage-cars/update-car")
//	public String updateCar(){
//		return"update-car";
//	}
	@GetMapping("/admin/manage-reservations")
	public String manageReservations(){
		return"manage-reservations";
	}
	@GetMapping("/admin/manage-users")
	public String manageUsers(){
		return"manage-users";
	}
	@GetMapping("/admin/profile")
	public String adminProfile(){
		return"admin-profile";
	}
//	@GetMapping("/user/home")
//	public String userHome(){
//		return"user-home";
//	}
//	@GetMapping("/user/reservations")
//	public String userReservations(){
//		return"user-reservations";
//	}
//	@GetMapping("/user/book-car")
//	public String bookCar(){
//		return"book-car";
//	}
	@GetMapping("/user/profile")
	public String userProfile(){
		return"user-profile";
	}
}
