package Logica;

import Datos.vCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fCliente {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String [] titulos = {"Id", "Nombre", "Apellido paterno", "Apellido materno", "Tipo de documento", "Número de documento", "Dirección", "Teléfono", "Email", "Código del cliente"};
        String [] registro = new String[10];
        modelo = new DefaultTableModel(null, titulos);
        
        totalRegistros = 0;
        sSQL = "select p.idPersona,p.nombre,p.apellidoPaterno,p.apellidoMaterno,p.tipoDocumento,p.numDocumento,p.direccion,p.telefono,p.email,c.codigoCliente from Persona p inner join Cliente c on p.idPersona=c.idPersona where numDocumento like '%" + buscar + "%' order by idPersona desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idPersona");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("tipoDocumento");
                registro[5] = rs.getString("numDocumento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("codigoCliente");
                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
    }
    
    public boolean insertar(vCliente dts){
        sSQL = "insert into Persona (nombre,apellidoPaterno,apellidoMaterno,tipoDocumento,numDocumento,direccion,telefono,email)" + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into Cliente (idPersona,codigoCliente)" + "values ((select idPersona from Persona order by idPersona desc limit 1),?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidoPaterno());
            pst.setString(3, dts.getApellidoMaterno());
            pst.setString(4, dts.getTipoDocumento());
            pst.setString(5, dts.getNumDocumento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst2.setString(1, dts.getCodigoCliente());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(vCliente dts){
        sSQL = "update Persona set nombre=?,apellidoPaterno=?,apellidoMaterno=?,tipoDocumento=?,numDocumento=?,direccion=?,telefono=?,email=? where idPersona=?";
        sSQL2 = "update Cliente set codigoCliente=?" + " where idPersona=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidoPaterno());
            pst.setString(3, dts.getApellidoMaterno());
            pst.setString(4, dts.getTipoDocumento());
            pst.setString(5, dts.getNumDocumento());
            pst.setString(6, dts.getDireccion());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdPersona());
            pst2.setString(1, dts.getCodigoCliente());
            pst2.setInt(2, dts.getIdPersona());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminar(vCliente dts){
        sSQL = "delete from Cliente where idPersona=?";
        sSQL2 = "delete from Persona where idPersona=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            pst.setInt(1, dts.getIdPersona());
            pst2.setInt(1, dts.getIdPersona());
            
            int n = pst.executeUpdate();
            
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
