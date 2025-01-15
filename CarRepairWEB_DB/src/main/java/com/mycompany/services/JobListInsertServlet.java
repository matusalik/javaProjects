package com.mycompany.services;
import com.mycompany.carrepairweb.Model.DataSource;
import com.mycompany.carrepairweb.Model.IncorrectDataException;
import com.mycompany.carrepairweb.Model.Job;
import com.mycompany.carrepairweb.Model.JobList;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.Double.parseDouble;
import static java.lang.System.out;

/**
 * Servlet responsible of inserting new job into jobList (DataSource)
 * @author SuperStudent-PL
 */
@WebServlet("/jobListInsert")
public class JobListInsertServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = request.getServletContext();
              
        DataSource dataSource = (DataSource)context.getAttribute("DataSource"); 
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String model = request.getParameter("model");
        String registration = request.getParameter("registration");
        String mileage = request.getParameter("mileage");
       try{
            dataSource.persistObject(new Job(name, surname, model, registration, parseDouble(mileage)));
            response.sendRedirect(request.getContextPath() + "/jobList");
       }catch(IncorrectDataException ex){
           // Ustaw nagłówki odpowiedzi
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            // Wyślij komunikat błędu do klienta
            PrintWriter out = response.getWriter();
            out.println(ex.getMessage());
            out.close();
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
        return "Short description";
    }// </editor-fold>

}
