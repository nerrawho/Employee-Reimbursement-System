package routes;

import controllers.UserController;
import io.javalin.Javalin;
import services.UserService;

public class UserRoute extends Route
{
    private UserController uc;
    private UserService us;

    public UserRoute(UserController uc){
        this.uc = uc;
    }

    @Override
    public void registerLocalRoutes(Javalin app)
    {
        app.get("/user", uc.getAllUser);
        app.get("/user/{id}", uc.getUserById);
        app.post("/user", uc.createUser);
        app.get("/user/{email}/update", uc.updateUser);
        app.get("/user/{email}/delete", uc.deleteUser);
    }

}