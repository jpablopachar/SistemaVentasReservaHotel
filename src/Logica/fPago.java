package Logica;

import Datos.vPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fPago {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String [] titulos = {"Id", "idReserva", "Tipo de comprobante", "Número de comprobante", "IVA", "Total de pago", "Fecha de emisión", "Fecha de pago"};
        String [] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        
        totalRegistros = 0;
        sSQL = "select * from Pago where idReserva=" + buscar + " order by idPago desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idPago");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("tipoComprobante");
                registro[3] = rs.getString("numComprobante");
                registro[4] = rs.getString("igv");
                registro[5] = rs.getString("totalPago");
                registro[6] = rs.getString("fechaEmision");
                registro[7] = rs.getString("fechaPago");
                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
    }
    
    public boolean insertar(vPago dts){
        sSQL = "insert into Pago (idReserva,tipoComprobante,numComprobante,igv,totalPago,fechaEmision,fechaPago)" + "values (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipoComprobante());
            pst.setString(3, dts.getNumComprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalPago());
            pst.setDate(6, dts.getFechaEmision());
            pst.setDate(7, dts.getFechaPago());
            
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
    
    public boolean editar(vPago dts){
        sSQL = "update Pago set idReserva=?,tipoComprobante=?,numComprobante=?,igv=?,totalPago=?,fechaEmision=?,fechaPago=?" + " where idPago=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipoComprobante());
            pst.setString(3, dts.getNumComprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalPago());
            pst.setDate(6, dts.getFechaEmision());
            pst.setDate(7, dts.getFechaPago());
            pst.setInt(8, dts.getIdPago());
            
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
    
    public boolean eliminar(vPago dts){
        sSQL = "delete from Pago where idPago=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdPago());
            
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
