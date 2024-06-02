package com.example.rentwheel.util;

import com.example.rentwheel.pojo.User;

public class PasswordUtility {
	
	public static boolean checkPassword(User user, String password) {
        return user != null && user.getPassword().equals(password);
    }

}
