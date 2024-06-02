package com.example.rentwheel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.rentwheel.dao.CarDAO;
import com.example.rentwheel.pojo.Car;

@Controller
public class CarController {


	@Autowired
	CarDAO cardao;


	@GetMapping("/admin/manage-cars")
	public ModelAndView viewCars(CarDAO cardao){

		return new ModelAndView("manage-cars","carlist",cardao.getAllCars());
	}



	@GetMapping("/admin/manage-cars/add-car")
	public String addCar(Model model) {

		Car car = new Car();

		model.addAttribute("car", car);

		return "add-car";
	}

	@PostMapping("/admin/manage-cars/add-car/success")
	public String addedcar(@ModelAttribute("car") Car car) {

		cardao.saveCar(car);

		return "redirect:/admin/manage-cars";
	}


	
	@PostMapping("/admin/manage-cars/delete-car/{carId}")
    public String deleteCar(@PathVariable("carId") int carId, RedirectAttributes redirectAttributes) {
        cardao.deleteCar(carId);
        redirectAttributes.addFlashAttribute("successMessage", "Car deleted successfully!");
        return "redirect:/admin/manage-cars";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", "Error deleting car: " + e.getMessage());
        return "redirect:/admin/manage-cars";
    }
    
    @GetMapping("/admin/manage-cars/update-car/{carId}")
    public String updateCarForm(@PathVariable("carId") int carId, Model model) {
        Car car = cardao.getCarById(carId);
        model.addAttribute("car", car);
        return "update-car";
    }

    @PostMapping("/admin/manage-cars/update-car/success")
    public String updateCar(@ModelAttribute("car") Car car) {
        cardao.updateCar(car);
        return "redirect:/admin/manage-cars";
    }

}
