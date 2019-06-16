package com.assignment.producttests;

import static org.hamcrest.Matchers.isA;

import org.testng.annotations.Test;

import com.assignment.api.ProductApi;
import com.assignment.base.BaseTest;

public class GetAllProductsTest extends BaseTest {

	@Test
	public void getAllProducts() {
		response = ProductApi.getAllProducts();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(200);
		response.then().assertThat().body("total", isA(Integer.class));
		response.then().assertThat().body("limit", isA(Integer.class));
		response.then().assertThat().body("skip", isA(Integer.class));
	}
}
