package Logica;

import Datos.vConsumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fConsumo {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public int totalRegistros;
    public double totalConsumo;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String [] titulos = {"Id", "idReserva", "idProducto", "Producto", "Cantidad", "Precio de venta", "Estado"};
        String [] registro = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        
        totalRegistros = 0;
        totalConsumo = 0.0;
        sSQL = "select c.idConsumo,c.idReserva,c.idProducto,p.nombre,c.cantidad,c.precioVenta,c.estado" + 
               " from Consumo c inner join Producto p on c.idProducto=p.idProducto" + 
               " where c.idReserva =" + buscar + " order by c.idConsumo desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idConsumo");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("idProducto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precioVenta");
                registro[6] = rs.getString("estado");
                
                totalRegistros = totalRegistros + 1;
                totalConsumo = totalConsumo + (rs.getDouble("cantidad") * rs.getDouble("precioVenta"));
                modelo.addRow(registro);
            }
            
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
    }
    
    public boolean insertar(vConsumo dts){
        sSQL = "insert into Consumo (idReserva,idProducto,cantidad,precioVenta,estado)" + "values (?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setInt(2, dts.getIdProducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecioVenta());
            pst.setString(5, dts.getEstado());
            
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
    
    public boolean editar(vConsumo dts){
        sSQL = "update Consumo set idReserva=?,idProducto=?,cantidad=?,precioVenta=?,estado=?" + " where idConsumo=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setInt(2, dts.getIdProducto());
            pst.setDouble(3, dts.getCantidad());
            pst.setDouble(4, dts.getPrecioVenta());
            pst.setString(5, dts.getEstado());
            pst.setInt(6, dts.getIdConsumo());
            
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
    
    public boolean eliminar(vConsumo dts){
        sSQL = "delete from Consumo where idConsumo=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdConsumo());
            
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
