/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import model.Article;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Администратор
 */
public class ArticleDAL extends BaseDAL {

    public ArticleDAL() {
        super();
    }
    
    public List<Article> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        List<Article> allArticlesList = session.selectList("article.selectAll");
        session.close();
        return allArticlesList;
    }
    
    public Article selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Article article = session.selectOne("article.selectById", id);
        session.close();
        return article;
    }
    
    public List<Article> selectByTitle(String part) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Article> articlesList = session.selectList("article.selectByTitle", part);
        session.close();
        return articlesList;
    }
    
    public Article selectByCategory(int categoryId) {
        SqlSession session = sqlSessionFactory.openSession();
        Article article = session.selectOne("article.selectByCategory", categoryId);
        session.close();
        return article;
    }
    
    public int insert(Article article) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("article.insert", article);
        session.commit();
        session.close();
        return count;
    }
    
    public int update(Article article) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("article.update", article);
        session.commit();
        session.close();
        return count;
    }
    
    public int delete(Article article) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("article.delete", article);
        session.commit();
        session.close();
        return count;
    }
}
