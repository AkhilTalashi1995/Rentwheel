package com.example.rentwheel.controller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rentwheel.dao.CarDAO;
import com.example.rentwheel.dao.ReservationDAO;
import com.example.rentwheel.pojo.Car;
import com.example.rentwheel.pojo.Reservation;

@Controller
@RequestMapping("/user")
public class ReservationController {

	@Autowired
    private CarDAO carDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        List<String> cities = carDAO.getAllCities();
        model.addAttribute("cities", cities);
        return "user-home";
    }

    @PostMapping("/search")
    public String searchCars(@RequestParam("city") String city,
                             @RequestParam("pickupDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDate,
                             @RequestParam("returnDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate returnDate,
                             Model model) {
        List<Car> availableCars = carDAO.getAvailableCars(pickupDate, returnDate);
        model.addAttribute("availableCars", availableCars);
        return "book-car";
    }

    @GetMapping("/book-car")
    public String showBookCarPage(@RequestParam("carId") int carId, Model model) {
        Car car = carDAO.getCarById(carId);
        model.addAttribute("car", car);
        return "book-car";
    }

    @PostMapping("/book-car")
    public String bookCar(@RequestParam("carId") int carId,
                          @RequestParam("pickupDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate pickupDate,
                          @RequestParam("returnDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate returnDate,
                          Model model) {
        Car car = carDAO.getCarById(carId);

        if (car == null) {
            
            return "redirect:/error";
        }

        Reservation reservation = new Reservation();
        reservation.setCar(car);
        reservation.setPickupDate(pickupDate);
        reservation.setReturnDate(returnDate);

        try {
            reservationDAO.saveReservation(reservation);
            return "redirect:/user/reservations";
        } catch (DateTimeException e) {
           
            return "redirect:/error";
        }
    }

    @GetMapping("/reservations")
    public String showReservations(Model model) {
        List<Reservation> userReservations = reservationDAO.getAllReservations();
        model.addAttribute("userReservations", userReservations);
        return "user-reservations";
    }

    @PostMapping("/cancel-reservation")
    public String cancelReservation(@RequestParam("reservationId") Long reservationId, Model model) {
        reservationDAO.deleteReservation(reservationId);
        return "redirect:/user/reservations";
    }
}
