package config;

import java.io.IOException;

public class Configuration {

	public static String GetBrowser() throws IOException{
		return PropertiesFile.getProperty("browser");
	}

	public static String getUsername() {
		try {
			return PropertiesFile.getProperty("username");
		}
		catch(Exception ex) {
			return null;
		}
	}

	public static String GetPassword(){
		try {
			return PropertiesFile.getProperty("password");
		}
		catch(Exception ex) {
			return null;
		}
	}

	public static String getURL(){
		try {
			return PropertiesFile.getProperty("URL");
		}
		catch(Exception ex) {
			return null;
		}
	}
}