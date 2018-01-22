/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import controllers.ArticleController;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mappers.JsonArticleMapper;
import model.Article;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Администратор
 */
@WebServlet(name = "InsertArticle", urlPatterns = {"/InsertArticle"})
public class InsertArticle extends HttpServlet {
    private Random random = new Random();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Article article)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //String json = request.getParameter("json");
        try (PrintWriter out = response.getWriter()) {
            //Article article = JsonArticleMapper.fromJSON(json);
            ArticleController articleController = new ArticleController();
            int count = articleController.insert(article);
            out.print(count);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        return;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println(request);
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024 * 10);
        File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        upload.setSizeMax(1024 * 1024 * 10);
        
        try {
            Article article = new Article();
            List items = upload.parseRequest(new ServletRequestContext(request));
            Iterator iter = items.iterator();
            
            while(iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if(item.isFormField()) {
                    article = processFormField(article, item);
                } else {
                    article.setPath(processUploadFile(item));
                }
            }
            
            processRequest(request, response, article);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        
        /*InputStreamReader reader = new InputStreamReader(request.getInputStream());
            int c;
            while ((c=reader.read())>=0) {
                    response.getWriter().print((char)c);
        }*/
    }
    
    private String processUploadFile(FileItem item) throws Exception {
        File uploadFile = null;
        String path;
        String fileName;
        do {
            fileName = Math.abs(random.nextInt()) + "_" + item.getName();
            path = getServletContext().getRealPath("/upload/" + fileName);
            uploadFile = new File(path);
        } while(uploadFile.exists());
        
        uploadFile.createNewFile();
        item.write(uploadFile);
        return fileName;
    }
    
    private Article processFormField(Article article, FileItem item) throws Exception {
        System.out.println(item.getFieldName() + ": " + item.getString());
        switch(item.getFieldName()) {
            case "title":
                article.setTitle(item.getString());
                break;
            case "authors":
                article.setAuthors(item.getString());
                break;
            case "ownerId":
                article.setOwnerId(Integer.parseInt(item.getString()));
                break;
            case "category":
                article.setCategoryId(Integer.parseInt(item.getString()));
                break;
            case "tags":
                article.setTags(item.getString());
                break;
        }
        return article;
        //System.out.println(item.getFieldName() + ": " + item.getString());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "InsertArticle";
    }// </editor-fold>

}
