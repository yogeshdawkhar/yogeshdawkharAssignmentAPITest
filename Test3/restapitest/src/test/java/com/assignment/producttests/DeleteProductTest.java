package com.assignment.producttests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

import org.testng.annotations.Test;

import com.assignment.api.ProductApi;
import com.assignment.base.BaseTest;
import com.assignment.util.PropertiesReader;

import io.restassured.RestAssured;

public class DeleteProductTest extends BaseTest {

	String validProductId;
	String inValidProductId = "xyx111";

	public String getValidProductId() {
		RestAssured.baseURI = baseURI;
		response = ProductApi.createNewProduct();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(201);
		response.then().assertThat().body("id", isA(Integer.class));
		return "" + response.then().extract().path("id");
	}

	@Test
	public void deleteValidSpecificProduct() {
		validProductId = getValidProductId();
		response = ProductApi.deleteSpecificProduct(validProductId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(200);
		response.then().assertThat().body("id", equalTo(Integer.parseInt(validProductId)));
		response.then().assertThat().body("name", equalTo(PropertiesReader.get("name")));
		response.then().assertThat().body("type", equalTo(PropertiesReader.get("type")));
		response.then().assertThat().body("price", equalTo(Integer.parseInt(PropertiesReader.get("price"))));
		response.then().assertThat().body("shipping", equalTo(Integer.parseInt(PropertiesReader.get("shipping"))));
		response.then().assertThat().body("upc", equalTo(PropertiesReader.get("upc")));
		response.then().assertThat().body("description", equalTo(PropertiesReader.get("description")));
		response.then().assertThat().body("manufacturer", equalTo(PropertiesReader.get("manufacturer")));
		response.then().assertThat().body("model", equalTo(PropertiesReader.get("model")));
	}

	@Test
	public void deleteInvalidSpecificProduct() {
		response = ProductApi.deleteSpecificProduct(inValidProductId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(404);
		response.then().assertThat().body("name", equalTo("NotFound"));
		response.then().assertThat().body("message", equalTo("No record found for id '" + inValidProductId + "'"));
		response.then().assertThat().body("code", equalTo(404));
		response.then().assertThat().body("className", equalTo("not-found"));
	}
}
