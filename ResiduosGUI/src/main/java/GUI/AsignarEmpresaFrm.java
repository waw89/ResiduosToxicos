/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.dto.DTOSolicitaTraslado;
import com.utilerias.Util;
import entitys.ResiduoModel;
import entitys.UsuarioModel;
import entitys.TransportistaModel;
import entitys.SolicitudTrasladoModel;
import com.validaciones.ResiduoNegocio;
import com.validaciones.SolicitudNegocio;
import com.validaciones.TransportistaNegocio;
import com.validaciones.SolicitudNegocio;
import entitys.Especificacion_Residuos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class AsignarEmpresaFrm extends javax.swing.JFrame {

    //Atributos
    DefaultListModel<Especificacion_Residuos> modelResiduosATransportar = new DefaultListModel<>();
    DefaultListModel<TransportistaModel> modelEmpresasDisponibles = new DefaultListModel<>();
    DefaultListModel<TransportistaModel> modelEmpresasSeleccionadas = new DefaultListModel<>();
    UsuarioModel usuarioActual;
    SolicitudTrasladoModel solicitud;
    TransportistaNegocio transportistaNegocio = new TransportistaNegocio();
    SolicitudNegocio  solicitudNegocio = new SolicitudNegocio();
    
    
    /**
     * Creates new form AsignarEmpresaFrm
     * @param usuario
     * @param solicitud
     */
    public AsignarEmpresaFrm(UsuarioModel usuario, SolicitudTrasladoModel solicitud) {
        initComponents();
        this.usuarioActual = usuario;
        this.solicitud = solicitud;
        residuosATransportarList.setModel(modelResiduosATransportar);
        empresasDisponiblesList.setModel(modelEmpresasDisponibles);
        empresasSeleccionadasList.setModel(modelEmpresasSeleccionadas);
        inicializaListaResiduos();
        inicializaListaEmpresasTransportistas();
        
        labelProductor.setText(solicitud.getProd().getUsuario());
        labelFecha.setText(String.valueOf(solicitud.getFecha()));
    }
    
    
    /**
     *Método inicializaListaResiduos que obtiene los residuos de la solicitud de traslado, selecciona los
     *residuos que no cuentan con asignación de empresa y los agrega al modelo de residuos a transportar
     */
    public void inicializaListaResiduos() {
        
//        List<Especificacion_Residuos> listaResiduos = this.solicitud.getListaResiduos();
        List<Especificacion_Residuos> listaResiduos = solicitudNegocio.obtenerListaEspecificacionesResiduos();
     
        for(Especificacion_Residuos especificacion: listaResiduos){
            if(this.solicitud.getId() == especificacion.getSolicitud().getId()){
                if(especificacion.isAsignado() == false){
                    modelResiduosATransportar.addElement(especificacion);
                }
                
            }
                
        }
    }
    
    
    /**
     *Método inicializaListaEmpresasTransportistas que obtiene las empresas transportistas y las agrega al 
     *modelo de empresas disponibles
     */
    public void inicializaListaEmpresasTransportistas(){
        List<TransportistaModel> listaTransportistas = transportistaNegocio.obtenerTransportistas();
        
        for(TransportistaModel transportista: listaTransportistas){
            modelEmpresasDisponibles.addElement(transportista);
        }
    }

    
    /**
     * Método obtenerListaDeTransportistas que obtiene las empresas seleccionadas de la JList
     * para asignarlas 
     * @return la lista de empresas transportistas seleccionadas
     */
    public List<TransportistaModel> obtenerListaDeTransportistas() {
        List<TransportistaModel> transportistasSeleccionados = new ArrayList<>();
        for (int i = 0; i < modelEmpresasSeleccionadas.size(); i++) {
            TransportistaModel transportistaActual = modelEmpresasSeleccionadas.getElementAt(i);
            transportistasSeleccionados.add(transportistaActual);
        }
        return transportistasSeleccionados;
    }
    
    /**
     * Método eliminaDeListaDisponibles que elimina de la lista de empresas transportistas disponibes 
     * la empresa seleccionada
     */
    public void eliminaDeListaDisponibles() {
        modelEmpresasDisponibles.removeElementAt(empresasDisponiblesList.getSelectedIndex());
    }

    /**
     * Método agregaAListaDisponibles que agrega a la lista de empresas transportistas disponibles la 
     * empresa seleccionada desde la lista de empresas seleccionadas
     */
    public void agregaAListaDisponibles() {
        modelEmpresasDisponibles.addElement(empresasSeleccionadasList.getSelectedValue());
    }

    /**
     * Método eliminaDeListaSeleccionados que elimina de la lista de empresas seleccionadas la empresa 
     * seleccionada
     */
    public void eliminaDeListaSeleccionados() {
        modelEmpresasSeleccionadas.removeElementAt(empresasSeleccionadasList.getSelectedIndex());
    }

    /**
     * 
     */
    public void agregaAListaSeleccionados() {
        modelEmpresasSeleccionadas.addElement(empresasDisponiblesList.getSelectedValue());
    }
    
    public void mostrarError (String mensaje, String tipo, String titulo){
        JOptionPane optionPane = new JOptionPane(mensaje);
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if(tipo.equals("Error")){
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);      
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
        btnVolver = new javax.swing.JButton();
        btnAsignar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        residuosATransportarList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        empresasDisponiblesList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        empresasSeleccionadasList = new javax.swing.JList<>();
        labelProductor = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 33, 40, 30));

        btnAsignar.setContentAreaFilled(false);
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 403, 160, 30));

        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 80, 30));

        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 153, 80, 30));

        residuosATransportarList.setModel(residuosATransportarList.getModel());
        residuosATransportarList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(residuosATransportarList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 220, 130));

        empresasDisponiblesList.setModel(empresasDisponiblesList.getModel());
        empresasDisponiblesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(empresasDisponiblesList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 180, 100));

        empresasSeleccionadasList.setModel(empresasSeleccionadasList.getModel());
        empresasSeleccionadasList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(empresasSeleccionadasList);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 180, 110));

        labelProductor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelProductor.setForeground(new java.awt.Color(255, 255, 255));
        labelProductor.setText("jLabel2");
        jPanel1.add(labelProductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 100, -1));

        labelFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(255, 255, 255));
        labelFecha.setText("jLabel3");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 110, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantalla nueva asignar traslado.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 720, 490));

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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
      new SolicitudesSinAsignarFrm(this.usuarioActual).setVisible(true);
      this.dispose();
      
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed

        DTOSolicitaTraslado dtoSolicitaTraslado = new DTOSolicitaTraslado();
        Util util = new Util();
        Especificacion_Residuos especificacion = residuosATransportarList.getSelectedValue();
        especificacion.setAsignado(true);
        dtoSolicitaTraslado = util.convertirSolicitudTrasladoASolicitudTrasladoDTO(especificacion.getSolicitud());
        dtoSolicitaTraslado.setTransportistas(obtenerListaDeTransportistas());
        dtoSolicitaTraslado.setAsignado(true);
        solicitudNegocio.actualizar(dtoSolicitaTraslado, especificacion);
        
        JOptionPane.showMessageDialog(null, "Asignación Exitosa");
        new PantallaInicial(this.usuarioActual).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (empresasDisponiblesList.getSelectedIndex() != -1) {
            agregaAListaSeleccionados();
            eliminaDeListaDisponibles();
        } else if (empresasSeleccionadasList.getSelectedIndex() != -1) {
            mostrarError("No puedes agregar ninguna empresa aquí", "Error", "Error al Agregar");
        }else{
           mostrarError("No seleccionó ninguna empresa", "Error", "Error al Agregar"); 
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (empresasSeleccionadasList.getSelectedIndex() != -1) {
            agregaAListaDisponibles();
            eliminaDeListaSeleccionados();
        } else if (empresasDisponiblesList.getSelectedIndex() != -1) {
            mostrarError("No puedes eliminar una empresa de aquí", "Error", "Error al Eliminar");
        } else {
            mostrarError("No seleccionó ninguna empresa", "Error", "Error al Eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JList<TransportistaModel> empresasDisponiblesList;
    private javax.swing.JList<TransportistaModel> empresasSeleccionadasList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelProductor;
    private javax.swing.JList<Especificacion_Residuos> residuosATransportarList;
    // End of variables declaration//GEN-END:variables
}
