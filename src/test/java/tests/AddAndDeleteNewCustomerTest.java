package tests;

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

public class AddAndDeleteNewCustomerTest extends BaseTest {

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
    public void setup() {
        objHomePage = new HomePage(getDriver());
        objAddNC = new AddNewCustomerPage(getDriver());
        loginPage = new LoginPage(getDriver());
        objCRS = new CustomerRegistrationSuccessfullyPage(getDriver());
        objEditCustomerPage = new EditCustomerPage(getDriver());
        objDeleteCustomerPage = new DeleteCustomerPage(getDriver());

    }


    @Test
    public void createNewCustomer() {
        loginPage.goToPageAndLoginWithValidUser();
        objHomePage.goToAddNewCustomer();
        objAddNC.insertCustomerName("curli");
        objAddNC.selectFemaleGender();
        objAddNC.insertDoB("11111999");
        objAddNC.insertAddress("Las heras 88");
        objAddNC.insertCity("Quilmes");
        objAddNC.insertState("Bernal");
        objAddNC.insertPin("123456");
        objAddNC.insertTelephone("123123123123123123");
        objAddNC.insertEmail("aawaasdaal@asda.com");
        objAddNC.insertPassword("1234");
        objAddNC.submitForm();

        Assert.assertTrue(objCRS.getTitleCustomerRegistrationSuccessfully().contains("Customer Registered Successfully!!!"));
        CustomerIDFromAdd = objCRS.getCustomerId();
    }

    @Test (priority = 1)
    public void cleanUpDeleteCustomer(){
        loginPage.goToPageAndLoginWithValidUser();
        objHomePage.goToDeleteCustomer();
        objDeleteCustomerPage.insertCustomerId(CustomerIDFromAdd);
        objDeleteCustomerPage.clickOnSubmit();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Alert alert2 = driver.switchTo().alert();
        String deleteConfirmationText = alert2.getText();
        Assert.assertEquals(deleteConfirmationText,"Customer deleted Successfully");
        alert.accept();
    }

//	@Test
//	public void returnToHomePage(){
//		objCRS.clickContinueBtn();
//	}



}
