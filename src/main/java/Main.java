import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

public class Main {

  public static void main(String[] args) {

    People person1 = new People("Rain Boy", "RB", "123 ABC St", "El Centro", "CA", "95534");
    People person2 = new People("Lonely Raccoon", "LR", "123 Zoo Dr", "Zootopia", "CA", "95536");

    person1.makeDBObject();
    person2.makeDBObject();


    try {
      MongoClient mongoClient = new MongoClient();                      // initialize connection to local DB
      DB database = mongoClient.getDB("MongoDBTest");           // get DB, create new if it doesn't exist
      DBCollection collection = database.getCollection("People"); // get collection in db

      // insert
      collection.insert(person1.getPerson());
      collection.insert(person2.getPerson());

      DBCursor cursor = collection.find(new BasicDBObject("initials", person1.getInitials()));
      System.out.println("Person 1 Name: " + cursor.one().get("name").toString());


      // remove documents
//      collection.remove(new BasicDBObject().append("initials", person1.getInitials()));

      // drop collection
      collection.drop();

      // deletes db
      database.dropDatabase();

      mongoClient.close();

    } catch (UnknownHostException e) {

      e.printStackTrace();

    }
  }

}
