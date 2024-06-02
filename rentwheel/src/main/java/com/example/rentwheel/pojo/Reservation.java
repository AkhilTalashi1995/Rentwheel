package com.example.rentwheel.pojo;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Component
@Entity
public class Reservation {
	  
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

		  @ManyToOne
		    @JoinColumn(name = "user_id", nullable = false)
		    private User user;

		    @ManyToOne
		    @JoinColumn(name = "car_id", nullable = false)
		    private Car car;

		    private String brand;
		    private String model;
		    private String state;
		    private String city;
		    private String address;
		    private int rate;
		    
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

			@Column(name = "pickupDate", nullable = false)
			private LocalDate pickupDate;
			
		    @Column(name = "returnDate", nullable = false)
			private LocalDate returnDate;
//		    @Temporal(TemporalType.TIMESTAMP)
//		    private Date pickupDate;
//		    
//		    @Temporal(TemporalType.TIMESTAMP)
//		    private Date returnDate;
		
		    public Reservation() {
				//Do not touch
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			public Car getCar() {
				return car;
			}

			public void setCar(Car car) {
				this.car = car;
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

//			public Date getPickupDate() {
//				return pickupDate;
//			}
//
//			public void setPickupDate(Date pickupDate) {
//				this.pickupDate = pickupDate;
//			}
//
//			public Date getReturnDate() {
//				return returnDate;
//			}
//
//			public void setReturnDate(Date returnDate) {
//				this.returnDate = returnDate;
//			}

		
		    
		    
		    
		    

}
