package com.example.rentwheel.pojo;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Component
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carID;
	private String brand;
	private String model;
	private String state;
	@Column(nullable = false)
	private String city;
	private String address;
	private int rate;
	
    @Column(name = "pickupDate", nullable = false)
	private LocalDate pickupDate;
	
    @Column(name = "returnDate", nullable = false)
	private LocalDate returnDate;

//	@Column(nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//    private Date pickupDate;
//    
//	@Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date returnDate;
//	
//	public Date getPickupDate() {
//		return pickupDate;
//	}
//
//	public void setPickupDate(Date pickupDate) {
//		this.pickupDate = pickupDate;
//	}
//
//	public Date getReturnDate() {
//		return returnDate;
//	}
//
//	public void setReturnDate(Date returnDate) {
//		this.returnDate = returnDate;
//	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@OneToMany(mappedBy = "car")
	    private List<Reservation> reservations;
	
	public Car() {
		//don't touch
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
