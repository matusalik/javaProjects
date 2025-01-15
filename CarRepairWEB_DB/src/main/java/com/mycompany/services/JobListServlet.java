package com.mycompany.services;
import com.mycompany.carrepairweb.Model.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mycompany.carrepairweb.Model.JobList;
import com.mycompany.carrepairweb.Model.Job;
import com.mycompany.carrepairweb.Model.JobStatus;
import jakarta.servlet.ServletContext;

/**
 * Servlet processing what to show in the table based on DataSource(JobList)
 * @author mateu
 */
@WebServlet("/jobList")
public class JobListServlet extends HttpServlet {
    
    @Override
    public void init(){
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = request.getServletContext();
        DataSource dataSource = (DataSource)context.getAttribute("DataSource");
        PrintWriter out = response.getWriter();
        for(Job job : dataSource.getJobs()){
            out.println("<tr>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"name"+job.getId()+"\" name=\"name"+job.getId()+"\" placeholder=\"Name\" value=\""+ job.getName() + "\"/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"surname"+job.getId()+"\" name=\"surname"+job.getId()+"\" placeholder=\"Surname\" value=\""+ job.getSurname() + "\"/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"model"+job.getId()+"\" name=\"model"+job.getId()+"\" placeholder=\"Model\" value=\""+ job.getModel() + "\"/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"text\" id=\"registration"+job.getId()+"\" name=\"registration"+job.getId()+"\" placeholder=\"Registration\" value=\""+ job.getRegistration() + "\"/>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"number\" id=\"mileage"+job.getId()+"\" name=\"mileage"+job.getId()+"\" placeholder=\"Mileage\" value=\""+ job.getMileage() + "\"/>");
            out.println("</td>");
            out.println("<td>");
            // Tworzymy dropdown dla wartości enum
            out.println("<select id=\"status" + job.getId() + "\" name=\"status" + job.getId() + "\">");
            for (JobStatus status : JobStatus.values()) {
                String selected = status == job.getStatus() ? "selected" : ""; // Oznacz wybrany status
                out.println("<option value=\"" + status + "\" " + selected + ">" + status + "</option>");
            }
            out.println("</select>");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"button\" value=\"Update\" onclick=\"updateJob(" + job.getId() + ", 'name', 'surname', 'model', 'registration', 'mileage', 'status', 'tableJobList', 'errorInfo');\" />");
            out.println("</td>");
            out.println("<td>");
            out.println("<input type=\"button\" value=\"Delete\" onclick=\"deleteJob(" + job.getId() + ",'tableJobList','errorInfo');\" />");
            out.println("</td>");
            out.println("</tr>");
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
