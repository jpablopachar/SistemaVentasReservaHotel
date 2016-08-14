package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    public String db = "baseReserva";
    public String url ="jdbc:mysql://127.0.0.1/" + db;
    public String user = "root";
    public String pass = "";

    public conexion() {
    }
    
    public Connection conectar() {
        Connection link = null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;
    }
}
