package services;

import daos.UserDao;
import models.User;
import utils.LoggingSingleton;

public class AuthService {

    private UserDao ud;

    public AuthService(UserDao ud) {
        this.ud = ud;
    }

    public boolean loginUser(String email, String password) {
        User login = ud.readUserByEmail(email);

        if(login == null || !login.getPassword().equals(password)) {
            LoggingSingleton.logger.info("Login Denied: " + email);
            return false;
        }
        LoggingSingleton.logger.info("Login Approved: " + email);
        return true;
    }
}

