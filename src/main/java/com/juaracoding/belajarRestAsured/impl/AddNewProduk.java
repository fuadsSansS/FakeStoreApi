package com.juaracoding.belajarRestAsured.impl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 30/08/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 30/08/2024 17:26
@Last Modified 30/08/2024 17:26
Version 1.0
*/
public class AddNewProduk {

    private static JSONObject req = new JSONObject();
    private String user = System.getProperty("user.dir");
    private String path = user + "\\src\\main\\resources\\img\\selectorhub.png";
    private static int statusCode;
    private static int id;


    @Given("Saya Mendapatkan Base Url")
    public void saya_mendapatkan_base_url() {
        RestAssured.baseURI="https://fakestoreapi.com/";
    }
    @And("Saya Mengirim Data Produk")
    public void saya_mengirim_data_produk() {
        String title = "apa aja";
        double price = 15000;
        String description = "lorem ipsum";
        String category = "bebas";

        req.put("title", title);
        req.put("price", price);
        req.put("description",description);
        req.put("image","https://i.pravatar.cc");
        req.put("category", category);

        RequestSpecification httpRequest = given().
                header("Content-Type", "application/json").
                header("accept", "*/*").
                body(req.toJSONString());
        Response response = httpRequest.request(Method.POST, "products");
        JsonPath js = response.jsonPath();
        id = js.getInt("id");
        statusCode = response.getStatusCode();
        String strTitle = js.getString("title");
        double strPrice = js.getDouble("price");
        String strDescrip = js.getString("description");
        String strCategory = js.getString("category");
        //System.out.println(strTitle + " " + strPrice + " " + strDescrip + " " + strCategory );
        boolean valid = strTitle.equalsIgnoreCase(title)&&strCategory.equalsIgnoreCase(category);
        Assert.assertTrue(valid);
        Assert.assertEquals(statusCode, 200);

    }
    @Then("Validasi Data Yang Di Tambahkan")
    public void validasi_data_yang_di_tambahkan() {
        RequestSpecification httpRequest = given().
                header("Content-Type", "application/json").
                header("accept", "*/*");
        Response response = httpRequest.request(Method.GET, "products/" + id);
        JsonPath js = response.jsonPath();
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200);
    }


}





