package Base;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

public class MongoDemoTest {


    @Test
    public void connect() {

        MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
        MongoDatabase mongoDb = mongoClient.getDatabase("lxl");
        MongoCollection<Document> colList = mongoDb.getCollection("lxl");
        FindIterable<Document> list = colList.find();
        for (Document doc :
                list) {
            System.out.println("name:"+ doc.getString("name") );
        }
    }

    @Test
    public void connect1() {

        MongoClient mongoClient = new MongoClient("192.168.80.129:27017");
        MongoDatabase mongoDb = mongoClient.getDatabase("local");
        MongoCollection<Document> colList = mongoDb.getCollection("startup_log");
        FindIterable<Document> list = colList.find();
        for (Document doc :
                list) {
            System.out.println("value:"+ doc.getDate("startTime") );
        }
    }
}