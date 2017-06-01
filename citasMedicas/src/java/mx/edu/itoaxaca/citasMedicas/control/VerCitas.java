/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
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


protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        emf=Persistence.createEntityManagerFactory("citasMedicasPU");
        
        String nombre=request.getParameter("nombrePac");
        System.out.println(nombre);
        /*String query = 
         "SELECT * FROM OMAR.PACIENTES WHERE NOMBRE = '"+ nombre +"' ";
        //String nombre=request.getParameter("nombrePac");
        
        EntityManager em = emf.createEntityManager();
        ArrayList listaPacientes = (ArrayList)em.createNativeQuery(query).getResultList();
        System.out.println("******************* consulta realizada");
        Pacientes p=(Pacientes)listaPacientes.get(0);
        System.out.println(p.getIdpaciente());
             //System.out.println(listaPacientes.get(0)[0]);
/*             System.out.println(listaPacientes.get(0)[1]);
             System.out.println(listaPacientes.get(0)[2]);
             System.out.println(listaPacientes.get(0)[3]);
             System.out.println(listaPacientes.get(0)[4]);*/
        
        
        
        PacientesJpaController cp=new PacientesJpaController(utx, emf);
        CitasJpaController cc=new CitasJpaController(utx, emf);
        
       Vector p =(Vector)cp.findPacientesByName(nombre);
        
        //
        System.out.println("Consulta hecha");
        System.out.println(p.size());
        System.out.println(p.get(0));
        Pacientes pac=(Pacientes)p.get(0);
        Vector citas = (Vector)cc.findCitasByIdPaciente(pac.getIdpaciente());
        System.out.println("Consulta hecha");
        System.out.println(p.size());
        System.out.println(p.get(0));
        
    //System.out.println(id);
    //List pacientes=cp.findPacientesByName(nombre);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerCitas</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h3>Citas de: "+pac.getIdpaciente()+"\t "+pac.getNombre()+"</h3>");
            out.println("<table border=1 >");
            out.println("<tr><td class='datos'>ID</td>"
                 +"<td class='datos'>Fecha</td>"
                    +"<td class='datos'>Hora</td>"
                    +"<td class='datos'>IdPaciente</td>"
                    +"<td class='datos'>Nombre</td>"
                    +"<td class='datos'>Opciones</td>"
                 +"</tr>"
                 );
            
             for(int i = 0; i < citas.size(); i++){
                 Citas c=(Citas)citas.get(i);
                 out.println(
                     "<tr>"
                             + "<td>"+c.getIdcita()+"</td>"
                             + "<td>"+c.getFecha()+"</td>"
                             + "<td>"+c.getHora()+"</td>"
                             + "<td>"+c.getPaciente()+"</td>"
                             + "<td>"+nombre+"</td>"
                             + "<td><a href=\"EditarCita?id="+c.getIdcita()+"&paciente="+c.getPaciente()+"\">Atender</a></td>"
                    
                             + "</tr>"
                 );
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
