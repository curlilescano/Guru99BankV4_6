package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework.BaseTest;
import pages.AddNewCustomerPage;
import pages.CustomerRegistrationSuccessfullyPage;
import pages.DeleteCustomerPage;
import pages.EditCustomerPage;
import pages.HomePage;
import pages.LoginPage;

public class AddNewCustomerTest extends BaseTest {

	AddNewCustomerPage objAddNC;
	LoginPage loginPage;
	HomePage objHomePage;
	CustomerRegistrationSuccessfullyPage objCRS;
	EditCustomerPage objEditCustomerPage;
	DeleteCustomerPage objDeleteCustomerPage;

	public static String CustomerIDFromAdd;


//	ArrayList <String> propertiesFromConfig = PropertiesFile2.getProperties();
	
	
//	public AddNewCustomer (WebDriver driver) {
//		this.driver = driver;
//	}
	
	@BeforeClass
	public void setupNewCustomer() {
		objHomePage = new HomePage(getDriver());
		objAddNC = new AddNewCustomerPage(getDriver());
		loginPage = new LoginPage(getDriver());
		objCRS = new CustomerRegistrationSuccessfullyPage(getDriver());
		objEditCustomerPage = new EditCustomerPage(getDriver());
		objDeleteCustomerPage = new DeleteCustomerPage(getDriver());
	
	}

	@Test
	public void LoginAndCreateNewCustomer() {
		loginPage.goToPageAndLoginWithValidUser();
		objHomePage.goToAddNewCustomer();
		objAddNC.createNewValidRandomCustomer();
		Assert.assertTrue(objCRS.getTitleCustomerRegistrationSuccessfully().contains("Customer Registered Successfully!!!"));
		CustomerIDFromAdd = objCRS.getCustomerId();
		//return CustomerIDFromAdd;
	}

//	public void createNewValidRandomCustomer() {
//		objAddNC.insertCustomerName(RandomStringUtils.randomAlphabetic(10));
//		objAddNC.selectFemaleGender();
//		objAddNC.insertDoB("11111999");
//		objAddNC.insertAddress(RandomStringUtils.randomAlphanumeric(10));
//		objAddNC.insertCity(RandomStringUtils.randomAlphabetic(10));
//		objAddNC.insertState(RandomStringUtils.randomAlphabetic(10));
//		objAddNC.insertPin(RandomStringUtils.randomNumeric(6));
//		objAddNC.insertTelephone(RandomStringUtils.randomNumeric(10));
//		objAddNC.insertEmail(RandomStringUtils.randomAlphanumeric(10)+"@"+RandomStringUtils.randomAlphanumeric(6)+".com");
//		objAddNC.insertPassword("1234");
//		objAddNC.submitForm();
//	}

//	@AfterClass
//	public void cleanUpDeleteUser(){
//		objHomePage.goToDeleteCustomer();
//		objDeleteCustomerPage.insertCustomerId(CustomerIDFromAdd);
//		objDeleteCustomerPage.clickOnSubmit();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//
//		Alert alert2 = driver.switchTo().alert();
//		String deleteConfirmationText = alert2.getText();
//		Assert.assertEquals(deleteConfirmationText,"Customer deleted Successfully");
//		alert.accept();
//	}

//	@Test
//	public void returnToHomePage(){
//		objCRS.clickContinueBtn();
//	}

	@AfterClass
	public void cleanUp(){
		driver.close();
	}



}
