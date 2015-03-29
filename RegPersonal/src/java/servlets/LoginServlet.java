package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EstebanVaio
 */
public class LoginServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            String login = request.getParameter("txtLogin");
            String password = request.getParameter("txtPassword");
            
            boolean ok;
            
            if (login == null || password == null) {
                ok = false;
            }else{
                // validar si existe en la base de datos...
                ok = validarUsuario(login,password);
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Personal</title>");            
            out.println("</head>");
            out.println("<body>");
            if (!ok){
                out.println("<h1> Usuario Incorecto!!! </h1>");
                out.println("<a href=\"index.jsp\">Regresar</a> ");
            }else{
                out.println("<a href=\"incluir.jsp\">Incluir</a> <br> ");
                out.println("<a href=\"modificar.jsp\">Modificar</a> <br>");
                out.println("<a href=\"eliminar.jsp\">Eliminar</a> <br>");
                out.println("<a href=\"AdminDBServlet?prm=listar\">Listar</a> <br>");
                out.println("<a href=\"index.jsp\">Regresar</a> <br>");
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

    private boolean validarUsuario(String login,String password) {
        try {
                // cargar el driver JDBC
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            String url = "jdbc:derby://localhost:1527/datos";
            String user = "root";
            String pass = "root";
            
            //Conexión con la Base de Datos...
            
            Connection con = DriverManager.getConnection(url, user, pass);
            
            PreparedStatement psmt = con.prepareStatement("select * from USUARIOS where LOGIN = ? and PASSWORD = ?");
            
            psmt.setString(1, login);
            psmt.setString(2, password);
            
            ResultSet rs = psmt.executeQuery();
            
            //Verificar si existe datos en la tabla.
            if (rs.next()){
                return true;
            }else{
                return false;
            }
        
        } catch (SQLException ex) {
            //ogger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.getMessage());
            return false;
        } catch (ClassNotFoundException ex) {
                //Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.getMessage());    
            return false;
         }
          
  
    }
}
