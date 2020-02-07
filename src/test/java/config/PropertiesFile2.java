//package config;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Properties;
//
//public class PropertiesFile2 {
//
//
//	public static void main(String[] args) {
//		getProperties();
//
//	}
//
//	public static ArrayList<String> getProperties() {
//		try {
//			Properties prop = new Properties();
//			String projectPath = System.getProperty("user.dir");
//			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
//			prop.load(input);
//			String browser = prop.getProperty("browser");
//			System.out.println(browser);
//			String customer = prop.getProperty("customer");
//			ArrayList<String> propertiesArray = new ArrayList<String>();
//			propertiesArray.add(browser);
//			propertiesArray.add(customer);
//			return propertiesArray;
//
//
//		} catch (Exception exp) {
//			System.out.println(exp.getMessage());
//			System.out.println(exp.getCause());
//			exp.printStackTrace();
//			return "chrome";
//		}
//		
//	}
//}
