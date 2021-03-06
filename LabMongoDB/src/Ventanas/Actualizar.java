package Ventanas;

import java.util.Arrays;
import javax.swing.JFrame;
import labmongodb.ConexionJavaMongo;

public class Actualizar extends javax.swing.JFrame {


    public Actualizar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boton_ActualizarPelicula = new javax.swing.JButton();
        Boton_VolverCrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Info_NombrePeli = new javax.swing.JTextField();
        Info_Categoria = new javax.swing.JTextField();
        Info_Actualizar = new javax.swing.JTextField();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Boton_ActualizarPelicula.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        Boton_ActualizarPelicula.setText("Actualizar Datos");
        Boton_ActualizarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ActualizarPeliculaActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_ActualizarPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 160, 40));

        Boton_VolverCrear.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        Boton_VolverCrear.setText("Volver");
        Boton_VolverCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_VolverCrearActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_VolverCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Digite el nuevo dato a actualizar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 520, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 2, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Seleccione la categoría que desea actualizar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 710, 50));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 2, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Seleccione la película que desea actualizar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 680, 40));

        Info_NombrePeli.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        getContentPane().add(Info_NombrePeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 460, 40));

        Info_Categoria.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        getContentPane().add(Info_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 450, 40));

        Info_Actualizar.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        getContentPane().add(Info_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 450, 40));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenInterfaz.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 921, 749));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_VolverCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_VolverCrearActionPerformed
        JFrame Principal = new Principal();
        Principal.setLocationRelativeTo(Principal);
        Principal.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Boton_VolverCrearActionPerformed

    private void Boton_ActualizarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ActualizarPeliculaActionPerformed
        ConexionJavaMongo peliculaActualizar = new ConexionJavaMongo();
        peliculaActualizar.Actualizar_Pelicula(Info_NombrePeli.getText(), Info_Categoria.getText(), Info_Actualizar.getText());
    }//GEN-LAST:event_Boton_ActualizarPeliculaActionPerformed

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
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actualizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_ActualizarPelicula;
    private javax.swing.JButton Boton_VolverCrear;
    private javax.swing.JTextField Info_Actualizar;
    private javax.swing.JTextField Info_Categoria;
    private javax.swing.JTextField Info_NombrePeli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    // End of variables declaration//GEN-END:variables
}
