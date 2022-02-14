import controllers.AuthController;
import controllers.ReimbursementController;
import controllers.UserController;
import daos.ReimbursementDao;
import daos.ReimbursementDaoImp;
import daos.UserDao;
import daos.UserDaoImp;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import routes.AuthRoute;
import routes.ReimbursementRoute;
import routes.Route;
import routes.UserRoute;
import services.AuthService;
import services.ReimbursementService;
import services.UserService;

public class JavalinDriver {

    private static UserDao ud = new UserDaoImp();
    private static UserService us = new UserService(ud);
    private static UserController uc = new UserController(us);

    private static ReimbursementDao rd = new ReimbursementDaoImp();
    private static ReimbursementService rs = new ReimbursementService(rd);
    private static ReimbursementController rc = new ReimbursementController(rs, us);

    private static AuthService as = new AuthService(ud);
    private static AuthController ac = new AuthController(as, us);

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        Route user = new UserRoute(uc);
        Route reimbursement = new ReimbursementRoute(rc);
        Route auth = new AuthRoute(ac);



        Route.establishRoutes(app, user, reimbursement, auth);
        app.start(7000);
    }
}
