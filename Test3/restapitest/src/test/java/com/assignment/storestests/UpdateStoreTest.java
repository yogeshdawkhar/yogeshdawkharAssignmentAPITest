package com.assignment.storestests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.isA;

import org.testng.annotations.Test;

import com.assignment.api.StoreApi;
import com.assignment.base.BaseTest;
import com.assignment.dataprovider.RepositoryForUpdateStoreTestCase;
import com.assignment.util.PropertiesReader;

public class UpdateStoreTest extends BaseTest {

	String storeId;
	String inValidStoreId = "3232251959";

	public String getStoreId() {
		response = StoreApi.createNewStore();
		response.then().statusCode(201);
		response.then().assertThat().body("id", isA(Integer.class));
		return "" + response.then().extract().path("id");
	}

	@Test
	public void updateValidSpecificStore() {
		storeId = getStoreId();
		response = StoreApi.updateStore(storeId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(200);
		response.then().assertThat().body("id", equalTo(Integer.parseInt(storeId)));
		response.then().assertThat().body("name", equalTo(PropertiesReader.get("name1")));
	}

	@Test
	public void updateInValidStore() {
		response = StoreApi.updateStore(inValidStoreId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(404);
		response.then().assertThat().body("name", equalTo("NotFound"));
		response.then().assertThat().body("message", equalTo("No record found for id '" + inValidStoreId + "'"));
		response.then().assertThat().body("code", equalTo(404));
		response.then().assertThat().body("className", equalTo("not-found"));
	}

	@Test
	public void updateWithInValidStoreBody() {
		response = StoreApi.updateStoreWithoutBody(inValidStoreId);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(500);
		response.then().assertThat().body("name", equalTo("GeneralError"));
		response.then().assertThat().body("message", equalTo("Unexpected token \" in JSON at position 0"));
		response.then().assertThat().body("code", equalTo(500));
		response.then().assertThat().body("className", equalTo("general-error"));
	}

	// API should return error for length validation same as Add Store API
	@Test(dataProviderClass = RepositoryForUpdateStoreTestCase.class, dataProvider = "BothData")
	public void updateStoreErrorValidation(String name, String type, String address, String address2, String city,
			String state, String zip, String lat, String lng, String hours, String errorMessage) {
		storeId = getStoreId();
		response = StoreApi.verifyErrorsInUpdateStore(storeId, name, type, address, address2, city, state, zip, lat,
				lng, hours);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(400);
		response.then().assertThat().body("name", equalTo("BadRequest"));
		response.then().assertThat().body("message", equalTo("Invalid Parameters"));
		response.then().assertThat().body("code", equalTo(400));
		response.then().assertThat().body("className", equalTo("bad-request"));
		response.then().assertThat().body("errors", hasItem(errorMessage));
	}
}
