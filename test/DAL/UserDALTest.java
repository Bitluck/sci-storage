/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Timestamp;
import java.util.List;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Администратор
 */
public class UserDALTest {
    
    public UserDALTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of selectAll method, of class UserDAL.
     */
    @Test
    public void testSelectAll() {
        UserDAL dal = new UserDAL();
        List<User> list = dal.selectAll();
        assertTrue(list != null && list.size() > 0);
    }

    /**
     * Test of selectById method, of class UserDAL.
     */
    @Test
    public void testSelectById() {
        int id = 0;
        UserDAL instance = new UserDAL();
        User expResult = null;
        User result = instance.selectById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectByEmail method, of class UserDAL.
     */
    @Test
    public void testSelectByEmail() {
        String email = "asd@asd.asd1";
        UserDAL instance = new UserDAL();
        User expResult = null;
        User result = instance.selectByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class UserDAL.
     */
    @Test
    public void testInsert() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(10, "email@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        UserDAL instance = new UserDAL();
        int expResult = 1;
        int result = instance.insert(user);
        User newUser = instance.selectByEmail("email@email.com");
        instance.delete(newUser);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class UserDAL.
     */
    @Test
    public void testUpdate() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(11, "email1@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        UserDAL instance = new UserDAL();
        instance.insert(user);
        user = instance.selectByEmail("email1@email.com");
        System.out.print(user);
        user.setFirstName("newFirstName");
        int expResult = 1;
        int result = instance.update(user);
        instance.delete(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class UserDAL.
     */
    @Test
    public void testDelete() {
        User user = null;
        UserDAL instance = new UserDAL();
        int expResult = 0;
        int result = instance.delete(user);
        assertEquals(expResult, result);
    }
}
