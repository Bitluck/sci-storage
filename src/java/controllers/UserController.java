/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAL.UserDAL;
import java.util.List;
import model.User;

/**
 *
 * @author Администратор
 */
public class UserController {
    protected UserDAL userDal;

    public UserController() {
        userDal = new UserDAL();
    }
    
    public List<User> getAllUsers() {
        return userDal.selectAll();
    }
    
    public User getUserById(int id) {
        return userDal.selectById(id);
    }
    
    public User getUserByEmail(String email) {
        return userDal.selectByEmail(email);
    }
    
    public int insert(User user) {
        return userDal.insert(user);
    }
    
    public int update(User user) {
        return userDal.update(user);
    }
    
    public int delete(int id) {
        return userDal.delete(id);
    }
}
