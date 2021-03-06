package labmongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.bson.Document;

public class ConexionJavaMongo {
    //Conectando con el servidor
    MongoClient mongoClient = new MongoClient("localhost", 27017);

    //Creando la base de datos
    MongoDatabase BD = mongoClient.getDatabase("Setimo_Arte");

    // Retrieving a collection
    MongoCollection<Document> Coleccion_Pelicula = BD.getCollection("Pelicula");
    
    MongoCursor < Document > cursor = Coleccion_Pelicula.find().iterator();
    
    MongoCollection<Document> Coleccion_Compañia = BD.getCollection("Compañia_Productora");
    
    MongoCursor < Document > cursor2 = Coleccion_Compañia.find().iterator();

    //Agregar informacion al documentoPelicula
    public void Agregar_Pelicula(String Nombre_Pelicula,String Genero,String Nombre_Director,
            String Franquicia,String Pais,int año,int minutos,String Compañia,List<String> actores) {
        
        //Agregar informacion al documentoPelicula
        Document documentoPelicula = new Document("Nombre_Pelicula", Nombre_Pelicula)
                .append("Genero", Genero).append("Nombre_Director", Nombre_Director)
                .append("Franquicia", Franquicia).append("Pais_Produccion", Pais)
                .append("Año_Estreno", año).append("Duracion_Minutos", minutos)
                .append("Compañia_Productora", Compañia)
                .append("Actores", actores);
        Coleccion_Pelicula.insertOne(documentoPelicula);
        JOptionPane.showMessageDialog(null, "PELÍCULA REGISTRADA", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        mongoClient.close();
    }
    
    //Agregar informacion al documentoCompañia
    public void Agregar_Compañia(String Nombre_Compañia,int año,String Web) {
        
        Document documentoCompañia = new Document("Nombre_Compañia", Nombre_Compañia)
                .append("Año", año).append("Pagina_Web", Web);
        Coleccion_Compañia.insertOne(documentoCompañia);
        JOptionPane.showMessageDialog(null, "COMPAÑIA PRODUCTORA REGISTRADA", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        mongoClient.close();
    }
    
    /*Document doc = Coleccion_Pelicula.find(Filters.or(Filters.eq("Nombre_Pelicula", "Chijiro"))).first();
    if (doc != null) {
            System.out.println(doc.getString("Franquicia"));
        System.out.println(doc.getString("Genero"));
    }*/
    
    //Borrar valores especificos de un documento
    public void Borrar_Pelicula(String Nombre_Pelicula){
        Coleccion_Pelicula.deleteOne(eq("Nombre_Pelicula", Nombre_Pelicula));
        JOptionPane.showMessageDialog(null, "PELÍCULA ELIMINADA", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        mongoClient.close();
    }
    
    //Borrar valores especificos de un documento
    public void Borrar_Compañia(String Nombre_Compañia) {
        Coleccion_Compañia.deleteOne(eq("Nombre_Compañia", Nombre_Compañia));
        JOptionPane.showMessageDialog(null, "COMPAÑIA PRODUCTORA ELIMINADA", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        mongoClient.close();
    }

    //Actualizacion de valores de una coleccion
    public void Actualizar_Pelicula(String Nombre_Pelicula,String Categoria,String DatoActualizar){   
        Coleccion_Pelicula.updateOne(new BasicDBObject("Nombre_Pelicula", Nombre_Pelicula), new BasicDBObject("$set", new BasicDBObject(Categoria, DatoActualizar)));
        mongoClient.close();
    }       
    
    //Lee todos los valores que se encuentran en la coleccion Pelicula
    public void Leer_Pelicula(String Nombre_Pelicula) {
        FindIterable<Document> findIterable = Coleccion_Pelicula.find(eq("Nombre_Pelicula", Nombre_Pelicula));
 
        Document doc = findIterable.iterator().next();

        List list = new ArrayList(doc.values());
        System.out.print(list.get(1) + "\n");
        System.out.print(list.get(2) + "\n");
        System.out.print(list.get(3) + "\n");
        System.out.print(list.get(4) + "\n");
        System.out.print(list.get(5) + "\n");
        System.out.print(list.get(6) + "\n");
        System.out.print(list.get(7) + "\n");
        System.out.print(list.get(8) + "\n");
        System.out.print(list.get(9) + "\n");

        mongoClient.close();
    }
    public static void main(String[] args) {
        ConexionJavaMongo Pelicula = new ConexionJavaMongo();
        //Pelicula.Borrar_Pelicula("Chijiro");
        //Pelicula.Borrar_Pelicula("Rango");
        Pelicula.Leer_Pelicula("Scary Movie"); 
    }
        
}
