/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import code.Usuario;
//import com.validaciones.UsuarioNegocio;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class IniciarSesionFrm extends javax.swing.JFrame {
    //UsuarioNegocio usuarioNeg = new UsuarioNegocio();
    
    /**
     * Creates new form IniciarSesionFrm
     */
    public IniciarSesionFrm() {
        initComponents();
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
        txtContrasena = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 180, -1));

        btnIniciarSesion.setContentAreaFilled(false);
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 180, 40));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 180, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantalla Iniciar Sesion - Residuos Tóxicos.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 720, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        // TODO add your handling code here:
          
//            if(usuarioNeg.confirmaCredenciales(this.txtUsuario.getText(), this.txtContrasena.getText())!=null){
//                JOptionPane.showMessageDialog(null, "Validacion correcta");
//                 Usuario usuario = usuarioNeg.confirmaCredenciales(this.txtUsuario.getText(), this.txtContrasena.getText()); 
//                 if(usuario.getTipo().equalsIgnoreCase("Productor")){
//                          this.dispose();
//                     new PantallaInicial(usuario).setVisible(true);
//                 }else if(usuario.getTipo().equalsIgnoreCase("Administrador")){
//                        this.dispose();
//                     new PantallaInicial(usuario).setVisible(true);
//                 }else if (usuario.getTipo().equalsIgnoreCase("Transportista")){
//                     this.dispose();
//                     new PantallaInicial(usuario).setVisible(true);
//                 }
//            }else{
//                JOptionPane.showMessageDialog(null, "Error en validación");
//            }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
