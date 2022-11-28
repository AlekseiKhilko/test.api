package org.example;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Api {

    final String URL_DOREGISTER = "http://users.bugred.ru/tasks/rest/doregister";
    final String URL_GETUSER = "http://users.bugred.ru/tasks/rest/getuser";
    final String URL_FULLUPDATEUSER = "http://users.bugred.ru/tasks/rest/fullupdateuser";
    final String URL_DELETEUSER = "http://users.bugred.ru/tasks/rest/deleteuser";

    @Test
    public void testDoRegister(){

        String jsonBody = "{\n" +
                "\"name\": \"TestName\",\n" +
                "\"email\": \"test@test.me\",\n" +
                "\"password\": \"MyPass123\"\n" +
                "}";

        String jsonResult = given().contentType("application/json")
                .body(jsonBody)
                .when()
                .post(URL_DOREGISTER)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().asString();

        System.out.println(jsonResult);
    }

    @Test
    public void testGetUser(){

        String jsonBody = "{\n" +
                "\"email\": \"test@test.me\"\n" +
                "}";

        String jsonResult = given().contentType("application/json")
                .body(jsonBody)
                .when()
                .get(URL_GETUSER)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().asString();

        System.out.println(jsonResult);
    }

    @Test
    public void testFullUpdateUser(){

        String jsonBody = "{\n" +
                "\"email\": \"test@test.me\",\n" +
                "\"hobby\": \"User’s Hobby\",\n" +
                "\"name\": \"myName\",\n" +
                "\"name1\": \"User’s Name\",\n" +
                "\"surname1\": \"User’s Surname\",\n" +
                "\"fathername1\": \"User’s Father name\",\n" +
                "\"cat\": \"User’s Cat\",\n" +
                "\"dog\": \"User’s Dog\",\n" +
                "\"parrot\": \"User’s Parrot\",\n" +
                "\"cavy\": \"User’s Cavy\",\n" +
                "\"hamster\": \"User’s Hamster\",\n" +
                "\"squirrel\": \"User’s Squirrel\",\n" +
                "\"phone\": \"User’s Phone\",\n" +
                "\"inn\": \"012345678901\",\n" +
                "\"adres\": \"User’s Addredd\",\n" +
                "\"gender\": \"m\",\n" +
                "\"birthday\": \"11.11.1980\",\n" +
                "\"date_start\": \" 11.11.1980\"\n" +
                "}";

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri(URL_FULLUPDATEUSER);
        request.body(jsonBody);

        Response response = request.patch();
        System.out.println(response.asString());

        ValidatableResponse validatableResponse = response.then();
        //System.out.println(jsonResult);
    }

    @Test
    public void testDeleteUser(){

        String jsonBody = "{\n" +
                "\"email\": \"test@test.me\"\n" +
                "}";

        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.baseUri(URL_DELETEUSER);
        request.body(jsonBody);

        Response response = request.delete();
        System.out.println(response.asString());

        ValidatableResponse validatableResponse = response.then();
        //System.out.println(jsonResult);
    }
}