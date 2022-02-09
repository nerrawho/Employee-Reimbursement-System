package controllers;

import io.javalin.http.Context;
import models.User;
import services.UserService;

import java.util.List;

public class UserController
{
    private final UserService userService = new UserService();

    public void handleGetAll(Context ctx)
    {
        List<User> uList = userService.getAllUser();
        ctx.json(uList);
    }

    public void handleGetOne(Context ctx)
    {
        String idParam = ctx.pathParam("id");
        int id = Integer.parseInt(idParam);
        User user = userService.getUserById(id);
        ctx.json(user);
    }

    public void handleUpdate(Context ctx)
    {
        String idParam = ctx.pathParam("id");
        User userToUpdate = ctx.bodyAsClass(User.class);
        int idToUpdate = Integer.parseInt(idParam);
        userToUpdate.setUserID(idToUpdate);

        boolean success = userService.updateUser(userToUpdate);
        if(success)
        {
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }

    public void handleCreate(Context ctx)
    {
        User newUser = ctx.bodyAsClass(User.class);
        boolean success = userService.createUser(newUser);

        if(success)
        {
            ctx.status(201);
        } else{
            ctx.status(400);
        }
    }

    public void handleDelete(Context ctx)
    {
        ctx.status(405);
    }
}
