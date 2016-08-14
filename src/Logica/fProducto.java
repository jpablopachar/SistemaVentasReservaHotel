package Logica;

import Datos.vProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fProducto {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String [] titulos = {"Id", "Nombre", "Descripción", "Unidad de medida", "Precio de venta"};
        String [] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        
        totalRegistros = 0;
        sSQL = "select * from Producto where nombre like '%" + buscar + "%' order by idProducto desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");
                registro[3] = rs.getString("unidadMedida");
                registro[4] = rs.getString("precioVenta");
                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
    }
    
    public boolean insertar(vProducto dts){
        sSQL = "insert into Producto (nombre,descripcion,unidadMedida,precioVenta)" + "values (?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidadMedida());
            pst.setDouble(4, dts.getPrecioVenta());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(vProducto dts){
        sSQL = "update Producto set nombre=?,descripcion=?,unidadMedida=?,precioVenta=?" + " where idProducto=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidadMedida());
            pst.setDouble(4, dts.getPrecioVenta());
            pst.setInt(5, dts.getIdProducto());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminar(vProducto dts){
        sSQL = "delete from Producto where idProducto=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdProducto());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
