import controllers.UserController;
import daos.UserDao;
import daos.UserDaoImp;
import services.UserService;

public class JavalinDriver
{

    private static UserDao ud = new UserDaoImp();
    private static UserService us = new UserService(ud);
    private static UserController uc = new UserController(us);

    public static void main(String[] args)
    {


    }
}
