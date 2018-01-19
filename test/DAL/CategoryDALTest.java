/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Category;
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
public class CategoryDALTest {
    
    public CategoryDALTest() {
        super();
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
     * Test of selectAll method, of class CategoryDAL.
     */
    @Test
    public void testSelectAll() {
        CategoryDAL instance = new CategoryDAL();
        List<Category> result = instance.selectAll();
        assertTrue(result != null);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of selectById method, of class CategoryDAL.
     */
    @Test
    public void testSelectById() {
        int id = 0;
        CategoryDAL instance = new CategoryDAL();
        Category expResult = null;
        Category result = instance.selectById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectByName method, of class CategoryDAL.
     */
    @Test
    public void testSelectByName() {
        String name = "category0";
        CategoryDAL instance = new CategoryDAL();
        Category expResult = null;
        Category result = instance.selectByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class CategoryDAL.
     */
    @Test
    public void testInsert() {
        Category category = new Category(1, "category3", "info about this category", new ArrayList<>());
        CategoryDAL instance = new CategoryDAL();
        int expResult = 1;
        int result = instance.insert(category);
        Category newCategory = instance.selectByName("category3");
        instance.delete(newCategory.getId());
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class CategoryDAL.
     */
    @Test
    public void testUpdate() {
        Category category = new Category(1, "category5", "info about this category", new ArrayList<>());
        CategoryDAL instance = new CategoryDAL();
        instance.insert(category);
        category = instance.selectByName("category5");
        category.setDescription("other info about this category");
        int expResult = 1;
        int result = instance.update(category);
        instance.delete(category.getId());
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class CategoryDAL.
     */
    @Test
    public void testDelete() {
        Category category = new Category(1, "category5", "info about this category", new ArrayList<>());
        CategoryDAL instance = new CategoryDAL();
        instance.insert(category);
        category = instance.selectByName("category5");
        int expResult = 1;
        int result = instance.delete(category.getId());
        assertEquals(expResult, result);
    }
}
