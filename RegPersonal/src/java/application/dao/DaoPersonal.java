
package application.dao;

import application.bean.PersonalBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EstebanVaio
 */

public class DaoPersonal {
    
        private Connection con;
        private PreparedStatement psmtInsertar;
        private PreparedStatement psmtModificar;
        private PreparedStatement psmtEliminar;
        private PreparedStatement psmtListar;
        private PreparedStatement psmtRegistros;
        
        private ResultSet rsRegistros;
        
        public DaoPersonal(){
        
            try {
              // cargar el driver JDBC
                Class.forName("org.apache.derby.jdbc.ClientDriver");
              
                String url = "jdbc:derby://localhost:1527/datos";
                String user = "root";
                String pass = "root";

                //Conexión con la Base de Datos...
                 
                con = DriverManager.getConnection(url, user, pass);
                
                psmtInsertar = con.prepareStatement("INSERT INTO PERSONAL values (?, ?, ?)");
                psmtModificar = con.prepareStatement("update PERSONAL set NOMBRE = ?, DEPARTAMENTO = ? where CODIGO = ?");
                psmtEliminar = con.prepareStatement("delete from PERSONAL where CODIGO = ?");
                psmtListar = con.prepareStatement("select * from PERSONAL where CODIGO = ?");
                psmtRegistros = con.prepareStatement("select * from PERSONAL ");
                
                rsRegistros = psmtRegistros.executeQuery();
                
            } 
            catch (ClassNotFoundException | SQLException ex) {
                    //Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: " + ex.getMessage());
            } 
            
        }
        
        public boolean Insertar(PersonalBean personal){
            try {
                psmtInsertar.setInt(1, personal.getCodigo());
                psmtInsertar.setString(2, personal.getNombre());
                psmtInsertar.setString(3, personal.getDepartamento());
                psmtInsertar.executeUpdate();
                //rsRegistros = psmtInsertar.executeQuery();
                //psmtRegistros.executeQuery();
                return true;
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
            
            
        }
        
        public boolean Modificar(PersonalBean personal){
            try {
                psmtModificar.setInt(1, personal.getCodigo());
                psmtModificar.setString(2, personal.getNombre());
                psmtModificar.setString(3, personal.getDepartamento());
                psmtModificar.executeUpdate();
                psmtRegistros.executeQuery();
                //rsRegistros = psmtRegistros.executeQuery();
                return true;
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }
        
        public boolean Eliminar(int codigo){
            try {
                psmtEliminar.setInt(1, codigo);
            
                psmtEliminar.executeUpdate();
                rsRegistros = psmtRegistros.executeQuery();
                return true;
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }
        
        public ArrayList listar(){
            try {
                ArrayList listadoRetorno = new ArrayList();
                
                while(rsRegistros.next()){
                    
                    PersonalBean personal = new PersonalBean();
                    
                    //recuperar los datos ...
                    
                    personal.setCodigo(rsRegistros.getInt("CODIGO"));
                    personal.setNombre(rsRegistros.getString("NOMBRE"));
                    personal.setDepartamento(rsRegistros.getString("DEPARTAMENTO"));
                    
                    listadoRetorno.add(personal);
                    
                }
                
                return listadoRetorno;
                
            } catch (SQLException ex) {
                Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
                
            
            
        }
        
}


