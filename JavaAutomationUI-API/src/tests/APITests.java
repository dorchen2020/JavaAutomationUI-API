package tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import utills.Base;
import utills.HttpMethods;
import utills.PrepareAPITests;

public class APITests extends PrepareAPITests{

	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass()); // like LogsFromPropertiesFile.class in generic
	
	// Initialise JSON - delete users and add three base users
	@Test (priority=1)
	void restoreBaseUsers() {  	
		Base.methodeName("restoreBaseUsers");
		int userId = HttpMethods.retCountOfUsers();
		while(userId!=0) {
			HttpMethods.deleteUser(userId);
			userId--;
		}
		HttpMethods.AddBaseUsers();
	}
	
	@Test (dataProvider = "GetData", priority=1)
	void getUsers(int userId) { 		
		Base.methodeName("GetUsers");
		HttpMethods.getUser(userId);
	}
	
	// Post user
	@Test (dataProvider = "PostData", priority=2)
	void postUsers(String firstName, String lastName, int age, int subjectId) { 
		Base.methodeName("PostUsers");
		map = new HashMap<String, Object>();
		map.put("firstName",firstName);
		map.put("lastName",lastName);
		map.put("age",age);
		map.put("subjectId",subjectId);
		
		int userId = HttpMethods.postUser(map);
		
		given().
			get(baseURI+usersResource+"/"+userId).  
		then().
			assertThat().statusCode(200). // get status code of created user
			assertThat().body("firstName", equalTo(firstName)).
			assertThat().body("lastName", equalTo(lastName)).
			assertThat().body("age", equalTo(age)).
			assertThat().body("subjectId", equalTo(subjectId)).
			log().body();
	}

	// Patch user 
	@Test (dataProvider = "PatchData", priority=3)
	void patchUsers(int userId, String firstName, int age) {  
		Base.methodeName("PatchUsers");
		map = new HashMap<String, Object>();
		map.put("firstName",firstName);
		map.put("age",age);
		HttpMethods.patchUser(userId, map);
		
		given().
			get(baseURI+usersResource+"/"+userId).
		then().
			assertThat().body("firstName", equalTo(firstName)).
			assertThat().body("age", equalTo(age));
	}
	
	// Put user
	@Test (dataProvider = "PutData", priority=4)
	void putUsers(int userId, String firstName, String lastName, int age, int subjectId) { 
		Base.methodeName("PutUsers");
		map = new HashMap<String, Object>();
		map.put("firstName",firstName);
		map.put("lastName",lastName);
		map.put("age",age);
		map.put("subjectId",subjectId);
		HttpMethods.putUser(userId, map);
			
		given().
			get(baseURI+usersResource+"/"+userId).
		then().
			assertThat().body("firstName", equalTo(firstName)).
			assertThat().body("lastName", equalTo(lastName)).
			assertThat().body("age", equalTo(age)).
			assertThat().body("subjectId", equalTo(subjectId));
	}
	
	// Delete user
	@Test (dataProvider = "DeleteData", priority=5)
	void deleteUsers(int userId) {
		Base.methodeName("DeleteUsers");
		HttpMethods.deleteUser(userId);
		
		given().
			get(baseURI+usersResource+"/"+userId).
		then().
			assertThat().statusCode(404);
	}
  
	// check if key value exist in user. 
	@Test (dataProvider = "keyValueData", priority=6)
	void isKeyValExistInNode(int id, String recource, String key, String value) {
		Base.methodeName("isKeyValExistInNode");
		HttpMethods.isKeyValExistInNode(id, recource, key, value);
	}
}