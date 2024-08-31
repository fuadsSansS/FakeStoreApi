package com.juaracoding.belajarRestAsured.impl;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 30/08/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 30/08/2024 1:55
@Last Modified 30/08/2024 1:55
Version 1.0
*/
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = {
                "src/main/resources/feature/TestGetData.feature",
                "src/main/resources/feature/TestDeleteData.feature",
                "src/main/resources/feature/TestAddData.feature",
                "src/main/resources/feature/TestPutData.feature",
        },
        glue = "com.juaracoding.belajarRestAsured.impl",
        monochrome = true,
        plugin = {
                "pretty",
                "html:ujian-api-report/extentreport/ujian-api.html",
                "json:ujian-api-report/extentreport/ujian-api.json",
                "junit:ujian-api-report/extentreport/ujian-api.xml"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}




