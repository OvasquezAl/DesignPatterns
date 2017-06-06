package mx.edu.itoaxaca.citasMedicas.control;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "BuscarPorNombre", urlPatterns = {"/BuscarPorNombre"})
public class BuscarPorNombre extends HttpServlet {

@PersistenceUnit
EntityManagerFactory emf;

@Resource
UserTransaction utx;

private CitasJpaController cc;
private PacientesJpaController cp;
            
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
        cp = new PacientesJpaController(utx, emf);
        
        List<Pacientes> pacientes = cp.findPacientesEntities();
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Citas Medicas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h2>Seleccion de paciente:</h2>");
            /*out.println("<form id='buscaNombre action=VerCitas' method= 'post'>");
            out.println("<input type='text' name='nombrePac'></input>");
            out.println("<input type='submit' id='nPac' value='Buscar' name='buscar' title='buscar'>");
            out.println("</form>");
            */
            out.println("<form id='buscaPac' action='VerCitas' method='post'> ");
            out.println("<input type='text' name='nombrePac'></input>");
            /*out.println("<select name='idPac'>");
            for (Pacientes paci:pacientes){
                out.println("<option value="+paci.getIdpaciente()+" label="+paci.getNombre()+">");
            }
            out.println("</select>");*/
            out.println("<br/>");
            out.println("<input type='submit' id='idPaciente' value='Aceptar' name='aceptar' title='buscar'>");
            out.println("</form>");
            out.println("<p><a href='index.html'>Inicio</a></p>");
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
