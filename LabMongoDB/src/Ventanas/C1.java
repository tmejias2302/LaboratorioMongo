package Ventanas;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import org.bson.Document;

public class C1 extends javax.swing.JFrame {

    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase database = mongoClient.getDatabase("Setimo_Arte");

    MongoCollection<Document> coleccionPelicula = database.getCollection("Pelicula");


    public C1() {
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

        Boton_BuscarPelicula = new javax.swing.JButton();
        Boton_VolverCrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Info_NombrePeli = new javax.swing.JTextField();
        Valores = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Boton_BuscarPelicula.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        Boton_BuscarPelicula.setText("Buscar");
        Boton_BuscarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_BuscarPeliculaActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_BuscarPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 100, 40));

        Boton_VolverCrear.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        Boton_VolverCrear.setText("Volver");
        Boton_VolverCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_VolverCrearActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_VolverCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 2, 36)); // NOI18N
        jLabel1.setText("Nombre Película");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 270, 40));

        Info_NombrePeli.setFont(new java.awt.Font("Yu Gothic UI", 2, 18)); // NOI18N
        getContentPane().add(Info_NombrePeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 330, -1));

        jList1.setFont(new java.awt.Font("Yu Gothic", 2, 18)); // NOI18N
        Valores.setViewportView(jList1);

        getContentPane().add(Valores, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 440, 250));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ImagenInterfaz.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 921, 749));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_VolverCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_VolverCrearActionPerformed
        JFrame Consultas = new Consultas();
        Consultas.setLocationRelativeTo(Consultas);
        Consultas.setVisible(true);
        this.hide();
    }//GEN-LAST:event_Boton_VolverCrearActionPerformed

    private void Boton_BuscarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BuscarPeliculaActionPerformed
        BasicDBObject Query = new BasicDBObject("Nombre_Pelicula", Info_NombrePeli.getText());
        coleccionPelicula.find(Query).forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                DefaultListModel Elemento = new DefaultListModel();
                for (int i = 1; i < 10; i++) {
                    Elemento.addElement(document.get("Nombre_Pelicula"));
                    Elemento.addElement(document.get("Genero"));
                    Elemento.addElement(document.get("Nombre_Director"));
                    Elemento.addElement(document.get("Franquicia"));
                    Elemento.addElement(document.get("Pais_Produccion"));
                    Elemento.addElement(document.get("Año_Estreno"));
                    Elemento.addElement(document.get("Duracion_Minutos"));
                    Elemento.addElement(document.get("Compañia_Productora"));
                    Elemento.addElement(document.get("Actores"));
                    break;
                }
                jList1.setModel(Elemento);
            }
        });

        //mongoClient.close();

    }//GEN-LAST:event_Boton_BuscarPeliculaActionPerformed

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
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_BuscarPelicula;
    private javax.swing.JButton Boton_VolverCrear;
    private javax.swing.JTextField Info_NombrePeli;
    private javax.swing.JScrollPane Valores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JList<String> jList1;
    // End of variables declaration//GEN-END:variables
}
