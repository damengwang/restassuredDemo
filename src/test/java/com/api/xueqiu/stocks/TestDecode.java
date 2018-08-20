package com.api.xueqiu.stocks;

import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.Base64;
import  static  io.restassured.RestAssured.*;
import  static  org.hamcrest.Matchers.*;

public class TestDecode {
    @Test
    public void testJsonInBase64(){
        given().filter( (req, res, ctx)->{
            Response resOrigin=ctx.next(req,res);
            ResponseBuilder responseBuilder=new ResponseBuilder().clone(resOrigin);
            //responseBuilder.setBody("{ \"SOGO\": { \"name\" : \"搜狗\"} }");
            String decodedContent=new String(
                    Base64.getDecoder().decode(
                            resOrigin.body().asString().trim()
                    )
            );
            responseBuilder.setBody(decodedContent);
            Response resNew=responseBuilder.build();

            return resNew;
        })
                //.get("https://xueqiu.com/v4/stock/quote.json?code=SOGO")
                .get("http://127.0.0.1:8000/base64.json").prettyPeek()
                .then()
                .statusCode(200)
                .body("SOGO.name", equalTo("搜狗"));
    }
}
