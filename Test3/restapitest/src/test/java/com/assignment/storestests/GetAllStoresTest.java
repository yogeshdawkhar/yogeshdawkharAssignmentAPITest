package com.assignment.storestests;

import static org.hamcrest.Matchers.isA;

import org.testng.annotations.Test;

import com.assignment.api.StoreApi;
import com.assignment.base.BaseTest;

public class GetAllStoresTest extends BaseTest {

	@Test
	public void getAllStoress() {
		response = StoreApi.getAllStores();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(200);
		response.then().assertThat().body("total", isA(Integer.class));
		response.then().assertThat().body("limit", isA(Integer.class));
		response.then().assertThat().body("skip", isA(Integer.class));
	}
}
