import daos.*;
import models.*;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeReimbursementDriver {

    public static void main(String[] args){


        /*private UserRole role;
    private String username;
    private String password;
    private String first;
    private String last;
    private String email;

    ---

    private User employee;
    private ReimbursementType type;
    private double amount;
    private boolean submit;
    private String resolvedBy;
    private String description;
    private ReimbursementStatus status;
        * */

            UserDao u = new UserDaoImp();
            ReimbursementDao r = new ReimbursementDaoImp();
            User user = new User("username", "password" , "first", "last", "something@email.com", UserRole.EMPLOYEE);
           // Reimbursement reim = new Reimbursement(user, ReimbursementType.FOOD, 55.55, false, "dude", "sushi", ReimbursementStatus.APPROVED);


            //r.createReimbursement(reim);
            //u.createUser(user);


    }
}
