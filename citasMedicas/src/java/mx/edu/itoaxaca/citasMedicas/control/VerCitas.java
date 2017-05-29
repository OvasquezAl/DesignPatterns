/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
import mx.edu.itoaxaca.citasMedicas.modelo.Pacientes;

/**
 *
 * @author omar
 */



@WebServlet(name = "VerCitas", urlPatterns = {"/VerCitas"})
public class VerCitas extends HttpServlet {
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
public static Calendar dateToCalendar(Date date ) 
{ 
 Calendar cal = new GregorianCalendar();
 try {   
     cal.setTime(date);
  }
  catch (Exception e)
  {
      System.out.println("Exception :"+e);  
  }  
  return cal;
 }

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        emf=Persistence.createEntityManagerFactory("citasMedicasPU");
        CitasJpaController cc = new CitasJpaController(utx, emf);
        
        List <Citas> citas = cc.findCitasEntities();
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerCitas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=1 >");
            out.println("<tbody>");
                out.println("<tr>");
                out.println("<td>id</td>");
                out.println("<td>Paciente</td>");
                out.println("<td>Fecha</td>");
                out.println("<td>Hora</td>");
                out.println("</tr>");
            for(Citas cita:citas){
                Calendar f=dateToCalendar(cita.getFecha());
                Calendar h=dateToCalendar(cita.getHora());
                out.println("<tr>");
                out.println("<td>"+cita.getIdcita()+"</td>");
                out.println("<td>"+cita.getPaciente()+"</td>");
                
                out.println("<td>"+f.get(Calendar.DAY_OF_MONTH)+"-"+(dateToCalendar(cita.getFecha()).get(Calendar.MONTH)+1)+"</td>");
                out.println("<td>"+h.get(Calendar.HOUR_OF_DAY)+":00</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            
            //out.println("<h1>Servlet VerCitas at " + request.getContextPath() + "</h1>");
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
