package utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertyFile {

	// get prop by key from properties file
	public static String getProp(String propName) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip= new FileInputStream(System.getProperty("user.dir")
				+ File.separator +"config.properties");
		prop.load(ip);
		return prop.getProperty(propName);
	}
}
