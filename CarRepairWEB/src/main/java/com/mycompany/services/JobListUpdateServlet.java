package com.mycompany.services;

import com.mycompany.carrepairweb.Model.DataSource;
import com.mycompany.carrepairweb.Model.IncorrectDataException;
import com.mycompany.carrepairweb.Model.Job;
import com.mycompany.carrepairweb.Model.JobStatus;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateu
 */
@WebServlet("/jobListUpdate")
public class JobListUpdateServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IncorrectDataException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = request.getServletContext();
        DataSource dataSource = (DataSource)context.getAttribute("DataSource"); 
        
        PrintWriter out = response.getWriter();
        
        try {
            int id = Integer.parseInt(request.getParameter("jobId"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String model = request.getParameter("model");
            String registration = request.getParameter("registration");
            double mileage = Double.parseDouble(request.getParameter("mileage"));
            String statusString = request.getParameter("status");
            JobStatus status = JobStatus.valueOf(statusString);
            
            dataSource.update(new Job(id, name, surname, model, registration, mileage, status));              
            response.sendRedirect(request.getContextPath() + "/jobList");
        } catch(IncorrectDataException e){
            out.println(e.toString());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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
        try {
            processRequest(request, response);
        } catch (IncorrectDataException ex) {
            Logger.getLogger(JobListUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (IncorrectDataException ex) {
            Logger.getLogger(JobListUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
