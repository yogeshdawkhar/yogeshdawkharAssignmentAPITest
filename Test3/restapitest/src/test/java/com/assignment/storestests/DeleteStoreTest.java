package com.assignment.storestests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

import org.testng.annotations.Test;

import com.assignment.api.StoreApi;
import com.assignment.base.BaseTest;
import com.assignment.util.PropertiesReader;

public class DeleteStoreTest extends BaseTest {

	String storeId;
	String inValidStoreId = "xyx111";

	public String getStoreId() {
		response = StoreApi.createNewStore();
		response.then().statusCode(201);
		response.then().assertThat().body("id", isA(Integer.class));
		return "" + response.then().extract().path("id");
	}

	@Test
	public void deleteValidSpecificProduct() {
		storeId = getStoreId();
		response = StoreApi.deleteSpecificStore(storeId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(200);
		response.then().assertThat().body("id", equalTo(Integer.parseInt(storeId)));
		response.then().assertThat().body("name", equalTo(PropertiesReader.get("name")));
		response.then().assertThat().body("type", equalTo(PropertiesReader.get("type")));
		response.then().assertThat().body("address", equalTo(PropertiesReader.get("address")));
		response.then().assertThat().body("address2", equalTo(PropertiesReader.get("address2")));
		response.then().assertThat().body("city", equalTo(PropertiesReader.get("city")));
		response.then().assertThat().body("state", equalTo(PropertiesReader.get("state")));
		response.then().assertThat().body("zip", equalTo(PropertiesReader.get("zip")));
		response.then().assertThat().body("lat", equalTo(Integer.parseInt(PropertiesReader.get("lat"))));
		response.then().assertThat().body("lng", equalTo(Integer.parseInt(PropertiesReader.get("lng"))));
		response.then().assertThat().body("hours", equalTo(PropertiesReader.get("hours")));
	}

	@Test
	public void deleteInvalidSpecificProduct() {
		response = StoreApi.deleteSpecificStore(inValidStoreId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(404);
		response.then().assertThat().body("name", equalTo("NotFound"));
		response.then().assertThat().body("message", equalTo("No record found for id '" + inValidStoreId + "'"));
		response.then().assertThat().body("code", equalTo(404));
		response.then().assertThat().body("className", equalTo("not-found"));
	}
}
