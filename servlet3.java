/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet("/servlet3")
public class servlet3 extends HttpServlet {

   
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            Connection con;
            PrepareStatement pst;
            ResultSet rs;
            
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bar", "root", "");
            
            ServletContext context = getServletContext();
            context.setAttribute("accno");
            String accno = obj.toString();
            
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            String date = df.format(now);
            
            
            
            String amount = request.getParameter("amount");
            
            
            pst = (PrepareStatement) con.prepareStatement("insert into account_holder(accnum,date,mdeposit)values(?,?,?)");
            pst.setString(1, accno);
            pst.setString(2, date);
            
            pst.setString(3, amount);
            int row  = pst.executeUpdate();
            
            if(rows == 1)
            {
               out.println("Your Transaction have been done");
            }
            else
            {
                out.println("Your Transaction failed");
            }
            
            
            
            ServletContext context = getServletContext();
            context.setAttribute("accno", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servlet3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servlet3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
    }
       
    }

   