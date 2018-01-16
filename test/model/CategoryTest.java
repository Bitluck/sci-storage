/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class CategoryTest {
    
    public CategoryTest() {
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
    public void testCreateCategory() {
        Category category = new Category(1, "category1", "info about this category", new ArrayList<>());
        assertEquals(1, category.getId());
        assertEquals("category1", category.getName());
        assertEquals("info about this category", category.getDescription());
        assertEquals(new ArrayList<>(), category.getArticles());
    }
    
    @Test
    public void testChangeCategoryId() {
        Category category = new Category(1, "category1", "info about this category", new ArrayList<>());
        assertEquals(1, category.getId());
        
        category.setId(3);
        assertEquals(3, category.getId());
    }
    
    @Test
    public void testChangeCategoryName() {
        Category category = new Category(1, "category1", "info about this category", new ArrayList<>());
        assertEquals("category1", category.getName());
        
        category.setName("newName");
        assertEquals("newName", category.getName());
    }
    
    @Test
    public void testChangeCategoryDescription() {
        Category category = new Category(1, "category1", "info about this category", new ArrayList<>());
        assertEquals("info about this category", category.getDescription());
        
        category.setDescription("info about this category with new name");
        assertEquals("info about this category with new name", category.getDescription());
    }
    
    @Test
    public void testChangeCategoryArticles() {
        Category category = new Category(1, "category1", "info about this category", new ArrayList<>());
        assertEquals(new ArrayList<>(), category.getArticles());
        
        ArrayList<Article> newArticles = new ArrayList<>();
        newArticles.add(new Article());
        
        category.setArticles(newArticles);
        assertEquals(newArticles, category.getArticles());
    }
}
