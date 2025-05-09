package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	 private static Properties properties;

	    static {
	        try {
	            FileInputStream fis = new FileInputStream("src\\test\\resources\\configs\\Configuation.properties");
	            properties = new Properties();
	            properties.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("config.properties not found at specified path.");
	        }
	    }

	    public static String getBrowser() {
	        return properties.getProperty("browser");
	    }

	    public static String getBaseURL() {
	        return properties.getProperty("baseURL");
	    }
	    public static String getRegisterURL() {
	        return properties.getProperty("registerURL");
	    }


	    public static int getImplicitWait() {
	        return Integer.parseInt(properties.getProperty("implicitWait"));
	    }
	    
	    public static String driverpath() {
	    	  return properties.getProperty("driverpath");
	    }
}
