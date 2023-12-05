/*
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.dto.DTORegistraTraslado;
import com.github.lgooddatepicker.components.DatePicker;
import com.validaciones.TrasladoNegocio;
import com.validaciones.VehiculoNegocio;
import entitys.SolicitudTrasladoModel;
import entitys.UsuarioModel;
import entitys.VehiculoModel;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author xfs85
 */
public class RegistrarTrasladoFrm extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarTraslado
     */
    UsuarioModel usuarioActual;
    SolicitudTrasladoModel solicitudActual;
    VehiculoNegocio vn = new VehiculoNegocio();
    DefaultTableModel tableModelVehiculos = new DefaultTableModel();
    TrasladoNegocio tn = new TrasladoNegocio();
    private javax.swing.JCheckBox JCheckBox;

    public RegistrarTrasladoFrm(UsuarioModel usuario, SolicitudTrasladoModel solicitud) {
        this.usuarioActual = usuario;
        this.solicitudActual = solicitud;
        initComponents();
        
        tableModelVehiculos.addColumn("ID");
        tableModelVehiculos.addColumn("");
        tableModelVehiculos.addColumn("Linea");
        tableModelVehiculos.addColumn("Marca");
        tableModelVehiculos.addColumn("Modelo");
        tableModelVehiculos.addColumn("Tipo");
        JCheckBox = new javax.swing.JCheckBox();
        tablaVehiculos.setModel(tableModelVehiculos);
        cargarVehiculos();

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
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable();
        btnRegistrarTraslado = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        fechaLlegadaPicker = new com.github.lgooddatepicker.components.DatePicker();
        txtKm = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTratamiento = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(false), null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaVehiculos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 127, 280, 190));

        btnRegistrarTraslado.setContentAreaFilled(false);
        btnRegistrarTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTrasladoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarTraslado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 160, 30));

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 33, 40, 30));
        jPanel1.add(fechaLlegadaPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, -1));
        jPanel1.add(txtKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 50, -1));
        jPanel1.add(txtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 50, -1));

        txtTratamiento.setColumns(20);
        txtTratamiento.setRows(5);
        jScrollPane1.setViewportView(txtTratamiento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 250, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantalla nueva registrar traslado 2.png"))); // NOI18N
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

    private void cargarVehiculos() {
        List<VehiculoModel> vehiculos = vn.obtenerVehiculos(this.usuarioActual.getId());
        tableModelVehiculos.setRowCount(0);

        for (VehiculoModel vehiculo : vehiculos) {
            Object[] fila = {
                vehiculo.getId(),
                false,
                vehiculo.getLinea(),
                vehiculo.getMarca(),
                vehiculo.getMarca(),
                vehiculo.getModelo()
            };
            tableModelVehiculos.addRow(fila);

            addCheckbox(1, tablaVehiculos);
        }

    }

    public void addCheckbox(int column, JTable table) {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }


    private void btnRegistrarTrasladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTrasladoActionPerformed
            
            if(valVehiculo()==true){
                mostrarError("Seleccione vehiculo para el traslado", "Error", "Error al Seleccionar");
            }else if(valKm()==true){
                mostrarError("Ingresar cantidad de Kilometros", "Error", "Error al registrar");
                txtKm.setBackground(Color.pink);
            }else if(valFecha()==true){
                mostrarError("Ingresar Fecha correcta", "Error", "Error al registrar");
                fechaLlegadaPicker.setBackground(Color.pink);
            }else if(fechaLlegadaPicker.getDate().isBefore(LocalDate.now())){
                mostrarError("La fecha no puede ser anterior a la actual", "Error", "Error al registrar");
                fechaLlegadaPicker.setBackground(Color.pink);
                fechaLlegadaPicker.setDate(null);
            }else if(valCosto()==true){
                mostrarError("Ingresar Costo del Traslado", "Error", "Error al registrar");
                txtCosto.setBackground(Color.pink);
            }else if(valTrat()==true){
                mostrarError("Ingresar Tratamiento del Traslado", "Error", "Error al registrar");
                txtTratamiento.setBackground(Color.pink);
            } else {
                List<VehiculoModel> vehiculos = new ArrayList<>();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                new PantallaInicial(this.usuarioActual).setVisible(true);
                this.dispose();
                vn.convertirVehiculos(obtieneIdsVehiculos());
                DTORegistraTraslado DTORegistraTraslado = new DTORegistraTraslado();
                DTORegistraTraslado.setCosto(Float.parseFloat(this.txtCosto.getText()));
                DTORegistraTraslado.setKms(Float.parseFloat(this.txtKm.getText()));
                DTORegistraTraslado.setTratamiento(this.txtTratamiento.getText());
                DTORegistraTraslado.setidsVehiculos(obtieneIdsVehiculos());
                DTORegistraTraslado.setFecha(this.fechaLlegadaPicker.getDate());
                DTORegistraTraslado.setSolicitud(this.solicitudActual);

                if(obtieneIdsVehiculos().size() > 1){
                    DTORegistraTraslado.setTipo("Por Partes");
                }else{
                    DTORegistraTraslado.setTipo("Simple");
                }

                tn.guardar(DTORegistraTraslado);
            }
        
        
        
        
        
        
    }//GEN-LAST:event_btnRegistrarTrasladoActionPerformed

    public List<Long> obtieneIdsVehiculos() {

        int i = tableModelVehiculos.getRowCount();
        List<Long> idsVehiculos = new ArrayList<Long>();
        for (int j = 0; j < i; j++) {
            if ((boolean)tableModelVehiculos.getValueAt(j, 1) == true) {
                idsVehiculos.add((Long) tableModelVehiculos.getValueAt(j, 0));
            }

        }
        return idsVehiculos;
    }
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new SolicitudesAsignadasFrm(this.usuarioActual).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarTraslado;
    private javax.swing.JButton btnVolver;
    private com.github.lgooddatepicker.components.DatePicker fechaLlegadaPicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextArea txtTratamiento;
    // End of variables declaration//GEN-END:variables
 
    public boolean valVehiculo(){
        return tableModelVehiculos.getRowCount()>0;
    }
    
    public boolean valKm(){
        return txtKm.getText().isEmpty();
    }
    
    public boolean valFecha(){
        return fechaLlegadaPicker.getDate()==null;
    }
    
    public boolean valCosto(){
        return txtCosto.getText().isEmpty();
    }
    
    public boolean valTrat(){
        return txtTratamiento.getText().isEmpty();
    }
    
    public void mostrarError(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
}
