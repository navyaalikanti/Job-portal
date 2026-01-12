package com.jobportal.servlets;

import com.jobportal.utils.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String userType = request.getParameter("userType");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection conn = DatabaseConnection.getConnection();
            
            if ("jobseeker".equals(userType)) {
                int experience = Integer.parseInt(request.getParameter("experience"));
                String skills = request.getParameter("skills");
                String education = request.getParameter("education");
                
                String sql = "INSERT INTO job_seekers (full_name, email, password, phone, experience, skills, education) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, fullName);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, phone);
                stmt.setInt(5, experience);
                stmt.setString(6, skills);
                stmt.setString(7, education);
                
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    out.println("<h3 style='color:green;'>Job Seeker Registration Successful!</h3>");
                }
                
            } else if ("recruiter".equals(userType)) {
                String company = request.getParameter("company");
                String position = request.getParameter("position");
                String industry = request.getParameter("industry");
                
                String sql = "INSERT INTO recruiters (full_name, email, password, phone, company, position, industry) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, fullName);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, phone);
                stmt.setString(5, company);
                stmt.setString(6, position);
                stmt.setString(7, industry);
                
                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    out.println("<h3 style='color:green;'>Recruiter Registration Successful!</h3>");
                }
            }
            
            out.println("<br><a href='index.jsp'>Go Back to Home</a>");
            conn.close();
            
        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Registration Failed: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}