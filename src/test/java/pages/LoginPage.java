package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framework.BasePage;
import config.Configuration;

public class LoginPage extends BasePage {
	
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	By textboxTitle = By.xpath("//h2[@class='barone']");
	By inputfieldUsername = By.name("uid");
	By inputfieldPassword = By.name("password");
	By btnLogin = By.name("btnLogin");
	By titleText =By.className("barone");
	
    //Get the title of Login Page

    public String getLoginTitle(){

    	return    driver.findElement(titleText).getText();
    }
    
	// Insert username
	public void insertUsername (String username1) {
		driver.findElement(inputfieldUsername).sendKeys(username1);
	}
	
	// insert password
	public void insertPassword (String password1) {
		driver.findElement(inputfieldPassword).sendKeys(password1);
	}
	
	//click login button
	public void clickBtnLogin () {
		driver.findElement(btnLogin).click();
	}
	
	//login to Guru99 bankV4
	
	public void goToLoginPage() {
		driver.get(Configuration.getURL());
	}
	
	public void loginToGuru99(String username1, String password1) {
		
		insertUsername(username1);
		insertPassword(password1);
		clickBtnLogin();
	}
	
	public void goToPageAndLoginWithValidUser() {
		goToLoginPage();
		loginToGuru99(Configuration.getUsername(), Configuration.GetPassword());
	}
}
