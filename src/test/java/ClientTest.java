/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class ClientTest{
  //test for instance
  @Test
  public void instantiateswell_true(){
    Client newClient=new Client("leah");
    assertEquals(true, newClient instanceof Client);
  }
 //test if it instantiates with property of name
  @Test
  public void Client_instantiatesWithName_string(){
    Client newClient=new Client("leah");
    assertEquals("leah",newClient.getName());
  }
 //get time when client was registered
  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today(){
      Client newClient=new Client("leah");
      assertEquals(LocalDateTime.now().getDayOfWeek(), newClient. isCreatedAt().getDayOfWeek());
  }
}
