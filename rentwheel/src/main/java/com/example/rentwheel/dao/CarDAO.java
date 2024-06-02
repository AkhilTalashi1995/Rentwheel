package com.example.rentwheel.dao;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.rentwheel.pojo.Car;

@Repository
public class  CarDAO {

	public List<Car> getAllCars() {
		try (Session session = DAO.getSessionFactory().openSession()) {
			List<Car> CarList = session.createQuery("from Car").list();
			return CarList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveCar(Car car) {
		try (Session session = DAO.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			session.persist(car);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCar(int carId) {
		try (Session session = DAO.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();

			Car car = session.get(Car.class, carId);
			if (car != null) {
				session.remove(car);
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public Car getCarById(int carId) {
	        try (Session session = DAO.getSessionFactory().openSession()) {
	            return session.get(Car.class, carId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public void updateCar(Car car) {
	        try (Session session = DAO.getSessionFactory().openSession()) {
	            Transaction tx = session.beginTransaction();
	            session.merge(car);
	            tx.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<String> getAllCities() {
	        try (Session session = DAO.getSessionFactory().openSession()) {
	            Query<String> query = session.createQuery("SELECT DISTINCT c.city FROM Car c", String.class);
	            return query.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Collections.emptyList();
	        }
	    }
	    
	    public List<Car> getAvailableCars(LocalDate pickupDate, LocalDate returnDate) {
	   
	        String hql = "FROM Car c WHERE c.pickupDate >= :pickupDate AND c.returnDate <= :returnDate";

	        try (Session session =  DAO.getSessionFactory().openSession()) {
	            Query<Car> query = session.createQuery(hql, Car.class)
	                    .setParameter("pickupDate", pickupDate)
	                    .setParameter("returnDate", returnDate);

	            return query.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Collections.emptyList(); 
	        }
	    }

}
