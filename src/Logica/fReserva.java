package Logica;

import Datos.vReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fReserva {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String [] titulos = {"IdReserva", "IdHabitación", "numero", "idCliente", "Cliente", "idTrabajador", 
                             "Trabajador", "Tipo de reserva", "Fecha de reserva", "Fecha de ingreso", 
                             "Fecha de salida", "Costo de alojamiento", "Estado"};
        String [] registro = new String[13];
        modelo = new DefaultTableModel(null, titulos);
        
        totalRegistros = 0;
        sSQL = "select r.idReserva,r.idHabitacion,h.numero,r.idCliente,(select nombre from Persona where idPersona=r.idCliente)as clienteN," + 
               "(select apellidoPaterno from Persona where idPersona=r.idCliente)as clienteAp,r.idTrabajador," + 
               "(select nombre from Persona where idPersona=r.idTrabajador)as trabajadorN," + 
               "(select apellidoPaterno from Persona where idPersona=r.idTrabajador)as trabajadorAp," + 
               "r.tipoReserva,r.fechaReserva,r.fechaIngreso,r.fechaSalida,r.costoAlojamiento," + 
               "r.estado from Reserva r inner join Habitacion h on r.idHabitacion=h.idHabitacion where r.fechaReserva like '%" + buscar + "%' order by idReserva desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("idHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("idCliente");
                registro[4] = rs.getString("clienteN") + " " + rs.getString("clienteAp");
                registro[5] = rs.getString("idTrabajador");
                registro[6] = rs.getString("trabajadorN") + " " + rs.getString("trabajadorAp");
                registro[7] = rs.getString("tipoReserva");
                registro[8] = rs.getString("fechaReserva");
                registro[9] = rs.getString("fechaIngreso");
                registro[10] = rs.getString("fechaSalida");
                registro[11] = rs.getString("costoAlojamiento");
                registro[12] = rs.getString("estado");
                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
            }
            
            return modelo;    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }   
    }
    
    public boolean insertar(vReserva dts){
        sSQL = "insert into Reserva (idHabitacion,idCliente,idTrabajador,tipoReserva,fechaReserva,fechaIngreso," + 
               "fechaSalida,costoAlojamiento,estado)" + "values (?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdTrabajador());
            pst.setString(4, dts.getTipoReserva());
            pst.setDate(5, dts.getFechaReserva());
            pst.setDate(6, dts.getFechaIngreso());
            pst.setDate(7, dts.getFechaSalida());
            pst.setDouble(8, dts.getCostoAlojamiento());
            pst.setString(9, dts.getEstado());
            
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
    
    public boolean editar(vReserva dts){
        sSQL = "update Reserva set idHabitacion=?,idCliente=?,idTrabajador=?,tipoReserva=?,fechaReserva=?," + 
               "fechaIngreso=?,fechaSalida=?,costoAlojamiento=?,estado=?" + " where idReserva=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdTrabajador());
            pst.setString(4, dts.getTipoReserva());
            pst.setDate(5, dts.getFechaReserva());
            pst.setDate(6, dts.getFechaIngreso());
            pst.setDate(7, dts.getFechaSalida());
            pst.setDouble(8, dts.getCostoAlojamiento());
            pst.setString(9, dts.getEstado());
            pst.setInt(9, dts.getIdReserva());
            
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
    
    public boolean pagar(vReserva dts){
        sSQL = "update Reserva set estado='Pagado'" + " where idReserva=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            
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
    
    public boolean eliminar(vReserva dts){
        sSQL = "delete from Reserva where idReserva=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            
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
