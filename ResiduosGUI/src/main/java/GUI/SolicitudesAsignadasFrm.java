/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.validaciones.SolicitudNegocio;
import entitys.SolicitudTrasladoModel;
import entitys.UsuarioModel;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class SolicitudesAsignadasFrm extends javax.swing.JFrame {

    /**
     * Creates new form SolicitudesAsignadasFrm
     */
    UsuarioModel usuarioActual;
    SolicitudNegocio sn = new SolicitudNegocio();
    DefaultListModel<SolicitudTrasladoModel> modelSolicitudesAsignadas = new DefaultListModel();
    public SolicitudesAsignadasFrm(UsuarioModel usuario) {
         initComponents();
        this.usuarioActual = usuario;
        solicitudesAsignadasList.setModel(modelSolicitudesAsignadas);
        inicializaListaResiduos();
       
    }
    
    public void inicializaListaResiduos() {
        
        List<SolicitudTrasladoModel> listaSolicitudes = sn.obtenerSolicitudes();
        
        for(SolicitudTrasladoModel solicitud: listaSolicitudes){
            if(solicitud.esAsignado() == true){
                modelSolicitudesAsignadas.addElement(solicitud);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        solicitudesAsignadasList = new javax.swing.JList<>();
        btnVolver = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solicitudesAsignadasList.setModel(solicitudesAsignadasList.getModel());
        solicitudesAsignadasList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(solicitudesAsignadasList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 430, 210));

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 50, 30));

        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantalla nueva solicitudes asignadas.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
      SolicitudTrasladoModel solicitud = solicitudesAsignadasList.getSelectedValue();  
      new RegistrarTrasladoFrm(this.usuarioActual, solicitud).setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       new PantallaInicial(this.usuarioActual).setVisible(true);
      this.dispose(); 
    }//GEN-LAST:event_btnVolverActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<SolicitudTrasladoModel> solicitudesAsignadasList;
    // End of variables declaration//GEN-END:variables
}
