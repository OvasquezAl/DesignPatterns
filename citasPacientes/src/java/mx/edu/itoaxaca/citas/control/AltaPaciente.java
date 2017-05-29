/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mx.edu.itoaxaca.citas.modelo.Paciente;


/**
 *
 * @author omar
 */
@WebServlet(name = "AltaPaciente", urlPatterns = {"/AltaPaciente"})
public class AltaPaciente extends HttpServlet {
  // @PersistenceUnit
    EntityManagerFactory emf;
  // @Resource 
    UserTransaction utx;
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
        response.setContentType("text/html;charset=UTF-8");
        
        PacientesJpaController controller = new PacientesJpaController(utx, emf);
        String nombrep=request.getParameter("nombre");
        String fechas=request.getParameter("fecha");
        System.out.println(fechas);
        Integer estatura=Integer.parseInt(request.getParameter("estatura"));
        String sexo=request.getParameter("sexo");
        
        Paciente pac = new Paciente();

        pac.setNombre(nombrep);
        SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
        Date fech = new Date();
        try {
            fech = s.parse(fechas);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        pac.setFechanac(fech);
        pac.setEstatura(estatura);
        pac.setSexo(sexo.charAt(0));
    
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Paciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.print("<h2>Paciente</h2>");
            out.println("Nombre: " +pac.getNombre() + "\n");
            
            out.println("Fecha de nacimiento: " +pac.getFechanac() + "\n");
            out.println("Estatura: " +pac.getEstatura() + "\n");
            out.println("Sexo: " + pac.getSexo() + "\n");
            
            out.println("</body>");
            out.println("</html>");
            
            try {
                controller.create(pac);
                out.print("<h1>Se agregó correctamente</h1>");
            } catch (Exception e) {
                out.print("<h1>"+e.getMessage()+"</h1>");
            }
            
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