/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author PRIDE ANACONDA
 */
public class ConexionMongoDB {

    public static void main(String[] args) {
        // Establece la información de conexión (host y puerto) y el nombre de la base de datos.
        String host = "localhost"; // Cambia esto al host de tu servidor MongoDB.
        int port = 27017; // Puerto predeterminado de MongoDB.
        String databaseName = "school"; // Cambia esto al nombre de tu base de datos.

      
        String connectionString = "mongodb://localhost:27017"; // Cambia esto si MongoDB se ejecuta en un puerto diferente o en una ubicación diferente.

        // Crea una instancia de MongoClient utilizando la URI de conexión.
        MongoClient mongoClient = MongoClients.create(connectionString);

        // Accede a la base de datos específica.
        MongoDatabase database = mongoClient.getDatabase(databaseName);

        // Accede a una colección dentro de la base de datos.
        MongoCollection<Document> collection = database.getCollection("students");

        // Realiza operaciones en la colección, como insertar, buscar, actualizar, eliminar, etc.
        // Por ejemplo, puedes insertar un documento:
        Document document = new Document("nombre", "Martha").append("edad", 30).append("gender", "F");
        collection.insertOne(document);
    
        // Cierra la conexión cuando hayas terminado.
        mongoClient.close();
    }
}
