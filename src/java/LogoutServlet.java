/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author mahar
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
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
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       Cookie loginCookie = null;
       Cookie[] cookies = request.getCookies();
       if(cookies != null){
           for(Cookie cookie:cookies){
               if(cookie.getName().equals("user")){
                   loginCookie = cookie;
                   break;
               }
           }
       }
       if(loginCookie != null){
           loginCookie.setMaxAge(0);
           response.addCookie(loginCookie);
       }
       out.println("<font color=red>Successfully logged out!</font>");
       response.sendRedirect(request.getContextPath());
    }

    

}
