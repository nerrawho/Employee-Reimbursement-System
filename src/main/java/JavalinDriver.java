import controllers.ReimbursementController;
import controllers.UserController;
import daos.ReimbursementDao;
import daos.ReimbursementDaoImp;
import daos.UserDao;
import daos.UserDaoImp;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import routes.Route;
import services.ReimbursementService;
import services.UserService;

public class JavalinDriver {

    private static ReimbursementDao rd = new ReimbursementDaoImp();
    private static ReimbursementService rs = new ReimbursementService(rd);
    //private static ReimbursementController rc = new ReimbursementController(rs, us);

    public static void main(String[] args) {
        Javalin app = Javalin.create();


        Route.establishRoutes(app);
        app.start(7000);
    }
}
