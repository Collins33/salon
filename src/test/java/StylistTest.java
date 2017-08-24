import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
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
        Stylist secondStylist=new Stylist("anita");
        assertEquals(true,Stylist.all().contains(newStylist));
        assertEquals(true,Stylist.all().contains(secondStylist));
}
//clears the ArrayList
@Test
public void clear_emptiesAllStylistFromArrayList_0(){
        Stylist newStylist=new Stylist("leah");
        Stylist.clear();
        assertEquals(0,Stylist.all().size());
}
//gets the id based on the size of the ArrayList
@Test
public void getId_stylistInstantiateWithAnID_1(){
        Stylist.clear();
        Stylist newStylist=new Stylist("leah");
        assertEquals(1,newStylist.getId());

}
//returns stylist corresponding with the passed id
@Test
public void find_returnsClientWithSameId_secondTask(){
        Stylist newStylist=new Stylist("leah");
        Stylist secondStylist=new Stylist("anita");
        assertEquals(Stylist.find(secondStylist.getId()),secondStylist);
}
}
