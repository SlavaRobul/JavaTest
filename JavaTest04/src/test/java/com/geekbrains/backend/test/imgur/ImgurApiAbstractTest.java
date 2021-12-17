package com.geekbrains.backend.test.imgur;

import java.util.Properties;

import com.geekbrains.backend.test.FunctionalTest;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.internal.AuthenticationSpecificationImpl;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;

public class ImgurApiAbstractTest extends FunctionalTest {

    protected static RequestSpecification requestSpecification;
    protected static String userName;
    protected static int dataId;
    protected static String imageHash;

    static {
        try {
            Properties properties = readProperties();
            RestAssured.baseURI = properties.getProperty("imgur-api-url");
            String TOKEN = properties.getProperty("imgur-api-token");
            requestSpecification = new RequestSpecBuilder()
                    .setAuth(new OAuth2Scheme())
                    .build();
            AuthenticationSpecification auth = new AuthenticationSpecificationImpl(requestSpecification);
            requestSpecification = auth.oauth2(TOKEN);
            userName = properties.getProperty("imgur-api-username");
            dataId = Integer.parseInt(properties.getProperty("imgur-api-dataid"));
            imageHash = properties.getProperty("imgur-api-imagehash");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
