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
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
import mx.edu.itoaxaca.citasMedicas.modelo.Pacientes;

/**
 *
 * @author omar
 */


@WebServlet(name = "ListaPacientes", urlPatterns = {"/ListaPacientes"})
public class ListaPacientes extends HttpServlet {

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
    public static Calendar DateToCalendar(Date date ) 
{ 
 Calendar cal = null;
 try {   
     DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
  date = (Date)formatter.parse(date.toString()); 
  cal=Calendar.getInstance();
  cal.setTime(date);
  }
  catch (ParseException e)
  {
      System.out.println("Exception :"+e);  
  }  
  return cal;
 }
    
    public int edad(Date fnac){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNueva = fnac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNueva, ahora);
        String edad;
        System.out.printf("Tu edad es: %s años, %s meses y %s días",
                    periodo.getYears(), periodo.getMonths(), periodo.getDays());
        edad=periodo.getYears()+" años "+periodo.getMonths()+" meses";
        int e;
        e=periodo.getYears();
        return e;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        emf=Persistence.createEntityManagerFactory("citasMedicasPU");
        PacientesJpaController cp = new PacientesJpaController(utx, emf);
        
        List <Pacientes> pacientes = cp.findPacientesEntities();
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Pacientes</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<table aling= 'left' width='60%' border=1>");
            out.println("<tr> <td class='datos'>ID</td>" + "<td class='datos'>Nombre</td>"
                        +"<td class='datos'>FechaNac</td>"+"<td class='datos'>Estatura</td>"
                        +"<td class='datos'>Sexo</td>" + "<td class='datos'>Edad</td></tr>");
            int numPacientes=0;
            int estaturas=0;
            int edades=0;
            for(Pacientes pacien : pacientes){
                numPacientes++;
                estaturas+=pacien.getEstatura();
                int e=edad(pacien.getFechanac());
                edades+=e;
                out.println("<tr> <td class='datos'>"+ pacien.getIdpaciente() +"</td><td class='datos'>"+ pacien.getNombre()+ "</td>" 
                        +"<td class='datos'>"+ pacien.getFechanac()+ "</td><td class='datos'>"+ pacien.getEstatura() + "</td>"
                        +"<td class='datos'>"+ pacien.getSexo() + "</td>  <td class='datos'>"+e+"</td> </tr>");
            }
            
            out.println("<tr> <td class='datos'>Promedios</td><td class='datos'></td><td class='datos'></td><td class='datos'>"+estaturas/numPacientes+"</td><td class='datos'></td><td class='datos'>"+edades/numPacientes+"</td>");
            
            out.println("</table>");
            
            //out.println("<h1>Servlet Mostrar at " + request.getContextPath() + "</h1>");
            
            out.println("<a href='index.html'>Volver al inicio</a>");
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
