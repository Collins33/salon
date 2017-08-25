import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Client {
private String name;
private LocalDateTime createdAt;

private int id;


//constructor
public Client(String name){
        this.name=name;
        createdAt=LocalDateTime.now();
}


//getter methods
public String getName(){
        return name;
}
public LocalDateTime isCreatedAt(){
        return createdAt;
}
public int getId(){
  return id;
}
public static Client find(int id) {
  try(Connection con=DB.sql2o.open()){
    String sql="SELECT * FROM clients where id=:id";
    Client client=con.createQuery(sql)
    .addParameter("id",id)
    .executeAndFetchFirst(Client.class);
    return client;
  }

}


//retrieves from the database under clients table
//retrieves into ArrayList
//all() returns the ArrayList created containing the name and id
public static List<Client> all(){
String sql="SELECT id,name FROM clients";
try(Connection con=DB.sql2o.open()){
 return con.createQuery(sql).executeAndFetch(Client.class);

}
}
//override the equals()
@Override
public boolean equals(Object myClient){
  if(!(myClient instanceof Client)){
    return false;
  }
  else{
    Client firstClient=(Client) myClient;
    return this.getName().equals(firstClient.getName())&&
    this.getId() == firstClient.getId();

  }
}
//saves into the database
public void save(){
  try(Connection con=DB.sql2o.open()){
    String sql="INSERT INTO clients (name) VALUES (:name)";
    this.id=(int)con.createQuery(sql,true)
    .addParameter("name",this.name)
    .executeUpdate()
    .getKey();
  }
}



}
