package utills;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class PrepareAPITests {
		
	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass()); // like LogsFromPropertiesFile.class in generic
	protected static String baseURI = "http://localhost:3000";
	protected static String usersResource = "/users";
	protected static String subjectsResource = "/subjects";
	protected Map<String, Object> map;

	@BeforeClass
	public void beforeAllAPITests() throws IOException {
		Base.LoadLogsPropertiesFromFile();
	}
	
	@BeforeMethod
	public void beforeEachAPITest() throws InterruptedException {
		log.info("************************* Test Starts *************************");
	}

	@AfterMethod
	public void AfterEachTest() {
		log.info("************************** Test Ends **************************\n");
	}
	
	// ================ Data for API Tests ================
	
	@DataProvider(name="GetData")
	public Object[] dataForGet() {
		return new Object [] {1,2,3};						   
	}
	
	@DataProvider(name="PostData")
	public Object[][] dataForPost() {	
		return new Object [][] { 	   
			{"Alex", "Ben Ari",25 ,2}, 
			{"Tom", "Cooper",40 ,1}    
		};							   
	}
	
	@DataProvider(name="PatchData")
	public Object[][] dataForPatch() {
		return new Object [][] { 	   
			{2, "Moshe", 29},
		};							   
	}
	
	@DataProvider(name = "PutData")
	public Object[][] dataForPut() {
		return new Object [][] { 	   
			{3, "Itay", "Cohen", 16, 1}, 
			{5, "Avi", "Cohen" ,42, 2}
		};							   
	}
	
	@DataProvider(name="DeleteData")
	public Object[] dataForDelete() {
		return new Object [] {
			4,5
		};
	}
	
	@DataProvider(name="keyValueData")
	public Object[] dataForKeyValueCheck() {
		return new Object [][] {
			{1,"/users","lastName", "Chen"},
			{2,"/subjects","name", "Developer"}
		};
	}
	
	
}