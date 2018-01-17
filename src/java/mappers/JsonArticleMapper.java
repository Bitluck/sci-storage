/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Article;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Администратор
 */
public class JsonArticleMapper {
    public static String toJSON(Article article) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(article);
            return json;
        } catch (IOException ex) {
            Logger.getLogger(JsonArticleMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String toJSON(List<Article> articles) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(articles);
            return json;
        } catch (IOException ex) {
            Logger.getLogger(JsonArticleMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Article fromJSON(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Article article = mapper.readValue(json, Article.class);
            return article;
        } catch (IOException ex) {
            Logger.getLogger(JsonArticleMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
