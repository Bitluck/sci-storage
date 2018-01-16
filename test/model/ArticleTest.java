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
public class ArticleTest {
    
    public ArticleTest() {
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
    public void testCreateArticle() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Article article = new Article(1, "title", "author1, author2", currentTimestamp, new User());
        assertEquals(1, article.getId());
        assertEquals("title", article.getTitle());
        assertEquals("author1, author2", article.getAuthors());
        assertEquals(currentTimestamp, article.getUploadDate());
    }
    
    @Test
    public void testChangeArticleId() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Article article = new Article(1, "title", "author1, author2", currentTimestamp, new User());
        assertEquals(1, article.getId());
        
        article.setId(3);
        assertEquals(3, article.getId());
    }
    
    @Test
    public void testChangeArticleTitle() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Article article = new Article(1, "title", "author1, author2", currentTimestamp, new User());
        assertEquals("title", article.getTitle());
        
        article.setTitle("newTitle");
        assertEquals("newTitle", article.getTitle());
    }
    
    @Test
    public void testChangeArticleAuthors() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Article article = new Article(1, "title", "author1, author2", currentTimestamp, new User());
        assertEquals("author1, author2", article.getAuthors());
        
        article.setAuthors("otherAuthor1, sameAuthor2");
        assertEquals("otherAuthor1, sameAuthor2", article.getAuthors());
    }
}
