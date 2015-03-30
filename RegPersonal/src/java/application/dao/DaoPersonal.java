
package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EstebanVaio
 */

public class DaoPersonal {
    
        private Connection con;
        
        public DaoPersonal(){
        
            try {
              // cargar el driver JDBC
                Class.forName("org.apache.derby.jdbc.ClientDriver");
              
                String url = "jdbc:derby://localhost:1527/datos";
                String user = "root";
                String pass = "root";

                //Conexión con la Base de Datos...
                 
                Connection con = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                    //Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                    //Logger.getLogger(DaoPersonal.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error: " + ex.getMessage());
            }
            
        }
}


