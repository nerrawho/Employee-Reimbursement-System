package services;

import daos.ReimbursementDao;

import daos.UserDao;
import junit.framework.TestCase;
import models.Reimbursement;
import models.ReimbursementType;
import models.User;
import models.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


public class ReimbursementServiceTest extends TestCase {


    @Before
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    static ReimbursementDao rd;

    @InjectMocks
    private static ReimbursementService rs = new ReimbursementService(rd);

    @Spy static UserDao ud;

    @InjectMocks
    private static UserService us;



    public void testCreateReimbursementReturnsReimbursement() {
        User test = new User("username", "password", "first", "last", "email", UserRole.EMPLOYEE);
        Reimbursement test_reimbursement = new Reimbursement();
        assertTrue(rs.createReimbursement(test, "food", 55.55, "this is a test"));
    }

    @Test
    public void testGetReimbursementByEmployee() {
    }

    @Test
    public void testGetReimbursementByType() {
    }

    @Test
    public void testGetReimbursementByStatus() {
    }

    @Test
    public void testGetAllReimbursement() {
    }

    @Test
    public void testUpdateReimbursement() {
    }

    @Test
    public void testDeleteReimbursement() {
    }
}