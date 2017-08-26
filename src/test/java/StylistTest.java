import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class StylistTest {
  //set up test database
  @Before
  public void setUp(){
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "collins", "collins33");
  }
  //clearing database
  @After
  public void tearDown(){
    try(Connection con=DB.sql2o.open()){
      String clientsql="DELETE FROM clients *;";
      String stylistsql="DELETE FROM stylists *;";
      con.createQuery(clientsql).executeUpdate();
      con.createQuery(stylistsql).executeUpdate();
    }
  }
  //instantiates well
@Test
public void instantiateswell_true(){
        Stylist newStylist=new Stylist("leah");
        assertEquals(true, newStylist instanceof Stylist);
}
//test if it instantiates with property of name
@Test
public void Stylist_instantiatesWithName_string(){
        Stylist newStylist=new Stylist("leah");
        assertEquals("leah",newStylist.getName());
}

//returns an ArrayList of stylists
@Test
public void all_returnsAllInstancesOfStylist_true(){
        Stylist newStylist=new Stylist("leah");
        newStylist.save();
        Stylist secondStylist=new Stylist("anita");
        secondStylist.save();
        assertEquals(true,Stylist.all().get(0).equals(newStylist));
        assertEquals(true,Stylist.all().get(1).equals(secondStylist));
}


//gets the id based on the size of the ArrayList
@Test
public void getId_stylistInstantiateWithAnID_1(){

        Stylist newStylist=new Stylist("leah");
        newStylist.save();
        assertTrue(newStylist.getId()>0);

}
//returns stylist corresponding with the passed id
@Test
public void find_returnsClientWithSameId_secondTask(){
        Stylist newStylist=new Stylist("leah");
        newStylist.save();
        Stylist secondStylist=new Stylist("anita");
        secondStylist.save();
        assertEquals(Stylist.find(secondStylist.getId()),secondStylist);
}

@Test
public void getClients_initiallyReturnsEmptyList_ArrayList(){

  Stylist newStylist=new Stylist("leah");
  assertEquals(0,newStylist.getClients().size());
}


//DATABASE TESTS
//compare if override method works
@Test
public void equals_returnsTrueIfNamesareSame(){
  Stylist newStylist=new Stylist("leah");
  Stylist secondStylist=new Stylist("leah");
  assertTrue(newStylist.equals(secondStylist));
}
//test if it saves into the DATABASE
@Test
public void save_savesIntoDatabase_true(){
  Stylist newStylist=new Stylist("leah");
  newStylist.save();
  assertTrue(Stylist.all().get(0).equals(newStylist));

}
//test if saving into the database assigns it an object a unique id
@Test
public void save_assignsUniqueId(){
  Stylist newStylist=new Stylist("leah");
  newStylist.save();
  Stylist savedStylist=Stylist.all().get(0);
  assertEquals(newStylist.getId(),savedStylist.getId());
}
//retrieve all clients saved in a Stylist

}
