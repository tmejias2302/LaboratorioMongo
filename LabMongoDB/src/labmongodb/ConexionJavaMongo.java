package labmongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;


public class ConexionJavaMongo {
    public static void main(String args []){
        //Conectando con el servidor
        MongoClient mongoClient = new MongoClient("localhost" , 27017);
        System.out.println("Server Conectado Correctamente");
        
        //Conectar con la base de datos de Mongo
        //MongoDatabase DBS = mongoClient.getDatabase("")
        MongoDatabase dbs = mongoClient.getDatabase("test");
	System.out.println("Connect to database successfully");
	System.out.println("Database Name"+dbs.getName());
        
        /*List<String> bdNombres = mongoClient.getDatabaseNames();
        System.out.println(bdNombres);*/
        
    }
    
}
