package com.example.rentwheel.dao;

import java.util.List;

import org.hibernate.Session;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.rentwheel.pojo.User;
import com.example.rentwheel.util.PasswordUtility;

import jakarta.persistence.Query;


@Repository
public class UserDAO {


	public void saveUser(User user) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public boolean isEmailExists(String email) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            String hql = "FROM User WHERE email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);

            return !query.getResultList().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean checkPassword(String email, String password) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            User user = getUserByEmail(email);
            return PasswordUtility.checkPassword(user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUserByEmail(String email) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            String hql = "FROM User WHERE email = :email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);

            List<User> resultList = query.getResultList();
            return resultList.isEmpty() ? null : resultList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
