/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author jpablopachar
 */
public class mdInicio extends javax.swing.JFrame {

    /**
     * Creates new form mdInicio
     */
    public mdInicio() {
        initComponents();
        this.setExtendedState(mdInicio.MAXIMIZED_BOTH);
        this.setTitle("Sistema de reserva de habitaciones y gestión de ventas - Hotel Edén");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblIdPersona = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuSisReserva = new javax.swing.JMenu();
        mnuArchivo = new javax.swing.JMenu();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        mnuReservas = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mnuConfiguracion = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        mnuAyuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(0, 150, 136));

        lblIdPersona.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblIdPersona.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPersona.setText("jLabel1");
        escritorio.add(lblIdPersona);
        lblIdPersona.setBounds(30, 20, 130, 18);

        lblNombre.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("jLabel2");
        escritorio.add(lblNombre);
        lblNombre.setBounds(30, 50, 130, 18);

        lblApellidoPaterno.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoPaterno.setText("jLabel3");
        escritorio.add(lblApellidoPaterno);
        lblApellidoPaterno.setBounds(30, 80, 130, 18);

        lblApellidoMaterno.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoMaterno.setText("jLabel4");
        escritorio.add(lblApellidoMaterno);
        lblApellidoMaterno.setBounds(30, 110, 130, 18);

        lblAcceso.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblAcceso.setForeground(new java.awt.Color(255, 255, 255));
        lblAcceso.setText("jLabel5");
        escritorio.add(lblAcceso);
        lblAcceso.setBounds(30, 140, 130, 18);

        mnuSisReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Inicio.png"))); // NOI18N
        mnuSisReserva.setMnemonic('f');
        mnuSisReserva.setText("SisReserva");
        menuBar.add(mnuSisReserva);

        mnuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Archivos.png"))); // NOI18N
        mnuArchivo.setMnemonic('e');
        mnuArchivo.setText("Archivo");

        pasteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        pasteMenuItem.setForeground(new java.awt.Color(33, 33, 33));
        pasteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Habitacion.png"))); // NOI18N
        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Habitación");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        mnuArchivo.add(pasteMenuItem);

        deleteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        deleteMenuItem.setForeground(new java.awt.Color(33, 33, 33));
        deleteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Productos.png"))); // NOI18N
        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Producto");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        mnuArchivo.add(deleteMenuItem);

        menuBar.add(mnuArchivo);

        mnuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Reserva.png"))); // NOI18N
        mnuReservas.setMnemonic('h');
        mnuReservas.setText("Reservas");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        contentMenuItem.setForeground(new java.awt.Color(33, 33, 33));
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Reserva2.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Reservas y consumos");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        mnuReservas.add(contentMenuItem);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenuItem.setForeground(new java.awt.Color(33, 33, 33));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/usuario.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Clientes");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        mnuReservas.add(aboutMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setForeground(new java.awt.Color(33, 33, 33));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Pago.png"))); // NOI18N
        jMenuItem1.setText("Pagos");
        mnuReservas.add(jMenuItem1);

        menuBar.add(mnuReservas);

        mnuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Consulta.png"))); // NOI18N
        mnuConsultas.setText("Consultas");
        menuBar.add(mnuConsultas);

        mnuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Configuracion.png"))); // NOI18N
        mnuConfiguracion.setText("Configuracion");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setForeground(new java.awt.Color(33, 33, 33));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/trabajador.png"))); // NOI18N
        jMenuItem2.setText("Usuarios y anexos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(jMenuItem2);

        menuBar.add(mnuConfiguracion);

        mnuHerramientas.setBackground(new java.awt.Color(0, 150, 136));
        mnuHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Herramientas.png"))); // NOI18N
        mnuHerramientas.setText("Herramientas");
        menuBar.add(mnuHerramientas);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Ayuda.png"))); // NOI18N
        mnuAyuda.setText("Ayuda");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setForeground(new java.awt.Color(33, 33, 33));
        jMenuItem3.setText("Acerca de");
        mnuAyuda.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setForeground(new java.awt.Color(33, 33, 33));
        jMenuItem4.setText("Ayuda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuAyuda.add(jMenuItem4);

        menuBar.add(mnuAyuda);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/SalirSesion.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        menuBar.add(mnuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        // TODO add your handling code here:
        jffHabitacion form = new jffHabitacion();
        
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
        jffProducto form = new jffProducto();
        
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        jffCliente form = new jffCliente();
        
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        jffTrabajador form = new jffTrabajador();
        
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
        jffReserva form = new jffReserva();
        
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
        jffReserva.txtIdTrabajador.setText(lblIdPersona.getText());
        jffReserva.txtIdTrabajador.setText(lblNombre.getText() + " " + lblApellidoPaterno.getText());
        jffReserva.idUsuario = Integer.parseInt(lblIdPersona.getText());
    }//GEN-LAST:event_contentMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mdInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mdInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mdInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mdInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mdInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JLabel lblAcceso;
    public static javax.swing.JLabel lblApellidoMaterno;
    public static javax.swing.JLabel lblApellidoPaterno;
    public static javax.swing.JLabel lblIdPersona;
    public static javax.swing.JLabel lblNombre;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    public static javax.swing.JMenu mnuConfiguracion;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenu mnuReservas;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JMenu mnuSisReserva;
    private javax.swing.JMenuItem pasteMenuItem;
    // End of variables declaration//GEN-END:variables

}