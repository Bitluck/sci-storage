/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Article;
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
public class ArticleDALTest {
    
    public ArticleDALTest() {
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
     * Test of selectAll method, of class ArticleDAL.
     */
    @Test
    public void testSelectAll() {
        ArticleDAL instance = new ArticleDAL();
        List<Article> result = instance.selectAll();
        assertTrue(result != null);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of selectById method, of class ArticleDAL.
     */
    @Test
    public void testSelectById() {
        int id = 0;
        ArticleDAL instance = new ArticleDAL();
        Article expResult = null;
        Article result = instance.selectById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of selectByName method, of class ArticleDAL.
     */
    @Test
    public void testSelectByTitle() {
        String title = "title0";
        ArticleDAL instance = new ArticleDAL();
        List<Article> expResult = new ArrayList<>();
        List<Article> result = instance.selectByTitle(title);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of selectByName method, of class ArticleDAL.
     */
    @Test
    public void testSelectByCategory() {
        int category = 0;
        ArticleDAL instance = new ArticleDAL();
        Article expResult = null;
        Article result = instance.selectByCategory(category);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class ArticleDAL.
     */
    @Test
    public void testInsert() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Article article = new Article(10, 1, 2, "title0", "author1, author2", currentTimestamp, "/path/7.pdf");
        ArticleDAL instance = new ArticleDAL();
        int expResult = 1;
        int result = instance.insert(article);
        List<Article> newArticles = instance.selectByTitle("title0");
        instance.delete(newArticles.get(0));
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ArticleDAL.
     */
    @Test
    public void testUpdate() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Article article = new Article(1, 1, 2, "title0", "author1, author2", currentTimestamp, "/path/1.pdf");
        ArticleDAL instance = new ArticleDAL();
        instance.insert(article);
        List<Article> articles = instance.selectByTitle("title0");
        article = articles.get(0);
        article.setPath("/path/7.pdf");
        int expResult = 1;
        int result = instance.update(article);
        instance.delete(article);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class ArticleDAL.
     */
    @Test
    public void testDelete() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Article article = new Article(1, 1, 2, "title0", "author1, author2", currentTimestamp, "/path/1.pdf");
        ArticleDAL instance = new ArticleDAL();
        instance.insert(article);
        List<Article> articles = instance.selectByTitle("title0");
        article = articles.get(0);
        int expResult = 1;
        int result = instance.delete(article);
        assertEquals(expResult, result);
    }
}
