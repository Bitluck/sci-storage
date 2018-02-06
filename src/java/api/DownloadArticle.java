/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Администратор
 */
@WebServlet(name = "DownloadArticle", urlPatterns = {"/DownloadArticle"})
public class DownloadArticle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String fileName = request.getParameter("filename");
        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true)) {
            String filePath = getServletContext().getRealPath("/upload/" + fileName);
            File downloadFile = new File(filePath);
            
            FileInputStream fileInStream = new FileInputStream(downloadFile);
            
            String mimeType = getServletContext().getMimeType(filePath);
            if(mimeType == null) {
                mimeType = "application/pdf";
            }
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());
            
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", URLEncoder.encode(downloadFile.getName().substring(downloadFile.getName().indexOf('_') + 1), "UTF-8"));
            //System.out.println(headerValue);
            response.setHeader(headerKey, headerValue);
            
            OutputStream outStream = response.getOutputStream();
         
            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = fileInStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            fileInStream.close();
            outStream.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "DownloadArticle";
    }// </editor-fold>

}
