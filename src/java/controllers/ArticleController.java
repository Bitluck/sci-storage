/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAL.ArticleDAL;
import java.util.List;
import model.Article;

/**
 *
 * @author Администратор
 */
public class ArticleController {
    protected ArticleDAL articleDal;

    public ArticleController() {
        articleDal = new ArticleDAL();
    }
    
    public List<Article> getAllArticle() {
        return articleDal.selectAll();
    }
    
    public Article getArticleById(int id) {
        return articleDal.selectById(id);
    }
    
    public List<Article> getArticleByTitle(String part) {
        return articleDal.selectByTitle(part);
    }
    
    public List<Article> getArticleByTag(String tag) {
        return articleDal.selectByTag(tag);
    }
    
    public List<Article> getArticleByCategory(int categoryId) {
        return articleDal.selectByCategory(categoryId);
    }
    
    public int insert(Article article) {
        return articleDal.insert(article);
    }
    
    public int update(Article article) {
        return articleDal.update(article);
    }
    
    public int delete(int id) {
        return articleDal.delete(id);
    }
}
