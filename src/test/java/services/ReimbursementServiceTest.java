package services;

import daos.ReimbursementDao;

import junit.framework.TestCase;
import models.Reimbursement;
import models.ReimbursementStatus;
import models.ReimbursementType;
import models.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class ReimbursementServiceTest extends TestCase {


    @Before
    void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    static ReimbursementDao rd;

    @InjectMocks
    private static ReimbursementService rs;



    public void testCreateReimbursementReturnsReimbursement() {

        //Reimbursement test = rs.createReimbursement(new User(), ReimbursementType.FOOD,55.55, , "Steve", new Date(System.currentTimeMillis()), "Golden Carrots", ReimbursementStatus.APPROVED);

        //assertNotNull(test);
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