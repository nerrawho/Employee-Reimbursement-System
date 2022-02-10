package routes;

import controllers.AuthController;
import io.javalin.Javalin;

public class AuthRoute extends Route {

    private AuthController ac;

    public AuthRoute(AuthController ac) {
        this.ac = ac;
    }

    @Override
    public void registerLocalRoutes(Javalin app) {
        app.post("/login", ac.login);
        app.get("/verify", ac.verify);
        app.get("/logout", ac.logout);
    }
}
