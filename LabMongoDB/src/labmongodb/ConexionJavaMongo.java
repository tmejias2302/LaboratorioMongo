package labmongodb;

import com.mongodb.BasicDBObject;
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
import org.bson.Document;

public class ConexionJavaMongo {

    public static void main(String args[]) {
        //Conectando con el servidor
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        //Creando la base de datos
        MongoDatabase BD = mongoClient.getDatabase("Setimo_Arte");

        // Retrieving a collection
        MongoCollection<Document> Coleccion_Pelicula = BD.getCollection("Pelicula");

        //Creando la coleccion para la base de datos
        //DBCollection Coleccion_Productora = (DBCollection) BD.getCollection("Compañia_Productora");
        
        //Agregar informacion a al documentoPelicula
        List<String> actores = Arrays.asList("Thomas", "Luis");
        Document documentoPelicula = new Document("Nombre_Pelicula", "Rango")
                .append("Genero", "Comedia").append("Nombre_Director", "Jaime")
                .append("Franquicia", "Faketon").append("Pais_Produccion", "USA")
                .append("Año_Estreno", 2011).append("Duracion_Minutos", 165)
                .append("Compañia_Productora", "Los pollos hermanos")
                .append("Actores", actores);
        Coleccion_Pelicula.insertOne(documentoPelicula);
        
        //Borrar valores especificos de un documento
        Coleccion_Pelicula.deleteOne(eq("Nombre_Pelicula", "Rango"));
        Coleccion_Pelicula.deleteOne(eq("Nombre_Pelicula", "Rango"));
        Coleccion_Pelicula.deleteOne(eq("Nombre_Pelicula", "Rango"));
        
        //Actualizacion de valores de una coleccion
        Coleccion_Pelicula.updateOne(new BasicDBObject("Nombre_Pelicula", "Rango"), new BasicDBObject("$set", new BasicDBObject("Genero", "Terror")));
        
            //Lee todos los valores que se encuentran en la coleccion Pelicula
        try (MongoCursor<Document> cur = Coleccion_Pelicula.find().iterator()) {
            while (cur.hasNext()) {

                Document doc = cur.next();

                List list = new ArrayList(doc.values());
                System.out.print(list.get(1)+ "\n");
                System.out.print(list.get(2)+ "\n");
                System.out.print(list.get(3)+ "\n");
                System.out.print(list.get(4)+ "\n");
                System.out.print(list.get(5)+ "\n");
                System.out.print(list.get(6)+ "\n");
                System.out.print(list.get(7)+ "\n");
                System.out.print(list.get(8)+ "\n");
                System.out.print(list.get(9)+ "\n");
            }
        }

        mongoClient.close();

    }

}
