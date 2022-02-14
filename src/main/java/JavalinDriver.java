import controllers.UserController;
import daos.UserDao;
import daos.UserDaoImp;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import routes.Route;
import services.UserService;

public class JavalinDriver {

    public static void main(String[] args) {
        Javalin app = Javalin.create();


        Route.establishRoutes(app);
        app.start(7000);
    }
}
