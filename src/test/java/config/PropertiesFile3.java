//package config;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class PropertiesFile3 {
//
//
//	public static void main(String[] args) {
//		getProperties();
//
//	}
//
//	public static String getProperties() {
//		try {
//			Properties prop = new Properties();
//			String projectPath = System.getProperty("user.dir");
//			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
//			prop.load(input);
//			String browser = prop.getProperty("browser");
//			System.out.println(browser);
//			return browser;
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
