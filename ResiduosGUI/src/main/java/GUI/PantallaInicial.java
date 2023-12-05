/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import entitys.ProductorModel;
import entitys.UsuarioModel;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class PantallaInicial extends javax.swing.JFrame {

    /**
     * Creates new form PantallaInicial
     */
    private javax.swing.JLabel label;
    private javax.swing.JButton btnRegistraRes;
    private javax.swing.JButton btnSolicitaTras;
    private javax.swing.JPanel panel;
    private javax.swing.JButton btnVerSolicitudes;
    private javax.swing.JButton btnRegistrarTras;
    UsuarioModel usuario;

   
    public PantallaInicial(UsuarioModel usuario) {
        this.usuario = usuario;
        initComponents();
        panel = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        btnRegistraRes = new javax.swing.JButton();
        btnSolicitaTras = new javax.swing.JButton();
        btnVerSolicitudes = new javax.swing.JButton(); 
        btnRegistrarTras = new javax.swing.JButton();
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);

        if (usuario.getTipo().equalsIgnoreCase("Productor")) {
            label.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Productor.png")));
            panel.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 720, 480));
            btnRegistraRes.setContentAreaFilled(false);
            btnRegistraRes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnRegistraResActionPerformed(evt);
                }
            });
            panel.add(btnRegistraRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 183, 200, 50));
            btnSolicitaTras.setContentAreaFilled(false);
            btnSolicitaTras.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSolicitaTrasActionPerformed(evt);
                }
            });
            panel.add(btnSolicitaTras, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 200, 50));

        } else if (usuario.getTipo().equalsIgnoreCase("administrador")) {
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin.png"))); // NOI18N
            panel.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 720, 480));
            btnVerSolicitudes.setContentAreaFilled(false);
            btnVerSolicitudes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnVerSolicitudesActionPerformed(evt);
                }  
            });
            panel.add(btnVerSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 200, 40));
        } else if (usuario.getTipo().equalsIgnoreCase("transportista")) {
            label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Empresa.png")));
            panel.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 720, 480));
            btnRegistrarTras.setContentAreaFilled(false);
            btnRegistrarTras.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnRegistrarTrasActionPerformed(evt);
                }  
            });
            panel.add(btnRegistrarTras, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 200, 40));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        logOut.setBorder(null);
        logOut.setContentAreaFilled(false);
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(666, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
       
       
       int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cerrar su sesión?", "Log Out", JOptionPane.YES_NO_OPTION);
       
       if(opcion == JOptionPane.YES_OPTION){
       this.dispose();
       new IniciarSesionFrm().setVisible(true);
       }
    }//GEN-LAST:event_logOutActionPerformed
    private void btnRegistraResActionPerformed(java.awt.event.ActionEvent evt) {
        
        new RegistraResiduosFrm(usuario).setVisible(true);
        this.dispose();
    }

    private void btnSolicitaTrasActionPerformed(java.awt.event.ActionEvent evt) {
        new SolicitarTrasladosFrm(usuario).setVisible(true);
        this.dispose();
    }
    
     private void btnVerSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {
         new SolicitudesSinAsignarFrm(usuario).setVisible(true);
         this.dispose();
     }
     
     private void btnRegistrarTrasActionPerformed(java.awt.event.ActionEvent evt) {
         new SolicitudesAsignadasFrm(usuario).setVisible(true);
         this.dispose();
     }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logOut;
    // End of variables declaration//GEN-END:variables
}
