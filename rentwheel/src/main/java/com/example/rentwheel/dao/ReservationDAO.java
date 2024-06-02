package com.example.rentwheel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.rentwheel.pojo.Reservation;

@Repository
public class ReservationDAO {
	
	public List<Reservation> getAllReservations() {
        try (Session session = DAO.getSessionFactory().openSession()) {
            List<Reservation> reservationList = session.createQuery("from Reservation").list();
            return reservationList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveReservation(Reservation reservation) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(reservation);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(Long reservationId) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, reservationId);
            if (reservation != null) {
                session.remove(reservation);
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Reservation getReservationById(Long reservationId) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            return session.get(Reservation.class, reservationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
