package com.assignment.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.assignment.util.PropertiesReader;
import com.assignment.util.RandomValueGenerator;

public class RepositoryForAddStoreTestCase {

	@DataProvider(name = "BothData")
	public static Object[][] bothCaseData(Method mtd) {
		Object detail[][] = null;
		PropertiesReader.load(System.getProperty("user.dir") + "/src/main/resources/stores.properties");
		if (mtd.getName().equalsIgnoreCase("createNewStoreErrorValidation")) {
			return new Object[][] { { "", PropertiesReader.get("type"), PropertiesReader.get("address"),
					PropertiesReader.get("address2"), PropertiesReader.get("city"), PropertiesReader.get("state"),
					PropertiesReader.get("zip"), PropertiesReader.get("lat"), PropertiesReader.get("lng"),
					PropertiesReader.get("hours"), "'name' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), "", PropertiesReader.get("address"),
							PropertiesReader.get("address2"), PropertiesReader.get("city"),
							PropertiesReader.get("state"), PropertiesReader.get("zip"), PropertiesReader.get("lat"),
							PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'type' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), "", PropertiesReader.get("address2"),
							PropertiesReader.get("city"), PropertiesReader.get("state"), PropertiesReader.get("zip"),
							PropertiesReader.get("lat"), PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'address' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"), "", PropertiesReader.get("state"),
							PropertiesReader.get("zip"), PropertiesReader.get("lat"), PropertiesReader.get("lng"),
							PropertiesReader.get("hours"), "'city' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"), PropertiesReader.get("city"), "",
							PropertiesReader.get("zip"), PropertiesReader.get("lat"), PropertiesReader.get("lng"),
							PropertiesReader.get("hours"), "'state' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"), PropertiesReader.get("city"),
							PropertiesReader.get("state"), "", PropertiesReader.get("lat"), PropertiesReader.get("lng"),
							PropertiesReader.get("hours"), "'zip' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"), PropertiesReader.get("city"),
							PropertiesReader.get("state"), PropertiesReader.get("zip"), PropertiesReader.get("lat"),
							PropertiesReader.get("lng"), "", "'hours' should NOT be shorter than 1 characters" },

					{ RandomValueGenerator.generateRandomAlphabetesString(101), PropertiesReader.get("type"),
							PropertiesReader.get("address"), PropertiesReader.get("address2"),
							PropertiesReader.get("city"), PropertiesReader.get("state"), PropertiesReader.get("zip"),
							PropertiesReader.get("lat"), PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'name' should NOT be longer than 100 characters" },
					{ PropertiesReader.get("name"), RandomValueGenerator.generateRandomAlphabetesString(31),
							PropertiesReader.get("address"), PropertiesReader.get("address2"),
							PropertiesReader.get("city"), PropertiesReader.get("state"), PropertiesReader.get("zip"),
							PropertiesReader.get("lat"), PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'type' should NOT be longer than 30 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"),
							RandomValueGenerator.generateRandomAlphabetesString(51),
							PropertiesReader.get("address2"), PropertiesReader.get("city"),
							PropertiesReader.get("state"), PropertiesReader.get("zip"), PropertiesReader.get("lat"),
							PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'address' should NOT be longer than 50 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							RandomValueGenerator.generateRandomAlphabetesString(31),
							PropertiesReader.get("city"), PropertiesReader.get("state"), PropertiesReader.get("zip"),
							PropertiesReader.get("lat"), PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'address2' should NOT be longer than 30 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"),
							RandomValueGenerator.generateRandomAlphabetesString(51),
							PropertiesReader.get("state"), PropertiesReader.get("zip"), PropertiesReader.get("lat"),
							PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'city' should NOT be longer than 50 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"), PropertiesReader.get("city"),
							RandomValueGenerator.generateRandomAlphabetesString(31),
							PropertiesReader.get("zip"), PropertiesReader.get("lat"), PropertiesReader.get("lng"),
							PropertiesReader.get("hours"), "'state' should NOT be longer than 30 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"), PropertiesReader.get("city"),
							PropertiesReader.get("state"),
							RandomValueGenerator.generateRandomAlphabetesString(31),
							PropertiesReader.get("lat"), PropertiesReader.get("lng"), PropertiesReader.get("hours"),
							"'zip' should NOT be longer than 30 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("address"),
							PropertiesReader.get("address2"), PropertiesReader.get("city"),
							PropertiesReader.get("state"), PropertiesReader.get("zip"), PropertiesReader.get("lat"),
							PropertiesReader.get("lng"),
							RandomValueGenerator.generateRandomAlphabetesString(101),
							"'hours' should NOT be longer than 100 characters" } };
		}
		return detail;
	}
}
