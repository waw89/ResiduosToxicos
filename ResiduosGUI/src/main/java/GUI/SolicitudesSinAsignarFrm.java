/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import entitys.UsuarioModel;
import entitys.SolicitudTrasladoModel;
import com.validaciones.SolicitudNegocio;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */

public class SolicitudesSinAsignarFrm extends javax.swing.JFrame {

    //Atributos
    UsuarioModel usuarioActual;
    DefaultListModel<SolicitudTrasladoModel> modelSolicitudesSinAsignar = new DefaultListModel<>();
    SolicitudNegocio solicitudNegocio = new SolicitudNegocio();
  
    
    /**
     * Método constructor que inicializa los componentes del frame, inicializa el usuario y asigna e 
     * inicializa la lista de solicitudes sin asignar
     * @param usuario el usuario que seleccionará la solicitud sin asignar
     */
    public SolicitudesSinAsignarFrm(UsuarioModel usuario) {
        initComponents();
        this.usuarioActual = usuario;
        solicitudesSinAsignarList.setModel(modelSolicitudesSinAsignar);
        inicializaListaResiduos();
    }

    /**
     *Método inicializaListaResiduos que obtiene las solicitudes de traslado, selecciona las
     * que se encuentra en estado "sin asignar" y las agrega al modelo de solicitudes sin asignar
     */
    public void inicializaListaResiduos() {
        
        List<SolicitudTrasladoModel> listaSolicitudes = solicitudNegocio.obtenerSolicitudes();
        
        for(SolicitudTrasladoModel solicitud: listaSolicitudes){
            if(solicitud.esAsignado() == false){
                modelSolicitudesSinAsignar.addElement(solicitud);
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        solicitudesSinAsignarList = new javax.swing.JList<>();
        btnVolver = new javax.swing.JButton();
        btnAsignar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        solicitudesSinAsignarList.setModel(solicitudesSinAsignarList.getModel());
        solicitudesSinAsignarList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(solicitudesSinAsignarList);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 480, 200));

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 50, 30));

        btnAsignar.setContentAreaFilled(false);
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantalla nueva solicitudes sin asignar.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 720, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón de asignarActionPerformed que asigna la solicitud sin asignar selecionada de la lista 
     * de solicitudes
     * @param evt el evento de de asignar empresa
     */
    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        SolicitudTrasladoModel solicitud = solicitudesSinAsignarList.getSelectedValue();
        new AsignarEmpresaFrm(this.usuarioActual, solicitud).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       new PantallaInicial(this.usuarioActual).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<SolicitudTrasladoModel> solicitudesSinAsignarList;
    // End of variables declaration//GEN-END:variables
}
