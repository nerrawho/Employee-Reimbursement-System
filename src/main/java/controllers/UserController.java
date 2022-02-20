package controllers;
import io.javalin.http.Context;
import models.User;
import services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;
import utils.LoggingSingleton;

import java.util.Locale;

import static controllers.AuthController.sessionUser;


public class UserController
{

    private UserService us;
    private ObjectMapper mapper = new ObjectMapper();

    public UserController(UserService us)
    {
        this.us = us;
    }

    public Handler createUser = (context) ->
    {

        User u = mapper.readValue(context.body(), User.class);

        System.out.println(u);

        us.createUser(u.getUsername(), u.getPassword(), u.getFirst(), u.getLast(), u.getRole());

        context.result(mapper.writeValueAsString(u));

    };

    public Handler getAllUser = (context) ->
    {
        context.result(mapper.writeValueAsString(us.getAllUser()));
    };

    public Handler getUserById = (context) ->
    {
        User u = sessionUser;

        context.result(mapper.writeValueAsString(us.getUserById(u.getUserID())));

    };
    public Handler getUserByEmail = (context) ->
    {
        String userParam = String.valueOf(context.pathParam("email"));
        context.result(mapper.writeValueAsString(us.getUserByEmail("")));

    };

    public Handler updateUser = (context) ->
    {
        User u = sessionUser;

        try
        {
            UpdateInfo update = mapper.readValue(context.body(), UpdateInfo.class);

            String first = update.first.trim().toLowerCase();
            String last = update.last.trim().toLowerCase();
            String username = update.username.trim().toLowerCase();
            String password = update.password.trim();

            if(first != null && first.length() > 0)
                u.setFirst(first);
            if(last != null && last.length() > 0)
                u.setLast(last);
            if(username != null && username.length() > 0)
                u.setUsername(username);
            if(password != null && password.length() > 0)
                u.setPassword(password);

            us.updateUser(u);

        } catch (Exception e)
        {
            context.status(400);
            e.printStackTrace();
        }
    };

    public Handler deleteUser = (context) ->
    {
        String userParam = String.valueOf(context.req.getSession().getAttribute("delete"));
        try
        {
            mapper.readValue(context.body(), User.class);

            User user = us.getUserByEmail(userParam);

            LoggingSingleton.logger.info(user.getRole() + " " + user.getFirst() + " " + user.getLast() +
                    "was deleted");
            context.result(mapper.writeValueAsString(us.deleteUser(user)));
        } catch (Exception e)
        {
            context.status(400);
            e.printStackTrace();
        }
    };

}

class UpdateInfo {
    public String first;
    public String last;
    public String username;
    public String password;
}