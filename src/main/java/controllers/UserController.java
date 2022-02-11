package controllers;
import models.User;
import services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;



public class UserController
{

    private UserService us;
    private ObjectMapper mapper = new ObjectMapper();

    public UserController(UserService us){
        this.us = us;
    }

    public Handler createUser = (context) ->
    {

        User u = mapper.readValue(context.body(), User.class);

        System.out.println(u);

        us.createUser(u.getUsername(),u.getPassword(),u.getFirst(),u.getLast(), u.getRole());

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

    public Handler deleteUser = (context) ->
    {

    };

    public Handler updateUser = (context) ->
    {

    };
}