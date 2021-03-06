package Ventanas;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import org.bson.Document;

public class C5 extends javax.swing.JFrame {


    public C5() {
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
        jLabel1.setText("Nombre Compañía Productora");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 500, 40));

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
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase BD = mongoClient.getDatabase("Setimo_Arte");
        MongoCollection<Document> Coleccion_Pelicula = BD.getCollection("Pelicula");
        MongoCollection<Document> Coleccion_Minutos = BD.getCollection("Grupo_Duracion");
        BasicDBObject Query = new BasicDBObject("Compañia_Productora", Info_NombrePeli.getText());
        int contador = 0;

        DefaultListModel Elemento = new DefaultListModel();

        try (MongoCursor<Document> cur = Coleccion_Pelicula.find(Query).iterator()) {
            while (cur.hasNext()) {
                Document doc = cur.next();
                List list = new ArrayList(doc.values());
                Document documentoMinutos = new Document("Nombre_Pelicula", list.get(1)).append("Duracion_Minutos", list.get(7));
                Coleccion_Minutos.insertOne(documentoMinutos);
                contador++;

            }
            Document DuraMax = Coleccion_Minutos.aggregate(Arrays.asList(Aggregates.group(null, Accumulators.max("maxx", "$Duracion_Minutos")))).first();

            Document DuraMin = Coleccion_Minutos.aggregate(Arrays.asList(Aggregates.group(null, Accumulators.min("min", "$Duracion_Minutos")))).first();

            Document Avg = Coleccion_Minutos.aggregate(Arrays.asList(Aggregates.group(null, Accumulators.avg("avg", "$Duracion_Minutos")))).first();

            Elemento.addElement("Cantidad de peliculas" + " " + contador);
            BasicDBObject Query2 = new BasicDBObject("Duracion_Minutos", DuraMax.get("maxx"));
            MongoCursor<Document> cur2 = Coleccion_Minutos.find(Query2).iterator();
            while (cur2.hasNext()) {
                Document doc2 = cur2.next();
                List list2 = new ArrayList(doc2.values());
                Elemento.addElement("Pelicula con más minutos:" + " " + list2.get(1));
            }
            
            BasicDBObject Query3 = new BasicDBObject("Duracion_Minutos", DuraMin.get("min"));
            MongoCursor<Document> cur3 = Coleccion_Minutos.find(Query3).iterator();
            while (cur3.hasNext()) {
                Document doc3 = cur3.next();
                List list3 = new ArrayList(doc3.values());
                Elemento.addElement("Pelicula con menos minutos:" + " " + list3.get(1));
            }
            Elemento.addElement("Promedio de duracion de peliculas es de" + " " + Avg.get("avg"));
            
            jList1.setModel(Elemento);

            BD.getCollection("Grupo_Duracion").drop();

        }
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
            java.util.logging.Logger.getLogger(C5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C5().setVisible(true);
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
