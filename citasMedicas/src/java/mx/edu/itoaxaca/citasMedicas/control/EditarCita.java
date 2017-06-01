/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mx.edu.itoaxaca.citasMedicas.modelo.Citas;

/**
 *
 * @author omar
 */
@WebServlet(name = "EditarCita", urlPatterns = {"/EditarCita"})
public class EditarCita extends HttpServlet {
@PersistenceUnit
EntityManagerFactory emf;
@Resource
UserTransaction utx;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ConsultasJpaController con=new ConsultasJpaController(utx, emf);
        CitasJpaController cc=new CitasJpaController(utx, emf);
        
        String ids=request.getParameter("idCita");
        System.out.println(ids);
        
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        int idPaciente = Integer.parseInt(request.getParameter("paciente"));
        String paciente=request.getParameter("paciente");
        System.out.println(paciente);
        Citas cita = cc.findCitas(idCita);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarCita at " + request.getContextPath() + "</h1>");
            out.println("<form action='EditarCita' method='post'>");
            out.println("<h1>IdCita:" + ids+ "</h1>");
            out.println("<input type='hidden' value="+ids+">");
            out.println("<h1>IdPaciente:" + ids+ "</h1>");
            out.println("<input type='hidden' value="+paciente+">");
            out.println("<p>Diagnóstico:</p>");
            out.println("<input type='text' size=100>");
            out.println("<input type='submit'></input>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
