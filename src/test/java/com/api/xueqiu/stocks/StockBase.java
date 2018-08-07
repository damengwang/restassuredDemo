package com.api.xueqiu.stocks;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class StockBase {
    public  static RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    public  static RequestSpecification requestSpecification;
    @BeforeClass
    public  static  void beforeClass(){
        //复用
        requestSpecBuilder.addHeader("Host","api.xueqiu.com");
        requestSpecBuilder.addHeader("User-agent","Xueqiu iPhone 11.3");
        requestSpecBuilder.addQueryParam("x","0.67");
        requestSpecification=requestSpecBuilder.build();

    }
}
