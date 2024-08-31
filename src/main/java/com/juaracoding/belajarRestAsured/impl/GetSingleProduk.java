package com.juaracoding.belajarRestAsured.impl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 30/08/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 30/08/2024 1:09
@Last Modified 30/08/2024 1:09
Version 1.0
*/
public class GetSingleProduk {

    private Response response;

    @Given("Saya memiliki base URL")
    public void saya_memiliki_base_url(){
        //akses url api fakestoreapi.com
        RestAssured.baseURI ="https://fakestoreapi.com/";
    }
    @When("Saya mengirim permintaan GET ke {string}")
    public void saya_mengirim_permintaan_get_ke_(String endpotin){
        //mendapatkan endpoint dari api
        response = RestAssured.given().when().get(endpotin);

    }
    @Then("Kode status respons harus {int}")
    public void kode_status_respons_harus(int expectedCode){
        //mendapatkan respon code dari endpoint
        int endPointCode = response.getStatusCode();

        Assert.assertEquals(expectedCode,endPointCode);
    }
    @And("Respons harus berisi data pengguna dengan ID {int}")
    public void respons_harus_berisi_data_pengguna_dengan_id_(int expectedId){
        //menyimpan id kedalam actualId
        int actualId = response.jsonPath().getInt("id");
        //validasi apakah id sesuai dengan
        Assert.assertEquals(expectedId, actualId);
    }
    @And("Respons harus memiliki tipe konten {string}")
    public void respons_harus_memiliki_tipe_konten_(String expectedContainType){
        //mengambil dan menyimpan contenya ke dalam headerContainType
        String headerContainType = response.getHeader("Content-Type");
        //System.out.println(headerContainType);
        Assert.assertEquals(expectedContainType, headerContainType);
    }

    @And("Validasi Nama Title {string}")
    public void validasi_nama_title_(String expectedTitle){
        String title = response.jsonPath().getString("title");
        //System.out.println(title);
        Assert.assertEquals(expectedTitle, title);

    }

    @And("Validasi Rating Rate {double}")
    public void validasi_rating_rate(double expectedRate){
        double rate = response.jsonPath().getDouble("rating.rate");
        //System.out.println(rate);
        Assert.assertEquals(expectedRate, rate);

    }



}





