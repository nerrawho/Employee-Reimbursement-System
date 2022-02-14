package controllers;
import io.javalin.http.Context;
import models.User;
import services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;
import utils.LoggingSingleton;


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

        Integer id = Integer.parseInt(context.pathParam("id"));

        context.result(mapper.writeValueAsString(us.getUserById(id)));

    };
    public Handler getUserByEmail = (context) ->
    {
        String userParam = String.valueOf(context.pathParam("email"));
        context.result(mapper.writeValueAsString(us.getUserByEmail("")));

    };

    public Handler updateUser = (context) ->
    {
        String userParam = String.valueOf(context.req.getSession().getAttribute("loggedIn"));
        try
        {
            mapper.readValue(context.body(), User.class);

            User user = us.getUserByEmail(userParam);

            LoggingSingleton.logger.info(user.getRole() + " " + user.getFirst() + " " + user.getLast() +
                    " has updated their personal information");

            context.result(mapper.writeValueAsString(us.updateUser(user)));

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
