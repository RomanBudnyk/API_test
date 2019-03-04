package test_api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static test_api.Endpoints.*;
import static test_api.HelpClass.createJSON;

public class TestAPI {

    @Test(description = "get")
    public void testGet() {
        when().get(BASE_URL + GET_LIST_USERS)
                .then().statusCode(200)
                .and()
                .assertThat()
                .body("total", equalTo(12))
                .body("total_pages", equalTo(4))
                .log().body();
    }

    @Test(description = "post")
    public void testPost() {
        given()
                .contentType(ContentType.URLENC)
                .contentType("application/json")
                .body(createJSON("name", "job", "Jon", "coder"))
                .when()
                .post(BASE_URL + POST_CREATE)
                .then()
                .statusCode(201)
                .assertThat()
                .body("name", equalTo("Jon"))
                .body("job", equalTo("coder"))
                .log().body();
    }

    @Test(description = "put")
    public void testPut() {
        given()
                .contentType(ContentType.URLENC)
                .contentType("application/json")
                .body(createJSON("name", "job", "morpheus", "zion resident"))
                .when()
                .put(BASE_URL + PUT_PATCH_DELETE)
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .log().body();
    }

    @Test(description = "patch")
    public void testPatch() {
        given()
                .contentType(ContentType.URLENC)
                .contentType("application/json")
                .body(createJSON("name", "job", "morpheus1123", "zion resident"))
                .when()
                .patch(BASE_URL + PUT_PATCH_DELETE)
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("morpheus1123"))
                .body("job", equalTo("zion resident"))
                .log().body();
    }

    @Test(description = "delete")
    public void testDelete() {
        given()
                .when()
                .delete(BASE_URL + PUT_PATCH_DELETE)
                .then()
                .statusCode(204)
                .log().body();
    }
}
