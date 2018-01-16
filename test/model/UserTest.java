/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
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
public class UserTest {
    
    public UserTest() {
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
    
    @Test
    public void testCreateUser() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(1, "email@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        assertEquals(1, user.getId());
        assertEquals("email@email.com", user.getEmail());
        assertEquals("$12$asd=", user.getPassword());
        assertEquals("First", user.getFirstName());
        assertEquals("Last", user.getLastName());
        assertEquals(currentTimestamp, user.getRegisterDate());
    }
    
    @Test
    public void testChangeUserId() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(1, "email@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        assertEquals(1, user.getId());
        
        user.setId(3);
        assertEquals(3, user.getId());
    }
    
    @Test
    public void testChangeUserEmail() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(1, "email@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        assertEquals("email@email.com", user.getEmail());
        
        user.setEmail("newemail@changedemails.net");
        assertEquals("newemail@changedemails.net", user.getEmail());
    }
    
    @Test
    public void testChangeUserPassword() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(1, "email@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        assertEquals("$12$asd=", user.getPassword());
        
        user.setPassword("pass");
        assertEquals("pass", user.getPassword());
    }
    
    @Test
    public void testChangeUserFirstName() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(1, "email@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        assertEquals("First", user.getFirstName());
        
        user.setFirstName("otherFirstName");
        assertEquals("otherFirstName", user.getFirstName());
    }
    
    @Test
    public void testChangeUserSecondName() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(1, "email@email.com", "$12$asd=", "First", "Last", currentTimestamp);
        assertEquals("Last", user.getLastName());
        
        user.setLastName("someLastName");
        assertEquals("someLastName", user.getLastName());
    }
}
