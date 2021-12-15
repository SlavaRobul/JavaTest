package com.geekbrains.backend.test.imgur;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImgurApiFunctionalTest extends ImgurApiAbstractTest {

    private static String CURRENT_IMAGE_ID;

    @Test
    void getAccountBase() {
        String userName = "mixanik97";
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("data.id", is(157949261))
                .log()
                .all()
                .when()
                .get("account/" + userName);
    }

    @Test
    void getImage() {
        String imageHash = "eTKzRhf";
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("data.id", is(imageHash))
                .body("success", is(true))
                .body("status", is(200))
                .log()
                .all()
                .when()
                .get("image/" + imageHash);
    }

    @Test
    void postImageTest() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("img.jpg"))
                .formParam("name", "Test picture")
                .formParam("title", "Test title")
                .log()
                .all()
                .expect()
                .body("data.size", is(46314))
                .body("data.type", is("image/jpeg"))
                .body("data.name", is("Test picture"))
                .body("data.title", is("Test title"))
                .body("success", is(true))
                .body("status", is(200))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    void updateImageInformation() {
        given()
                .spec(requestSpecification)
                .formParam("title", "My title")
                .formParam("description", "My description")
                .log()
                .all()
                .expect()
                .body("data", is(true))
                .body("success", is(true))
                .body("status", is(200))
                .log()
                .all()
                .when()
                .post("image/" + "1WtT59G1zbGUFrm");
    }

    @Test
    void favouriteAnImage() {
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("data", is("favorited"))
                .body("success", is(true))
                .body("status", is(200))
                .log()
                .all()
                .when()
                .post("image/" + "eTKzRhf" + "/favorite");
    }

    @Test
    void deleteImageById() {
        given()
                .spec(requestSpecification)
                .log()
                .all()
                .expect()
                .body("status", is(200))
                .log()
                .all()
                .when()
                .delete("image/" + CURRENT_IMAGE_ID);
    }

}
