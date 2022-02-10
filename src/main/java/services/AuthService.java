package services;

import daos.UserDao;
import models.User;

public class AuthService {

    private UserDao ud;

    public AuthService(UserDao ud) {
        this.ud = ud;
    }

    public boolean loginUser(String email, String password) {
        User login = ud.readUserByEmail(email);

        if(login == null || !login.getPassword().equals(password)) {
            return false;
        }
        return true;
    }
}

