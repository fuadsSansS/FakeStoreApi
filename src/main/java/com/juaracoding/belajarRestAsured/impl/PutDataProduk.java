package com.juaracoding.belajarRestAsured.impl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;


import static io.restassured.RestAssured.given;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 31/08/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 31/08/2024 15:09
@Last Modified 31/08/2024 15:09
Version 1.0
*/
public class PutDataProduk {

    private static Response response;
    private JSONObject req = new JSONObject();
    private static String title = "";
    private static String category = "";

    @Given("Mendapatkan Base Url Put")
    public void mendapatkan_base_url_put() {
        RestAssured.baseURI="https://fakestoreapi.com/";
    }

    @And("Mengirim Permintaan Put Ke Id")
    public void mengirim_permintaan_put_ke_id() {
        title = "Sepatu Cepet madun";
        category = "Alat Olahraga";
        req.put("title", title);
        req.put("category", category);
        RequestSpecification httpRequest = given().
                header("Content-Type", "application/json").
                header("accept", "*/*").
                body(req.toJSONString());
        response = httpRequest.request(Method.PUT, "products/" + 9);
        JsonPath js = response.jsonPath();
        String namaTit = js.getString("title");
        String namaCat = js.getString("category");
        boolean valid = namaTit.equalsIgnoreCase(title)&&namaCat.equalsIgnoreCase(category);
        Assert.assertTrue(valid);

    }
    @And("Validasi Kode Respon")
    public void validasi_kode_respon() {
        JsonPath jpath = response.jsonPath();
        int statusCode2 = response.statusCode();
        Assert.assertEquals(statusCode2, 200);

    }

}





