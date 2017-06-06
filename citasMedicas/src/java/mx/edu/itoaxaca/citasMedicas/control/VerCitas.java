/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
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
        
        
        Date hoy=Date.from(Instant.now());
             
        
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

        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerCitas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h3>Citas de: "+pac.getNombre()+"</h3>");
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
                 Calendar f=ListaPacientes.dtc(c.getFecha());
                 Calendar h=ListaPacientes.dtc(c.getFecha());
                 out.println(
                     "<tr>"
                    + "<td>"+c.getIdcita()+"</td>"
                    + "<td>"+f.get(Calendar.DAY_OF_MONTH)+"-"+f.get(Calendar.MONTH)+1+"-"+f.get(Calendar.YEAR)+"</td>"
                    + "<td>"+c.getHora().getHours()+":00</td>"
                    + "<td>"+c.getPaciente()+"</td>"
                    + "<td>"+nombre+"</td>");
                    if(c.getEstatus().equals("PENDIENTE")){                                     
                        if(c.getFecha().before(hoy)){
                        out.println("<td>"
                            + "<a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&verbo=diagnosticar\">Diagnosticar</a>"
                            //+ ", <a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&verbo=cancelar\">Cancelar</a>"        
                            //+ " o <a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&verbo=borrar\">Borrar</a>"                                  
                            + "</td>");
                        }else{
                            out.println("<td>"
                            //+ "<a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&verbo=cancelar\">Cancelar</a>"        
                            //+ " o <a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&verbo=borrar\">Borrar</a>"                                  
                            + "</td>");
                        }
                    }       
                    if(c.getEstatus().equals("ATENDIDA")){
                        out.println("<td><a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&diagnostico=x&verbo=ver\">Ver</a>"
                        //+ " o <a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&verbo=borrar\">Borrar</a>"                                  
                        + "</td>");
                    }
                    if(c.getEstatus().equals("CANCELADA")){
                        out.println("<td><a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"&diagnostico=x&verbo=ver\">Ver</a></td>"
                        //+ " o <a href=\"EditarCita?idCita="+c.getIdcita()+"&paciente="+c.getPaciente()+"\"&verbo=borrar>Borrar</a>"
                        + "</td>");
                    }
                        out.println("</tr>");
             }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</center>");
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
