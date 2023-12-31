/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import com.dto.DTOSolicitaTraslado;
import com.validaciones.ResiduoNegocio;
import com.validaciones.SolicitudNegocio;
import entitys.ProductorModel;
import entitys.ResiduoModel;
import entitys.UsuarioModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Frame que representa el caso de uso "Solicitar traslado"
 *
 * @author PC
 */
public class SolicitarTrasladosFrm extends javax.swing.JFrame {

    DefaultListModel<String> modelDisponibles = new DefaultListModel<>();
    DefaultListModel<String> modelSeleccionados = new DefaultListModel<>();
    ResiduoNegocio rn = new ResiduoNegocio();
    UsuarioModel usuarioActual;
    SolicitudNegocio solicitudNeg = new SolicitudNegocio();
    List<Float> cantidadesResiduos = new ArrayList<>();

    /**
     * Creates new form SolicitarTraslados
     */
    public SolicitarTrasladosFrm(UsuarioModel usuario) {
        initComponents();
        this.usuarioActual = usuario;
        residuosDisponiblesList.setModel(modelDisponibles);
        residuosSeleccionadosList.setModel(modelSeleccionados);
        inicializaLista();
        inicializaListeners();
        this.setTitle("Solicitar Traslados");
    }

    /**
     * Metodo que inicializa y muestra la lista de residuos
     */
    public void inicializaLista() {

        List<ResiduoModel> listaResiduos = rn.obtenerResiduos();

        for (ResiduoModel residuo : listaResiduos) {
            modelDisponibles.addElement(residuo.getNombre());
        }

    }

    /**
     * Metodo que se encarga de inicializar los listeners para las listas
     */
    private void inicializaListeners() {

        residuosDisponiblesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                    boolean hayElementosSeleccionados = residuosDisponiblesList.getSelectedIndex() != -1;

                    // Habilita o deshabilita el campo de texto según si hay elementos seleccionados
                    txtCantidad.setEnabled(hayElementosSeleccionados);
                    comboCantidad.setEnabled(hayElementosSeleccionados);
                }
            }
        });
    }

    /**
     * Metodo que verifica la unidad de medida para la cantidad del residuo
     *
     * @return
     */
    public boolean verificaComboCantidad() {

        if (comboCantidad.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una unidad de medida", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Metodo que verifica el formato de la cantidad del residuo
     *
     * @return
     */
    public boolean verificaFormatoCantidadDeResiduo() {
        String cantidad = txtCantidad.getText();

        if (cantidad.matches("\\d+")) {

            int cantidadResiduo = Integer.parseInt(cantidad);

            if (cantidadResiduo <= 0) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido", "Error", JOptionPane.ERROR_MESSAGE);
                txtCantidad.setText("");
                return false;
            }
        } else {

            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico", "Error", JOptionPane.ERROR_MESSAGE);

            txtCantidad.setText("");

            return false;
        }
        return true;

    }

    /**
     * Metodo que verifica el formato de la fecha de la solicitud
     *
     * @return
     */
    public boolean verificarFecha() {
        LocalDate fechaSeleccionada = calendario.getSelectedDate();
        LocalDate fechaActual = LocalDate.now();

        if (fechaSeleccionada == null) {

            return false;
        }
        if (fechaSeleccionada.isBefore(fechaActual) || fechaSeleccionada.equals(fechaActual)) {
            return false;
        }

        return true;
    }

    /**
     * Metodo que verifica si se han seleccionado al menos un residuo
     *
     * @return
     */
    public boolean verificarSeleccion() {
        int cantidadSeleccionada = modelSeleccionados.size();

        if (cantidadSeleccionada < 1) {
            mostrarError("Debe seleccionar al menos un residuo", "Error", "Error al registrar");
            return false;
        }

        return true;
    }

    /**
     * Metodo que obtiene la lista de residuos seleccionados
     *
     * @return
     */
    public List<ResiduoModel> obtenerListaDeResiduos() {
        List<ResiduoModel> residuosSeleccionados = new ArrayList<>();
        for (int i = 0; i < modelSeleccionados.size(); i++) {
            String residuoActual = modelSeleccionados.getElementAt(i);
            ResiduoModel residuo = rn.buscarResiduoPorNombre(residuoActual);
            residuosSeleccionados.add(residuo);
        }
        return residuosSeleccionados;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        calendario = new com.github.lgooddatepicker.components.CalendarPanel();
        comboCantidad = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSolicitar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        residuosSeleccionadosList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        residuosDisponiblesList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 230, -1));

        comboCantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilos", "Litros" }));
        comboCantidad.setSelectedIndex(-1);
        comboCantidad.setEnabled(false);
        jPanel3.add(comboCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 60, -1));

        btnAgregar.setBorder(null);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 90, 20));

        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 80, 30));

        btnSolicitar.setContentAreaFilled(false);
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });
        jPanel3.add(btnSolicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 150, 30));

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel3.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 33, 40, 30));

        txtCantidad.setEnabled(false);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 60, -1));

        jScrollPane3.setBorder(null);

        residuosSeleccionadosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(residuosSeleccionadosList);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 170, 130));

        jScrollPane2.setBorder(null);

        residuosDisponiblesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(residuosDisponiblesList);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 170, 130));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas - Solicitar Traslado 2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo action performed para el botón "agregar"
     *
     * @param evt
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (verificaFormatoCantidadDeResiduo() == true) {
            if (verificaComboCantidad() == true) {

                if (residuosDisponiblesList.getSelectedIndex() != -1) {
                    agregaAListaSeleccionados();
                    eliminaDeListaDisponibles();
                } else if (residuosSeleccionadosList.getSelectedIndex() != -1) {
                    mostrarError("No puedes agregar ningun quimico aquí", "Error", "Error al Agregar");
                } else {
                    mostrarError("No seleccionó ningun quimico", "Error", "Error al Agregar");
                }
            }

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    /**
     * Metodo action performed para el botón "eliminar"
     *
     * @param evt
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (residuosSeleccionadosList.getSelectedIndex() != -1) {
            agregaAListaDisponibles();
            eliminaDeListaSeleccionados();
        } else if (residuosDisponiblesList.getSelectedIndex() != -1) {
            mostrarError("No puedes eliminar un quimico de aquí", "Error", "Error al Eliminar");
        } else {
            mostrarError("No seleccionó ningun quimico", "Error", "Error al Eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Metodo action performed para el botón "solicitar"
     *
     * @param evt
     */
    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        if (verificarSeleccion() == true) {
            if (verificarFecha() == false) {
                mostrarError("Seleccione una fecha valida", "Error", "Error al Solicitar");
            } else {
                if (solicitudNeg.verificarMaximoTrasladosPorDia(this.calendario.getSelectedDate()) == true) {

                    DTOSolicitaTraslado dtoSolicitaTraslado = new DTOSolicitaTraslado();
                    dtoSolicitaTraslado.setAsignado(false);
                    dtoSolicitaTraslado.setFecha(this.calendario.getSelectedDate());
                    dtoSolicitaTraslado.setResiduos(obtenerListaDeResiduos());
                    dtoSolicitaTraslado.setProductor((ProductorModel) this.usuarioActual);

                    solicitudNeg.guardar(dtoSolicitaTraslado);

                    solicitudNeg.actualizaCantidadDelResiduo(this.cantidadesResiduos);
                    JOptionPane.showMessageDialog(null, "Solicitud Exitosa");

                    this.usuarioActual.setTipo("Productor");
                    new PantallaInicial(this.usuarioActual).setVisible(true);
                    this.dispose();

                } else {
                    mostrarError("Se tienen 5 solicitudes en ese mismo día, seleccione otro", "Error", "Error al solicitar");
                }
            }
        }


    }//GEN-LAST:event_btnSolicitarActionPerformed

    /**
     * Metodo action performed para el botón "volver"
     *
     * @param evt
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        this.usuarioActual.setTipo("Productor");
        new PantallaInicial(this.usuarioActual).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    /**
     * Metodo que elimina residuo de la lista de disponibles
     *
     */
    public void eliminaDeListaDisponibles() {
        modelDisponibles.removeElementAt(residuosDisponiblesList.getSelectedIndex());
    }

    /**
     * Metodo que agrega residuo de la lista de disponibles
     *
     */
    public void agregaAListaDisponibles() {
        modelDisponibles.addElement(residuosSeleccionadosList.getSelectedValue());
    }

    /**
     * Metodo que elimina residuo de la lista de seleccionados
     *
     */
    public void eliminaDeListaSeleccionados() {
        this.cantidadesResiduos.remove(this.residuosSeleccionadosList.getSelectedIndex());
        modelSeleccionados.removeElementAt(residuosSeleccionadosList.getSelectedIndex());

    }

    /**
     * Metodo que agrega residuo de la lista de seleccionados
     *
     */
    public void agregaAListaSeleccionados() {
        modelSeleccionados.addElement(residuosDisponiblesList.getSelectedValue());
        cantidadesResiduos.add(Float.parseFloat(this.txtCantidad.getText()));
    }

    /**
     * Metodo que genera un mensaje de error
     *
     * @param mensaje
     * @param tipo
     * @param titulo
     */
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JButton btnVolver;
    private com.github.lgooddatepicker.components.CalendarPanel calendario;
    private javax.swing.JComboBox<String> comboCantidad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> residuosDisponiblesList;
    private javax.swing.JList<String> residuosSeleccionadosList;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
