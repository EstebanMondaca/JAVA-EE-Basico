
package application.dao;

import application.bean.PersonalBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                
                psmtInsertar = con.prepareStatement("insert into PERSONAL values (?,?,?)");
                psmtModificar = con.prepareStatement("update PERSONAL set NOMBRE = ?, " + 
                                "DEPARTAMENTO = ?, where CODIGO = ?");
                psmtEliminar = con.prepareStatement("delete from PERSONAL where CODIGO = ?");
                psmtListar = con.prepareStatement("select * from PERSONAL where CODIGO = ?");
                
                rsRegistros = psmtRegistros.executeQuery();
                
            } catch (SQLException ex) {
                    //Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
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
                
                rsRegistros = psmtRegistros.executeQuery();
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
                
                rsRegistros = psmtRegistros.executeQuery();
                return true;
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }
        
        public boolean Eliminar(int codigo){
            try {
                psmtEliminar.setInt(1, codigo);
            
                //psmtEliminar.executeUpdate();
                rsRegistros = psmtRegistros.executeQuery();
                return true;
                
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }
        
        
        
}


