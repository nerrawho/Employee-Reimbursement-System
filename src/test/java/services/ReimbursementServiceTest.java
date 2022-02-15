package services;

import daos.ReimbursementDao;
import daos.UserDao;
import models.Reimbursement;
import models.User;
import models.UserRole;
import org.junit.*;
import org.mockito.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


public class ReimbursementServiceTest {


    @Mock
    static ReimbursementDao rd;

    @InjectMocks
    private static ReimbursementService rs;

    @Mock
    static UserDao ud;

    @InjectMocks
    private static UserService us;

    @Before
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateReimbursementReturnsReimbursement() {

        when(rd.createReimbursement(any())).thenReturn(true);
        User testUser = new User("username", "password", "first", "last", "email", UserRole.EMPLOYEE);
        boolean test = rs.createReimbursement(testUser, "food", 55.55, "this is a test");
        Mockito.verify(rd).createReimbursement(any());
        assertTrue(test);
    }

    @Test
    public void testGetReimbursementByEmployee() {
        User testUser = new User("username", "password", "first", "last", "email", UserRole.EMPLOYEE);
        testUser.setUserID(1);
        List<Reimbursement> test = rs.getReimbursementByEmployee(testUser);
        assertNotNull(test);
    }

    @Test
    public void testGetReimbursementByType() {
        List<Reimbursement> test = rs.getReimbursementByType(any());
        assertNotNull(test);
    }

    @Test
    public void testGetReimbursementByStatus() {
        List<Reimbursement> test = rs.getReimbursementByStatus(any());
        assertNotNull(test);
    }

    @Test
    public void testGetAllReimbursement() {
        List<Reimbursement> test = rs.getAllReimbursement();
        assertNotNull(test);
    }

    @Test
    public void testUpdateReimbursement() {
    }

    @Test
    public void testDeleteReimbursement() {

    }

    @Test
    public void testGetPendingForEmployee() {
        User testUser = new User("username", "password", "first", "last", "email", UserRole.EMPLOYEE);
        testUser.setUserID(1);
        List<Reimbursement> test = rs.getPendingForEmployee(testUser);
        assertNotNull(test);
    }

    @Test
    public void testGetResolvedForEmployee() {
        User testUser = new User("username", "password", "first", "last", "email", UserRole.EMPLOYEE);
        testUser.setUserID(1);
        List<Reimbursement> test = rs.getResolvedForEmployee(testUser);
        assertNotNull(test);
    }

    @Test
    public void testGetAllPendingReimbursement() {
        List<Reimbursement> test = rs.getAllPendingReimbursement();
        assertNotNull(test);
    }

    @Test
    public void testGetAllResolvedReimbursement() {
        List<Reimbursement> test = rs.getAllResolvedReimbursement();
        assertNotNull(test);
    }
}