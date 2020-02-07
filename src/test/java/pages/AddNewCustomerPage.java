package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framework.BasePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class AddNewCustomerPage extends BasePage {

	public AddNewCustomerPage(WebDriver driver) {
		super(driver);

	}

	By addNewCustomerTitle = By.xpath("//p[@class='heading3']");
	By customerNameTextbox = By.name("name");
	By genderMaleTextbox = By.xpath("//tr[5]//td[2]//input[1]");
	By genderFemaleTextbox = By.xpath("//tr[5]//td[2]//input[2]");
	By genderRadioButtons = By.name("rad1");


	By doBDatePicker = By.id("dob");
	By addressTextbox = By.name("addr");
	By cityTextbox = By.name("city");
	By stateTextbox = By.name("state");
	By pinTextbox = By.name("pinno");
	By telephoneNumberTextbox = By.name("telephoneno");
	By emailTextbox = By.name("emailid");
	By passwordTextbox = By.name("password");

	By submitBtn = By.xpath("//input[@name='sub']");
	By resetBtn = By.name("res");

	//Get Add New Customer title
	public By getTitleAddNewCustomer() {
		driver.findElement(addNewCustomerTitle).getText();
		return addNewCustomerTitle;
	}

//	public void clearAllEditableFields(){
//		By[] elementsToClear = {addressTextbox,cityTextbox,stateTextbox}
//		driver.findElements(elementsToClear).clear();
//	}

	public void insertCustomerName(String customerName) {
		driver.findElement(customerNameTextbox).sendKeys(customerName);
	}
	public void selectFemaleGender() {driver.findElements(genderRadioButtons).get(1).click();}

	public void insertDoB(String dob) {
		driver.findElement(doBDatePicker).sendKeys(dob);
	}

	public void insertAddress(String address) {
		driver.findElement(addressTextbox).sendKeys(address);
	}

	public void insertCity(String city) {
		driver.findElement(cityTextbox).sendKeys(city);
//		wait.until(ready -> driver.findElement(cityTextbox));
	}

	public void insertState(String state) {
		driver.findElement(stateTextbox).sendKeys(state);
	}

	public void insertPin(String pin) {
		driver.findElement(pinTextbox).sendKeys(pin);
	}

	public void insertTelephone(String telephoneasd) {
		driver.findElement(telephoneNumberTextbox).sendKeys(telephoneasd);
	}

	public void insertEmail(String email) {
		driver.findElement(emailTextbox).sendKeys(email);
	}

	public void insertPassword(String password) {
		driver.findElement(passwordTextbox).sendKeys(password);
	}

	public void submitForm() {
		driver.findElement(submitBtn).click();
	}

	public void createNewValidRandomCustomer() {
		insertCustomerName(RandomStringUtils.randomAlphabetic(10));
		selectFemaleGender();
		insertDoB("11111999");
		insertAddress(RandomStringUtils.randomAlphanumeric(10));
		insertCity(RandomStringUtils.randomAlphabetic(10));
		insertState(RandomStringUtils.randomAlphabetic(10));
		insertPin(RandomStringUtils.randomNumeric(6));
		insertTelephone(RandomStringUtils.randomNumeric(10));
		insertEmail(RandomStringUtils.randomAlphanumeric(10)+"@"+RandomStringUtils.randomAlphanumeric(6)+".com");
		insertPassword("1234");
		submitForm();
	}

}