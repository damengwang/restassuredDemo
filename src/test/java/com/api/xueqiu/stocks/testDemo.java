import org.junit.Test;
import  static  io.restassured.RestAssured.*;
import  static  io.restassured.matcher.RestAssuredMatchers.*;
import  static  org.hamcrest.Matcher.*;



public class testDemo {
    @Test
    public void  Baidu() {
        given().log().all().get("http://www.baidu.com").then().log().all().statusCode(200);
    }




}
