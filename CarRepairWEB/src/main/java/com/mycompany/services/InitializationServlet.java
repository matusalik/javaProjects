package com.mycompany.services;

import jakarta.servlet.http.HttpServlet;
import com.mycompany.carrepairweb.Model.DataSource;
import com.mycompany.carrepairweb.Model.JobList;


public class InitializationServlet extends HttpServlet { 
    
    @Override
    public void init() {
        
        var context = getServletContext();        
        DataSource dataSource = (DataSource)context.getAttribute("DataSource");
        if(dataSource == null) {
            context.setAttribute("DataSource", new JobList());
        }  
    }       
}
