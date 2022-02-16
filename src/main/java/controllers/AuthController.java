package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;
import models.User;
import services.AuthService;
import services.UserService;

public class AuthController {

    private AuthService as;
    private UserService us;
    private final ObjectMapper mapper = new ObjectMapper();

    public AuthController(AuthService as, UserService us) {
        this.as = as;
        this.us = us;
    }

    public Handler login = context -> {

        LoginObject lo = mapper.readValue(context.body(), LoginObject.class);

        if(!as.loginUser(lo.email, lo.password)) {
            context.status(403);
            context.result("Email or password is incorrect");
        }

        User u = us.getUserByEmail(lo.email);

        context.req.getSession().setAttribute("user-id", "" + u.getUserID());
        context.req.getSession().setAttribute("logged-in", u.getEmail());
        context.req.getSession().setAttribute("user-role", "" + u.getRole());

        context.header("user-id", "" + u.getUserID());
        context.header("logged-in", u.getEmail());
        context.header("user-role", "" + u.getRole());

        context.result("You Are Signed In!");
    };

    public Handler verify = context -> {
        context.header("Access-Control-Expose-Headers", "*");

        if(context.req.getSession().getAttribute("id") == null) {
            context.status(400);
            context.result("User not logged in");
        }
        else {
            context.header("pid", "" + context.req.getSession().getAttribute("id"));
            context.result("User verified");
        }
    };

    public Handler logout = context -> {
        context.req.getSession().invalidate();
        context.status(200);
        context.result("Logged out");
    };

}

class LoginObject {
    public String email;
    public String password;
}
