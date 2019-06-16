package com.assignment.producttests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isA;

import org.testng.annotations.Test;

import com.assignment.api.ProductApi;
import com.assignment.base.BaseTest;
import com.assignment.dataprovider.RepositoryForUpdateProductTestCase;
import com.assignment.util.PropertiesReader;

public class UpdateProductTest extends BaseTest {

	String validProductId;
	String inValidProductId = "abc234242";

	public String getProductId() {
		response = ProductApi.createNewProduct();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(201);
		response.then().assertThat().body("id", isA(Integer.class));
		return "" + response.then().extract().path("id");
	}

	@Test
	public void updateValidSpecificProduct() {
		validProductId = getProductId();
		response = ProductApi.updateProduct(validProductId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(200);
		response.then().assertThat().body("id", equalTo(Integer.parseInt(validProductId)));
		response.then().assertThat().body("name", equalTo(PropertiesReader.get("name1")));
	}

	@Test
	public void updateInValidProduct() {
		response = ProductApi.updateProduct(inValidProductId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(404);
		response.then().assertThat().body("name", equalTo("NotFound"));
		response.then().assertThat().body("message", equalTo("No record found for id '" + inValidProductId + "'"));
		response.then().assertThat().body("code", equalTo(404));
		response.then().assertThat().body("className", equalTo("not-found"));
	}

	@Test
	public void updateWithInValidProductBody() {
		response = ProductApi.updateProductWithoutBody(inValidProductId);
		System.out.println("Response:\n" + response.asString());

		response.then().statusCode(500);
		response.then().assertThat().body("name", equalTo("GeneralError"));
		response.then().assertThat().body("message", equalTo("Unexpected token \" in JSON at position 0"));
		response.then().assertThat().body("code", equalTo(500));
		response.then().assertThat().body("className", equalTo("general-error"));
	}

	// API should return error for length validation same as Add Product API
	@Test(dataProviderClass = RepositoryForUpdateProductTestCase.class, dataProvider = "BothData")
	public void updateProductErrorValidation(String name, String type, String price, String shipping, String upc,
			String description, String manufacturer, String model, String errorMessage) {
		validProductId = getProductId();
		response = ProductApi.verifyErrorsInUpdateProduct(validProductId, name, type, price, shipping, upc, description,
				manufacturer, model);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(400);
		response.then().assertThat().body("name", equalTo("BadRequest"));
		response.then().assertThat().body("message", equalTo("Invalid Parameters"));
		response.then().assertThat().body("code", equalTo(400));
		response.then().assertThat().body("className", equalTo("bad-request"));
		response.then().assertThat().body("errors", hasItem(errorMessage));
	}
}
