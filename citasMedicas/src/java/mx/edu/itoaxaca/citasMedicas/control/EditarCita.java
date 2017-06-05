/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mx.edu.itoaxaca.citasMedicas.control.exceptions.RollbackFailureException;
import mx.edu.itoaxaca.citasMedicas.modelo.Citas;
import mx.edu.itoaxaca.citasMedicas.modelo.Consultas;

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
        PacientesJpaController cp=new PacientesJpaController(utx, emf);
        String verbo=request.getParameter("verbo");
        String ids=request.getParameter("idCita");
        System.out.println(ids);
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        int idPaciente = Integer.parseInt(request.getParameter("paciente"));
        String paciente=request.getParameter("paciente");
        String nombrePaciente=cp.findPacientes(Integer.parseInt(paciente)).getNombre();
        
        String diagnostico=request.getParameter("diagnostico");
        System.out.println(paciente);
        
        if(diagnostico!=null){
            if(diagnostico.equals("x")){
            
            Vector consultas=(Vector)con.findConsultasByIdCita(idCita);
            System.out.println("búsqueda de consulta por id cita");
            System.out.println("tamaño del vector::::::::::::::::::::::::::::::::::::::::"+consultas.size());
            Consultas c=(Consultas)consultas.get(0);
            System.out.println("Diagnostico: "+c.getDiagnostico());
            diagnostico=c.getDiagnostico();
                
                
            
            }else{
            Citas cita = cc.findCitas(idCita);
            cita.setEstatus("ATENDIDA");
            try {
                cc.edit(cita);
                
            } catch (RollbackFailureException ex) {
                Logger.getLogger(EditarCita.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(EditarCita.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            Consultas consulta =new Consultas();
            consulta.setIdcita(idCita);
            consulta.setIdpaciente(idPaciente);
            consulta.setDiagnostico(diagnostico);
            try {
                con.create(consulta);
            } catch (Exception ex) {
                Logger.getLogger(EditarCita.class.getName()).log(Level.SEVERE, null, ex);
            }    
            
            }
        }
        
        
        
        
        
        
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
            out.println("<h1>IdCita:" + idCita+ "</h1>");
            
            out.println("<h1>Paciente:" + nombrePaciente+ "</h1>");
            out.println("<input type='hidden' name='paciente' value="+paciente+">");
            out.println("<input type='hidden' name='idCita' value="+idCita+">");
            out.println("<p>Diagnóstico:</p>");
        
            if(diagnostico==null){    
            out.println("<input type='text' name='diagnostico' size=100>");
            out.println("<input type='submit' value='Guardar'></input>");
            }else{
                
            out.println("<p>"+diagnostico+"</p>");    
            out.println("<a href='VerCitas&nombrePac="+nombrePaciente+"'>Atras</a>");
            out.println("<a href='index.html'>Inicio</a>");
            }
            
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
