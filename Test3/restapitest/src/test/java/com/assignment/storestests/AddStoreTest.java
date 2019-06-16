package com.assignment.storestests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.Test;

import com.assignment.api.StoreApi;
import com.assignment.base.BaseTest;
import com.assignment.dataprovider.RepositoryForAddStoreTestCase;
import com.assignment.util.PropertiesReader;

public class AddStoreTest extends BaseTest {

	@Test
	public void createNewStore() {
		response = StoreApi.createNewStore();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(201);
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

	@Test(dataProviderClass = RepositoryForAddStoreTestCase.class, dataProvider = "BothData")
	public void createNewStoreErrorValidation(String name, String type, String address, String address2, String city,
			String state, String zip, String lat, String lng, String hours, String errorMessage) {
		response = StoreApi.verifyErrorsInCreateNewStore(name, type, address, address2, city, state, zip, lat, lng,
				hours);
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(400);
		response.then().assertThat().body("name", equalTo("BadRequest"));
		response.then().assertThat().body("message", equalTo("Invalid Parameters"));
		response.then().assertThat().body("code", equalTo(400));
		response.then().assertThat().body("className", equalTo("bad-request"));
		response.then().assertThat().body("errors", hasItem(errorMessage));
	}

	@Test
	public void createNewStoreResponseForBadRequest() {
		response = StoreApi.createNewStoreWithEmptyvalues();
		System.out.println("Response:\n" + response.asString());
		response.then().statusCode(400);
		response.then().assertThat().body("name", equalTo("BadRequest"));
		response.then().assertThat().body("message", equalTo("Invalid Parameters"));
		response.then().assertThat().body("code", equalTo(400));
	}
	// To Test Request without mandatory field
		@Test
		public void createNewStoreWithOutNameField() {
			response = StoreApi.createNewStoreWithOutNameField();
			System.out.println("Response:\n" + response.asString());
			response.then().statusCode(400);
			response.then().assertThat().body("name", equalTo("BadRequest"));
			response.then().assertThat().body("message", equalTo("Invalid Parameters"));
			response.then().assertThat().body("code", equalTo(400));
			response.then().assertThat().body("errors", hasItem("should have required property 'name'"));
		}
}
