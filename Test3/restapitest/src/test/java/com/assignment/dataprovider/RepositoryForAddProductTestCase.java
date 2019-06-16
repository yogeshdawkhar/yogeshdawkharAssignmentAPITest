package com.assignment.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.assignment.util.PropertiesReader;
import com.assignment.util.RandomValueGenerator;


public class RepositoryForAddProductTestCase {

	@DataProvider(name = "BothData")
	public static Object[][] bothCaseData(Method mtd) {
		Object detail[][] = null;
		PropertiesReader.load(System.getProperty("user.dir") + "/src/main/resources/product.properties");
		if (mtd.getName().equalsIgnoreCase("createNewProductErrorValidation")) {
			return new Object[][] {
					{ "", PropertiesReader.get("type"), PropertiesReader.get("price"), PropertiesReader.get("shipping"),
							PropertiesReader.get("upc"), PropertiesReader.get("description"),
							PropertiesReader.get("manufacturer"), PropertiesReader.get("model"),
							"'name' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), "", PropertiesReader.get("price"), PropertiesReader.get("shipping"),
							PropertiesReader.get("upc"), PropertiesReader.get("description"),
							PropertiesReader.get("manufacturer"), PropertiesReader.get("model"),
							"'type' should NOT be shorter than 1 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"),
							RandomValueGenerator.generateRandomNumberString(20), PropertiesReader.get("shipping"),
							PropertiesReader.get("upc"), PropertiesReader.get("description"),
							PropertiesReader.get("manufacturer"), PropertiesReader.get("model"),
							"'price' should be multiple of 0.01" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("price"),
							RandomValueGenerator.generateRandomNumberString(20), PropertiesReader.get("upc"),
							PropertiesReader.get("description"), PropertiesReader.get("manufacturer"),
							PropertiesReader.get("model"), "'shipping' should be multiple of 0.01" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("price"),
							PropertiesReader.get("shipping"), RandomValueGenerator.generateRandomAlphabetesString(16),
							PropertiesReader.get("description"), PropertiesReader.get("manufacturer"),
							PropertiesReader.get("model"), "'upc' should NOT be longer than 15 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("price"),
							PropertiesReader.get("shipping"), PropertiesReader.get("upc"),
							RandomValueGenerator.generateRandomAlphabetesString(101),
							PropertiesReader.get("manufacturer"), PropertiesReader.get("model"),
							"'description' should NOT be longer than 100 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("price"),
							PropertiesReader.get("shipping"), PropertiesReader.get("upc"),
							PropertiesReader.get("description"),
							RandomValueGenerator.generateRandomAlphabetesString(51), PropertiesReader.get("model"),
							"'manufacturer' should NOT be longer than 50 characters" },
					{ PropertiesReader.get("name"), PropertiesReader.get("type"), PropertiesReader.get("price"),
							PropertiesReader.get("shipping"), PropertiesReader.get("upc"),
							PropertiesReader.get("description"), PropertiesReader.get("manufacturer"),
							RandomValueGenerator.generateRandomAlphabetesString(26),
							"'model' should NOT be longer than 25 characters" } };
		}
		return detail;
	}
}
