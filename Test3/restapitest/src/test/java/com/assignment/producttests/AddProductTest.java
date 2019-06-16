package com.assignment.producttests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.Test;

import com.assignment.api.ProductApi;
import com.assignment.base.BaseTest;
import com.assignment.dataprovider.RepositoryForAddProductTestCase;
import com.assignment.util.PropertiesReader;

public class AddProductTest extends BaseTest {
	// To Test Request without mandatory field
	@Test
	public void createNewProductWithOutNameField() {
		response = ProductApi.createNewProductWithOutNameField();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(400);
		response.then().assertThat().body("name", equalTo("BadRequest"));
		response.then().assertThat().body("message", equalTo("Invalid Parameters"));
		response.then().assertThat().body("code", equalTo(400));
		response.then().assertThat().body("errors", hasItem("should have required property 'name'"));
	}

	@Test
	public void createNewProduct() {
		response = ProductApi.createNewProduct();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(201);
		response.then().assertThat().body("name", equalTo(PropertiesReader.get("name")));
		response.then().assertThat().body("type", equalTo(PropertiesReader.get("type")));
		response.then().assertThat().body("price", equalTo(Integer.parseInt(PropertiesReader.get("price"))));
		response.then().assertThat().body("shipping", equalTo(Integer.parseInt(PropertiesReader.get("shipping"))));
		response.then().assertThat().body("upc", equalTo(PropertiesReader.get("upc")));
		response.then().assertThat().body("description", equalTo(PropertiesReader.get("description")));
		response.then().assertThat().body("manufacturer", equalTo(PropertiesReader.get("manufacturer")));
		response.then().assertThat().body("model", equalTo(PropertiesReader.get("model")));
	}

	@Test(dataProviderClass = RepositoryForAddProductTestCase.class, dataProvider = "BothData")
	public void createNewProductErrorValidation(String name, String type, String price, String shipping, String upc,
			String description, String manufacturer, String model, String errorMessage) {
		response = ProductApi.verifyErrorsInCreateNewProduct(name, type, price, shipping, upc, description,
				manufacturer, model);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(400);
		response.then().assertThat().body("name", equalTo("BadRequest"));
		response.then().assertThat().body("message", equalTo("Invalid Parameters"));
		response.then().assertThat().body("code", equalTo(400));
		response.then().assertThat().body("className", equalTo("bad-request"));
		response.then().assertThat().body("errors", hasItem(errorMessage));
	}

	@Test
	public void createNewProductResponseForBadRequest() {
		response = ProductApi.createNewProductWithEmptyValues();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(400);
		response.then().assertThat().body("name", equalTo("BadRequest"));
		response.then().assertThat().body("message", equalTo("Invalid Parameters"));
		response.then().assertThat().body("code", equalTo(400));
	}
}
