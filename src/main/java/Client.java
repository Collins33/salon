import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Client {
private String mName;
private LocalDateTime mCreatedAt;
private static List<Client> instances=new ArrayList<Client>();
public Client(String name){
        mName=name;
        mCreatedAt=LocalDateTime.now();
        instances.add(this);
}
public String getName(){
        return mName;
}
public LocalDateTime isCreatedAt(){
        return mCreatedAt;
}
public static List<Client> all(){
        return instances;
}
public static void clear(){
        instances.clear();
}
}
