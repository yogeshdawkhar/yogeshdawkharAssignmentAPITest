package com.assignment.api;

import static io.restassured.RestAssured.given;

import com.assignment.template.Product;

import io.restassured.response.Response;

public class ProductApi {

	static String product = "/products";
	static String appicationJson = "application/json";

	public static Response createNewProduct() {
		return given().contentType(appicationJson).body(Product.getProductDetails()).log().all().when().post(product);

	}

	public static Response getAllProducts() {
		return given().contentType(appicationJson).log().all().when().get(product);
	}

	public static Response getSpecificProduct(String productId) {
		return given().log().all().when().get(String.format("%s/%s", product, productId));
	}

	public static Response deleteSpecificProduct(String productId) {
		return given().log().all().when().delete(String.format("%s/%s", product, productId));
	}

	public static Response updateProduct(String productId) {
		return given().contentType(appicationJson).body(Product.getUpdatedProductDetails()).log().all().when()
				.patch(String.format("%s/%s", product, productId));
	}

	public static Response verifyErrorsInCreateNewProduct(String name, String type, String price, String shipping,
			String upc, String description, String manufacturer, String model) {
		return given().contentType(appicationJson)
				.body(Product.getCustomBody(name, type, price, shipping, upc, description, manufacturer, model)).log()
				.all().when().post(product);
	}

	public static Response createNewProductWithEmptyValues() {
		return given().contentType(appicationJson).body(Product.getEmptyProductDetails()).log().all().when()
				.post(product);
	}

	public static Response createNewProductWithOutNameField() {
		return given().contentType(appicationJson).body(Product.getProductDetailsWithoutName()).log().all().when()
				.post(product);
	}

	public static Response updateProductWithoutBody(String productId) {
		return given().contentType(appicationJson).body(Product.getEmptyBodyforProductDetails()).log().all().when()
				.patch(String.format("%s/%s", product, productId));
	}

	public static Response verifyErrorsInUpdateProduct(String productId, String name, String type, String price,
			String shipping, String upc, String description, String manufacturer, String model) {
		return given().contentType(appicationJson)
				.body(Product.getCustomBody(name, type, price, shipping, upc, description, manufacturer, model)).log()
				.all().when().patch(String.format("%s/%s", product, productId));
	}
}
