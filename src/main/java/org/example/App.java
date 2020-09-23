package org.example;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.Method;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{

    public static Response getPaymentDetails(){
        HashMap<String, Object> header = new HashMap<>();
        header.put("Authorization", "Basic cnpwX3Rlc3RfTHp6T0RNZW1BY0FVVGI6VFBOM1J1dHJDVTU4b2sybmR6aDZtNTky");
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://api-web.func.razorpay.in/v1/payments/pay_FaR900Ynf4igc2");
        requestSpecification.headers(header);
        Response response = requestSpecification.request().get();
        return response;
    }

    public static void main( String[] args )
    {
        System.out.println(getPaymentDetails().getBody().asString());
    }
}
