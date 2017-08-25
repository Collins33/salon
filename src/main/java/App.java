import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
public class App {

public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
        //display the homepage
        get("/",(request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    model.put("template","templates/index.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());
        //display the stylist form
        get("/stylist/new",(request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    model.put("template","templates/stylist-form.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());
        //process the stylist form
        post("/stylist",(request,response) ->{
                     Map<String, Object> model = new HashMap<String, Object>();
                     String name =request.queryParams("name");
                     Stylist newStylist=new Stylist(name);
                     model.put("template","templates/awesome.vtl");
                     return new ModelAndView(model,layout);
             },new VelocityTemplateEngine());
        //display list of stylists
        get("/stylist", (request,response)->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    model.put("stylists",Stylist.all());
                    model.put("template","templates/stylists.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());

        //display more info about the stylist
        get("/stylist/:id", (request,response) ->{
                    Map<String, Object> model = new HashMap<String, Object>();
                    Stylist stylist=Stylist.find(Integer.parseInt(request.params(":id")));
                    model.put("stylist",stylist);
                    model.put("template","templates/stylist.vtl");
                    return new ModelAndView(model,layout);
            },new VelocityTemplateEngine());
}
}
