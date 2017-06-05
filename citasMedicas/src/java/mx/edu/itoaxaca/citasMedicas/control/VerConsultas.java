/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
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
import mx.edu.itoaxaca.citasMedicas.modelo.Consultas;
import mx.edu.itoaxaca.citasMedicas.modelo.Pacientes;

/**
 *
 * @author omar
 */
@WebServlet(name = "VerConsultas", urlPatterns = {"/VerConsultas"})
public class VerConsultas extends HttpServlet {
@PersistenceUnit
EntityManagerFactory emf;

@Resource
UserTransaction utx;

private CitasJpaController cc;
private PacientesJpaController cp;
private ConsultasJpaController con;
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
        cc=new CitasJpaController(utx, emf);
        cp=new PacientesJpaController(utx, emf);
        con=new ConsultasJpaController(utx, emf);
        String nombre=request.getParameter("nombre");
        System.out.println("Nombre recibido: "+nombre);
        Pacientes paciente=null;
        Vector consultas=null;
        if(nombre != null){
            Vector pacientes=(Vector)cp.findPacientesByName(nombre);
            try{
                paciente= (Pacientes) pacientes.get(0);
                consultas=(Vector)con.findConsultasByPaciente(paciente.getIdpaciente());
                
            }catch(Exception e){
                System.out.println("No se encontró ningun paciente: "+ e);
            }
            
        }
       
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VerConsultas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<p></p><p></p>");
            //out.println("<h1>Servlet VerConsultas at " + request.getContextPath() + "</h1>");
            out.println("<h3 color='red'>Ver Consultas</h3>");
            out.println("<form id='datos' action='VerConsultas' method='post'>");
            out.println("<input type='text' name='nombre' id='InputNombre'>");
          //  out.println("<input type='select' name='tipo' id='selectTipo'>");
            out.println("<input type='submit' value='Buscar'>");
            out.println("</form>");
            out.println("<p></p><p></p>");
            if(consultas.size()>0 ){
                out.println("<table border=1>");
                out.println("<tr><td>Paciente</td><td>Cita</td><td>Consulta</td><td>Diagnostico</td></tr>");
                for(int i=0; i<consultas.size();i++){
                    Consultas consulta =(Consultas)consultas.get(i);
                    out.println("<tr><td>"+paciente.getNombre()+"</td>"
                            +"<td>"+consulta.getIdcita()+"</td>"
                            + "<td>"+consulta.getIdconsulta()+"</td>"
                            +"<td>"+consulta.getDiagnostico()+"</td></tr>");   
                }
                out.println("</table>");
            }else{
                if(paciente !=null ) out.println("<h4>No hay consultas para este paciente</h4>");
            }
            out.println("<a href='/citasMedicas/'>Inicio</a>");
            out.println("<center>");
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
