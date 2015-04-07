/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import application.bean.PersonalBean;
import application.dao.DaoPersonal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author EstebanVaio
 */
@WebServlet(name = "AdminDBServlet", urlPatterns = {"/AdminDBServlet"})
public class AdminDBServlet extends HttpServlet {

    private DaoPersonal dao;
    
    @Override
    public void init(){
        dao = new DaoPersonal();
    }
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
      
            String prm = request.getParameter("prm");
            
            if (prm.equalsIgnoreCase("incluir")){
                insertarRegistro(request , out);
            } else if(prm.equalsIgnoreCase("modificar")){
                modificarRegistro(request, out);
            } else if(prm.equalsIgnoreCase("eliminar")){
                eliminarRegistro(request, out);
            } else if (prm.equalsIgnoreCase("listar")){
                listarRegistro(request, out);
            }
            
        } finally{
            out.close();
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

    private void insertarRegistro(HttpServletRequest request, PrintWriter out) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nombre = request.getParameter("txtNombre");
        String departamento = request.getParameter("txtDepartamento");
        
        PersonalBean personal = new PersonalBean();
        
        personal.setCodigo(codigo);
        personal.setNombre(nombre);
        personal.setDepartamento(departamento);
        
        boolean Ok = dao.Insertar(personal);
        
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Personal</title>");            
            out.println("</head>");
            out.println("<body>");
            if (Ok){
                out.println("<h1> Registro incluido con éxito!!! </h1>");
            }else{
              out.println("<h1> Error al incluido el registro!!! </h1>");
            }
            out.println("<a href=\"incluir.jsp\">Incluir</a> <br> ");
            out.println("<a href=\"modificar.jsp\">Modificar</a> <br>");
            out.println("<a href=\"eliminar.jsp\">Eliminar</a> <br>");
            out.println("<a href=\"AdminDBServlet?prm=listar\">Listar</a> <br>");
            out.println("<a href=\"index.jsp\">Regresar</a> <br>");
            
            out.println("</body>");
            out.println("</html>");
    }

    private void modificarRegistro(HttpServletRequest request, PrintWriter out) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nombre = request.getParameter("txtNombre");
        String departamento = request.getParameter("txtDepartamento");
        
        PersonalBean personal = new PersonalBean();
        
        personal.setCodigo(codigo);
        personal.setNombre(nombre);
        personal.setDepartamento(departamento);
        
        boolean Ok = dao.Modificar(personal);
        
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Personal</title>");            
            out.println("</head>");
            out.println("<body>");
            if (Ok){
                out.println("<h1> Registro modificado con éxito!!! </h1>");
                
            }else{
              out.println("<h1> Error al modificar el registro!!! </h1>");
            }
            
            out.println("<a href=\"incluir.jsp\">Incluir</a> <br> ");
            out.println("<a href=\"modificar.jsp\">Modificar</a> <br>");
            out.println("<a href=\"eliminar.jsp\">Eliminar</a> <br>");
            out.println("<a href=\"AdminDBServlet?prm=listar\">Listar</a> <br>");
            out.println("<a href=\"index.jsp\">Regresar</a> <br>");
            
            out.println("</body>");
            out.println("</html>");
    }

    private void eliminarRegistro(HttpServletRequest request, PrintWriter out) {
        
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        
        boolean Ok = dao.Eliminar(codigo);
        
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Personal</title>");            
            out.println("</head>");
            out.println("<body>");
            if (Ok){
                out.println("<h1> Registro eliminado con éxito!!! </h1>");
                
            }else{
              out.println("<h1> Error al eliminar el registro!!! </h1>");
            }
             
            out.println("<a href=\"incluir.jsp\">Incluir</a> <br> ");
            out.println("<a href=\"modificar.jsp\">Modificar</a> <br>");
            out.println("<a href=\"eliminar.jsp\">Eliminar</a> <br>");
            out.println("<a href=\"AdminDBServlet?prm=listar\">Listar</a> <br>");
            out.println("<a href=\"index.jsp\">Regresar</a> <br>");
            
            out.println("</body>");
            out.println("</html>");
        
    }

    private void listarRegistro(HttpServletRequest request, PrintWriter out) {
               
        ArrayList registros = dao.listar();
        
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Personal</title>");            
            out.println("</head>");
            out.println("<body>");
            
            for (int x = 0; x < registros.size(); x++) {
                // Recuperar y Mostrar los datos ...
                PersonalBean personal = (PersonalBean) registros.get(x);
                
                out.println(personal.getCodigo() + " - " + personal.getNombre() + 
                            " - " + personal.getDepartamento() + "<HR>");
                
            }
            
            
            out.println("<BR><BR><BR><HR>");
            
            out.println("<a href=\"incluir.jsp\">Incluir</a> <br>");
            out.println("<a href=\"modificar.jsp\">Modificar</a> <br>");
            out.println("<a href=\"eliminar.jsp\">Eliminar</a> <br>");
            out.println("<a href=\"AdminDBServlet?prm=listar\">Listar</a> <br>");
            out.println("<a href=\"index.jsp\">Regresar</a> <br>");
            
            out.println("</body>");
            out.println("</html>");
    }

}
