package com.juaracoding.belajarRestAsured.impl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 31/08/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 31/08/2024 14:41
@Last Modified 31/08/2024 14:41
Version 1.0
*/
public class DeleteDataProduk {

    private Response response;

    @Given("Mendapatkan Base Url")
    public void mendapatkan_base_url() {
        RestAssured.baseURI="https://fakestoreapi.com/";
    }
    @And("Mengirim Request Hapus")
    public void mengirim_request_hapus() {
        RequestSpecification httpRequest = given().
                header("Content-Type", "application/json").
                header("accept", "*/*");
        response =httpRequest.request(Method.DELETE, "products/" + 6);

    }
    @Then("Validasi Code Respon")
    public void validasi_code_respon() {
        JsonPath jpath = response.jsonPath();
        int statusCode2 = response.statusCode();
        System.out.println(statusCode2);
        Assert.assertEquals(statusCode2,200);
    }

}





