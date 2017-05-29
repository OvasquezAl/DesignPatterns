/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@WebServlet(name = "AltaCita", urlPatterns = {"/AltaCita"})
public class AltaCita extends HttpServlet {
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        emf=Persistence.createEntityManagerFactory("citasMedicasPU");
        CitasJpaController cc=new CitasJpaController(utx, emf);
        Citas cita=new Citas();
        String f=request.getParameter("fecha");
        String h=request.getParameter("hora");
        System.out.println(h);
        int paciente=Integer.parseInt(request.getParameter("paciente"));
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat t = new SimpleDateFormat("yyy-MM-dd HH:MM:SS");
        
        
        Date hora= new Date();
        Date fecha = new Date();
        
        try {
            fecha = s.parse(f);
            hora = t.parse (f+" "+h);
            System.out.println(hora);
           } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        
        cita.setPaciente(paciente);
        cita.setHora(hora);
        cita.setFecha(fecha);
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaCita</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.print("<h2>Paciente</h2>");
            //out.println("id: " +cita.getPaciente()+ "\n");
            
            //out.println("Fecha: " +cita.getFecha()+ "\n");
            //out.println("Hora: " +cita.getHora() + "\n");
            
            
            
            out.println("<h1>Servlet AltaCita at " + request.getContextPath() + "</h1>");
          
             try {
                cc.create(cita);
                out.println("<h1>Se agregó correctamente</h1>");
                out.println("<a href='index.html'>Volver al inicio</a>");
                out.println("<a href='AgregarCita'>Agregar otra cita</a>");
            } catch (Exception e) {
                out.print("<h1>"+e.getMessage()+"</h1>");
            }
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
