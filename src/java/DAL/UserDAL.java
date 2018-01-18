/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import model.User;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Администратор
 */
public class UserDAL extends BaseDAL {

    public UserDAL() {
        super();
    }
    
    public List<User> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        List<User> allUsersList = session.selectList("user.selectAll");
        session.close();
        return allUsersList;
    }
    
    public User selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("user.selectById", id);
        session.close();
        return user;
    }
    
    public User selectByEmail(String email) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("user.selectByEmail", email);
        session.close();
        return user;
    }
    
    public int insert(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("user.insert", user);
        session.commit();
        session.close();
        return count;
    }
    
    public int update(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("user.update", user);
        session.commit();
        session.close();
        return count;
    }
    
    public int delete(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("user.delete", id);
        session.commit();
        session.close();
        return count;
    }
}
