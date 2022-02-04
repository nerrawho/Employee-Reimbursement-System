package daos;

import models.User;

public interface UserDao {

    public boolean createEmployee(User e);
    public boolean createManager(User m);


}
