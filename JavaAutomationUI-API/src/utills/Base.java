package utills;

import java.io.File;
import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Base {
	
	private static final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass()); // like className.class in generic
	
	// Load Configuration From log4j.Properties File
    public static void LoadLogsPropertiesFromFile() { 
    	String log4jConfigFilePath = System.getProperty("user.dir") // path project - C:\eclipse workspace\FinalProject
    			+ File.separator + "log4j.properties"; 
    	PropertyConfigurator.configure(log4jConfigFilePath);
    	log.info("Success loading logs configuration from properties file");
    }
    
    public static void methodeName(String methodeName) {
    	log.info("|* Test Name: " + methodeName + " *|");
    }
} 
