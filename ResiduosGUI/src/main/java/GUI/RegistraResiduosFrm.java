/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import code.Productor;
import code.Usuario;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class RegistraResiduosFrm extends javax.swing.JFrame {
        
    /**
     * Creates new form RegistraResiduosFrm
     */
    DefaultListModel<String> modelDisponibles = new DefaultListModel<>();
    DefaultListModel<String> modelSeleccionados = new DefaultListModel<>();

    public RegistraResiduosFrm(Usuario usuario) {
        initComponents();
        quimicosDisponiblesList.setModel(modelDisponibles);
        quimicosReservadosList.setModel(modelSeleccionados);
        inicializaLista();
        this.setTitle("Registrar Residuos");
    }
    
    
    public void inicializaLista() {

        modelDisponibles.addElement("Cloro");
        modelDisponibles.addElement("Cianuro");
        modelDisponibles.addElement("Plomo");
        modelDisponibles.addElement("Amoniaco");
        
        
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
        jScrollPane5 = new javax.swing.JScrollPane();
        quimicosReservadosList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        quimicosDisponiblesList = new javax.swing.JList<>();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        eliminarBtn = new javax.swing.JButton();
        agregarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 40, 30));

        jScrollPane5.setBorder(null);

        quimicosReservadosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(quimicosReservadosList);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 170, 130));

        jScrollPane2.setBorder(null);

        quimicosDisponiblesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(quimicosDisponiblesList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, 130));

        txtCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 50));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 340, 50));

        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantalla Registrar Residuo - Residuos Tóxicos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 720, 480));

        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 332, 90, 30));

        agregarBtn.setText("Agregar");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 152, 90, 30));

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

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        // TODO add your handling code here:
        if (quimicosDisponiblesList.getSelectedIndex() != -1) {
            agregaAListaSeleccionados();
            eliminaDeListaDisponibles();
        } else if (quimicosReservadosList.getSelectedIndex() != -1) {
            mostrarMensaje("No puedes agregar ningun quimico aquí", "Error", "Error al Agregar");
        } else {
            mostrarMensaje("No seleccionó ningun quimico", "Error", "Error al Agregar");
        }
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:
        if (quimicosReservadosList.getSelectedIndex() != -1) {
            agregaAListaDisponibles();
            eliminaDeListaSeleccionados();
        } else if (quimicosDisponiblesList.getSelectedIndex() != -1) {
            mostrarMensaje("No puedes eliminar un quimico de aquí", "Error", "Error al Eliminar");
        } else {
            mostrarMensaje("No seleccionó ningun quimico", "Error", "Error al Eliminar");
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        JOptionPane.showMessageDialog(null, "Registro Exitoso");
        Usuario usuario = new Usuario();
        usuario.setTipo("Productor");
        new PantallaInicial(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
     Usuario usuario = new Usuario();
        usuario.setTipo("Productor");
        new PantallaInicial(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    public void eliminaDeListaDisponibles() {
        modelDisponibles.removeElementAt(quimicosDisponiblesList.getSelectedIndex());
    }

    public void agregaAListaDisponibles() {
        modelDisponibles.addElement(quimicosReservadosList.getSelectedValue());
    }

    public void eliminaDeListaSeleccionados() {
        modelSeleccionados.removeElementAt(quimicosReservadosList.getSelectedIndex());
    }

    public void agregaAListaSeleccionados() {
        modelSeleccionados.addElement(quimicosDisponiblesList.getSelectedValue());
    }
    public void mostrarMensaje (String mensaje, String tipo, String titulo){
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> quimicosDisponiblesList;
    private javax.swing.JList<String> quimicosReservadosList;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public static void main (String [] args){
               /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
               Productor p = new Productor();
               p.setTipo("Productor");
               
               new PantallaInicial(p).setVisible(true);
               
            }
        });
    }

}
