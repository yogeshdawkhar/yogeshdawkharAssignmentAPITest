package com.assignment.api;

import static io.restassured.RestAssured.given;

import com.assignment.template.Store;

import io.restassured.response.Response;

public class StoreApi {

	static String stores = "/stores";
	static String appicationJson = "application/json";

	public static Response createNewStore() {
		return given().contentType(appicationJson).body(Store.getStoreDetails()).log().all().when().post(stores);
	}

	public static Response createNewStoreWithEmptyvalues() {
		return given().contentType(appicationJson).body(Store.getEmptyStoreDetails()).log().all().when().post(stores);
	}

	public static Response verifyErrorsInCreateNewStore(String name, String type, String address, String address2,
			String city, String state, String zip, String lat, String lng, String hours) {
		return given().contentType(appicationJson).body(
				Store.getCustomBodyforStoreDetails(name, type, address, address2, city, state, zip, lat, lng, hours))
				.log().all().when().post(stores);
	}

	public static Response getAllStores() {
		return given().contentType(appicationJson).log().all().when().get(stores);
	}

	public static Response getSpecificStore(String storeId) {
		return given().log().all().when().get(String.format("%s/%s", stores, storeId));
	}

	public static Response deleteSpecificStore(String storeId) {
		return given().log().all().when().delete(String.format("%s/%s", stores, storeId));
	}

	public static Response verifyErrorsInUpdateStore(String storeId, String name, String type, String address,
			String address2, String city, String state, String zip, String lat, String lng, String hours) {
		return given()
				.contentType(appicationJson).body(Store.getCustomBodyforStoreDetails(name, type, address, address2,
						city, state, zip, lat, lng, hours))
				.log().all().when().patch(String.format("%s/%s", stores, storeId));
	}

	public static Response updateStore(String storeId) {
		return given().contentType(appicationJson).body(Store.getUpdatedStoreDetails()).log().all().when()
				.patch(String.format("%s/%s", stores, storeId));
	}

	public static Response updateStoreWithoutBody(String storeId) {
		return given().contentType(appicationJson).body(Store.getEmptyBodyforStoreDetails()).log().all().when()
				.patch(String.format("%s/%s", stores, storeId));
	}

	public static Response createNewStoreWithOutNameField() {
		return given().contentType(appicationJson).body(Store.getBodyWithoutNameField()).log().all().when()
				.post(stores);
	}
}
