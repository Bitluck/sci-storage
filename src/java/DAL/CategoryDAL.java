/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import model.Category;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Администратор
 */
public class CategoryDAL extends BaseDAL {

    public CategoryDAL() {
        super();
    }
    
   public List<Category> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        List<Category> allCategoriesList = session.selectList("category.selectAll");
        session.close();
        return allCategoriesList;
    }
    
    public Category selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Category category = session.selectOne("category.selectById", id);
        session.close();
        return category;
    }
    
    public Category selectByName(String name) {
        SqlSession session = sqlSessionFactory.openSession();
        Category category = session.selectOne("category.selectByName", name);
        session.close();
        return category;
    }
    
    public int insert(Category category) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("category.insert", category);
        session.commit();
        session.close();
        return count;
    }
    
    public int update(Category category) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("category.update", category);
        session.commit();
        session.close();
        return count;
    }
    
    public int delete(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("category.delete", id);
        session.commit();
        session.close();
        return count;
    }
}
