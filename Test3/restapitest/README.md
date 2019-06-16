## RestAssignment3Yogeshdawkhar
API automation for Products and Store API's

This document explains required software, test structure and how to run tests.

## Prerequisites
Software that is required to make this repo work :) 
- Java 1.8
- Maven 

### Libraries used

#### rest-assured

- Test and validate API end points

#### TestNG

- Is used mainly as test runner, to maintain test structure using annotations

#### gson

- Java library to serialize and deserialize Java objects to JSON

#### hamcrest

- Used for assertions, matchers to verify results

## Project Structure

```
pom.xml
testng.xml

src
└──
    └── main
           └──java
                 └── com
                       └── assignment
                  	       └── api
                                ├── ProductApi.java : Extracted calls for Products API
                                ├── StoreApi.java : Extracted calls for Store API
    
                  	       └── template
                                ├── Product.java : To form a body for Products API from product.properties file
                                ├── Store.java : To form a body for Products API from store.properties file   
                                                             
                  	       └── util
                                ├── PropertiesReader.java : Utility to read properties from various property files  
                                ├── RandomValueGenerator.java : Utility to generate random string and number 
     
src
└──
    └── main
           └──resources
               ├── env.properties : Environment details for the environment on which the tests need to be run
               ├── product.properties : Product details to create product body
               ├── store.properties : Store details to create product body
 
src
└──
    └── test
           └──java
                 └── com
                       └── assignment
                  	       └── base
                                ├── BaseTest.java : Base class to load environment details from file
                                     
                  	       └── dataprovider
                                ├── RepositoryForAddProductTestCase.java : Class for data provider to AddProductTestCase  
                                ├── RepositoryForAddStoreTestCase.java : Class for data provider to AddStoreTestCase
                                ├── RepositoryForUpdateProductTestCase.java : Class for data provider to UpdatePoductTestCase
                                ├── RepositoryForUpdateStoreTestCase.java : Class for data provider to UpdateStoreTestCase
     
                  	       └── producttests
                                ├── AddProductTest.java : Class to Test Add Product API  
                                ├── DeleteProductTest.java : Class to Test Delete Product API 
                                ├── GetAllProductsTest.java : Class to Test Get All Products API 
                                ├── GetProductTest.java : Class to Test Get Product API 
                                ├── UpdateProductTest.java : Class to Test Update Product API                                    
    
                  	       └── storetests
                                ├── AddStoreTest.java : Class to Test Add Store API  
                                ├── DeleteStoreTest.java : Class to Test Delete Store API 
                                ├── GetAllStoresTest.java : Class to Test Get All Stores API 
                                ├── GetStoreTest.java : Class to Test Get Store API 
                                ├── UpdateStoreTest.java : Class to Test Update Store API                                    
                                       
```
#### Running Test

From terminal use `mvn clean test` to run all the tests
use `mvn -Dtest=testfilename test` to run a specific file

Find reports under target -> surefire-reports

### Comments in code 

Entire code styling is influenced by Clean Code principle - Robert Martin
Which says
'Truth can only be found in one place: the code’.
So you may not find any comments anywhere in the project.
Keeping in mind that git can be used to versioning of file and method, class names should be kept as self explanatory.

However, if you need comments on each file. I can do that too.

#### Design principles used in Project :

- DRY(Don’t repeat yourself)
- KISS(Keep it simple, stupid)
