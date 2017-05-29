/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
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
@WebServlet(name = "ElegirCita", urlPatterns = {"/ElegirCita"})
public class ElegirCita extends HttpServlet {
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
        String diaSeleccionado=request.getParameter("diaSel");
        response.setContentType("text/html;charset=UTF-8");
        emf=Persistence.createEntityManagerFactory("citasMedicasPU");
        
        PacientesJpaController cp=new PacientesJpaController(utx, emf);
        CitasJpaController cc=new CitasJpaController(utx, emf);
        
        int id=Integer.parseInt(request.getParameter("pacid"));
        
        List<Citas> citas=cc.findCitasEntities();
        Pacientes pac=cp.findPacientes(id);
        
        LocalDate inicio=LocalDate.now();
        LocalDate inicioMes=LocalDate.now().minusDays(inicio.getDayOfMonth()-1);
        DayOfWeek diaSemana=inicio.getDayOfWeek();
        int dia=inicio.getDayOfMonth();
        Month mes=inicio.getMonth();
        int SizeMes=inicio.lengthOfMonth();
        String fecha="";
        if(inicio.getMonthValue()<10){
         fecha=inicio.getYear()+"-0"+inicio.getMonthValue()+"-"+diaSeleccionado;
        }else{
         fecha=inicio.getYear()+"-"+inicio.getMonthValue()+"-"+diaSeleccionado;
        }
        System.out.println(fecha);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ElegirCita</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h3>id: "+id+"</h3>");
            out.println("<h3>Nombre: "+pac.getNombre()+"</h3>");
            out.println("<h3>Fecha de Nacimiento: "+pac.getFechanac()+"</h3>");
            out.println("<h3>Estatura: "+pac.getEstatura()+"</h3>");
            //out.println("<h3>Fecha de hoy: "+inicio+"</h3>");
            //out.println("<h3>Día de la semana: "+diaSemana+"</h3>");
            //out.println("<h3>Dia: "+dia+"</h3>");
            if(diaSeleccionado==null){
            out.println("<h3>Mes: "+mes+"</h3>");
            //out.println("<p>Inicio del mes: "+inicioMes+"</p>");
            //out.println("<h3>Longitud del mes: "+SizeMes+"</h3>");
            out.println("<table border=1>");
            out.println("<tbody>");
            out.println("<tr><td>L</td>");
            out.println("<td>M</td>");
            out.println("<td>M</td>");
            out.println("<td>J</td>");
            out.println("<td>V</td>");
            out.println("<td>S</td>");
            out.println("<td>D</td></tr>");
            
            out.println("<tr>");
            
            for(int i=1, d=inicioMes.getDayOfWeek().getValue();i<=SizeMes;d++,i++){
                if(d==1 && i!=1){ 
                    out.println("<tr>");
                }   
               if(i<d){
                   out.println("<td></td>");
               }else {
               boolean yahay=false;
                  for(Citas cita:citas){
                   if(VerCitas.dateToCalendar(cita.getFecha()).get(Calendar.DAY_OF_MONTH)==i && VerCitas.dateToCalendar(cita.getFecha()).get(Calendar.MONTH)+1==inicio.getMonthValue()){
                        yahay=true;
                   }
               }
                if(i<dia || yahay){out.println("<td>"+i+"</td>");  }
                else{
                    
                    out.println("<td><a href='ElegirCita?diaSel="+i+"&pacid="+id+"'>"+i+"</a></td>");

               }
            }  
               if(d==7){ 
                    out.println("</tr>");
                    d=0;
                }
            }
            
            out.println("</table>");
            }else{
            out.println("<form action='AltaCita' method='post'>");
            out.println("<input type='hidden' id='paciente' name='paciente' value="+id+"></input>");
            out.println("<input type='text' style='visibility: hidden' name='fecha' id='fecha' value="+fecha+">Dia seleccionado:"+fecha+"</input>");
            out.println("<select id='hora' name='hora'>");
            for(int i=8;i<20;i++){
                out.println("<option>"+i+":00:00</option>");
            }
            out.println("</select>");
            out.println("<input type='submit' name='agregar'></input>");
            out.println("</form>");
        }
            out.println("</tbody>");
            out.println(diaSeleccionado);
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
