import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class People {
  private DBObject person;
  private String name, initials, street, city, state, zip;

  public People(String name, String initials, String street, String city, String state, String zip) {

    this.name = name;
    this.initials = initials;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;

  }

  public void makeDBObject() {
    person = new BasicDBObject("initials", initials)
              .append("name", name)
              .append("address", new BasicDBObject("street", street)
                                        .append("city", city).append("state", state).append("zip", zip)
              );

  }

  // setters
  public void setName(String name)          {this.name = name;}
  public void setInitials(String initials)  {this.initials = initials;}
  public void setStreet(String street)      {this.street = street;}
  public void setCity(String city)          {this.city = city;}
  public void setState(String state)        {this.state = state;}
  public void setZip(String zip)            {this.zip = zip;}

  // getters
  public DBObject getPerson() {return this.person;}
  public String getName()     {return this.name;}
  public String getInitials() {return this.initials;}
  public String getStreet()   {return this.street;}
  public String getCity()     {return this.city;}
  public String getState()    {return this.state;}
  public String getZip()      {return this.zip;}

}
