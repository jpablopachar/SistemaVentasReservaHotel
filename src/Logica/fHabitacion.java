package Logica;

import Datos.vHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fHabitacion {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String [] titulos = {"Id", "Número", "Piso", "Descripción", "Características", "Precio diario", "Estado", "Tipo de Habitación"};
        String [] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        
        totalRegistros = 0;
        sSQL = "select * from Habitacion where piso like '%" + buscar + "%' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precioDiario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipoHabitacion");
                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
    }
    
    public DefaultTableModel mostrarVista(String buscar) {
        DefaultTableModel modelo;
        String [] titulos = {"Id", "Número", "Piso", "Descripción", "Características", "Precio diario", "Estado", "Tipo de Habitación"};
        String [] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        
        totalRegistros = 0;
        sSQL = "select * from Habitacion where piso like '%" + buscar + "%' and estado='Disponible' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idHabitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precioDiario");
                registro[6] = rs.getString("estado");
                registro[7] = rs.getString("tipoHabitacion");
                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
    }
    
    public boolean insertar(vHabitacion dts) {
        sSQL = "insert into Habitacion (numero,piso,descripcion,caracteristicas,precioDiario,estado,tipoHabitacion)" + "values (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecioDiario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipoHabitacion());
            
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
    
    public boolean editar(vHabitacion dts) {
        sSQL = "update Habitacion set numero=?,piso=?,descripcion=?,caracteristicas=?,precioDiario=?,estado=?,tipoHabitacion=?" + " where idHabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecioDiario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipoHabitacion());
            pst.setInt(8, dts.getIdHabitacion());
            
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
    
    public boolean desocupar(vHabitacion dts) {
        sSQL = "update Habitacion set estado='Disponible'" + " where idHabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            
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
    
    public boolean ocupar(vHabitacion dts) {
        sSQL = "update Habitacion set estado='Ocupado'" + " where idHabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            
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
    
    public boolean eliminar(vHabitacion dts) {
        sSQL = "delete from Habitacion where idHabitacion=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            
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
