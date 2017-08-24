import java.time.LocalDateTime;


public class Client {
private String mName;
private LocalDateTime mCreatedAt;
public Client(String name){
        mName=name;
        mCreatedAt=LocalDateTime.now();
}
public String getName(){
        return mName;
}
public LocalDateTime isCreatedAt(){
        return mCreatedAt;
}
}
