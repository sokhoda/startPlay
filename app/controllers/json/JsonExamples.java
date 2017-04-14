package controllers.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

public class JsonExamples extends Controller{

    private final static String SHORT_STUDENT_INFO = "SHORT STUDENT INFO:";

    @BodyParser.Of(BodyParser.Json.class)
    public Result showStudentInfo(){
        JsonNode json = request().body().asJson();
        String name, surname;
        if ((name = json.findPath("name").textValue()) == null ||
            (surname = json.findPath("surname").textValue()) == null){
            return badRequest("Some fields are set to null");
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(SHORT_STUDENT_INFO + "\n")
            .append("Name: ").append(name).append("\n")
            .append("Surname: ").append(surname);

            return ok(sb.toString());
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result showStudentInfoReplyWithJSon(){
        JsonNode json = request().body().asJson();
        String name, surname;
        if ((name = json.findPath("name").textValue()) == null ||
                (surname = json.findPath("surname").textValue()) == null){
            return badRequest("Some fields are set to null");
        }
        else {
            ObjectNode resultJson = Json.newObject();
            resultJson.put("name", reverse(name));
            resultJson.put("surname", reverse(surname));
            return ok(resultJson);
        }
    }

    private static String reverse (String str){
        return  (str != null) ? new StringBuilder().append(str).reverse().toString(): null;
    }


}
