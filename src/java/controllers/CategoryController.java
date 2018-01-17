/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAL.CategoryDAL;
import java.util.List;
import model.Category;

/**
 *
 * @author Администратор
 */
public class CategoryController {
    protected CategoryDAL categoryDal;

    public CategoryController() {
        categoryDal = new CategoryDAL();
    }
    
    public List<Category> getAllCategory() {
        return categoryDal.selectAll();
    }
    
    public Category getCategoryById(int id) {
        return categoryDal.selectById(id);
    }
    
    public Category getCategoryByName(String name) {
        return categoryDal.selectByName(name);
    }
    
    public int insert(Category category) {
        return categoryDal.insert(category);
    }
    
    public int update(Category category) {
        return categoryDal.update(category);
    }
    
    public int delete(Category category) {
        return categoryDal.delete(category);
    }
}
