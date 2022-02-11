package routes;

import controllers.UserController;
import io.javalin.Javalin;

public class UserRoute extends Route
{
    private UserController uc;

    public UserRoute(UserController uc){
        this.uc = uc;
    }

    @Override
    public void registerLocalRoutes(Javalin app)
    {
        app.get("/user", uc.getAllUser);
        app.get("/user/{id}", uc.getUserById);
        app.post("/user", uc.createUser);
    }

}

