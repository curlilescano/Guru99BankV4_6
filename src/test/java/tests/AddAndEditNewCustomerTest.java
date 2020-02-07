package tests;

import Framework.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddNewCustomerPage;
import pages.CustomerRegistrationSuccessfullyPage;
import pages.DeleteCustomerPage;
import pages.EditCustomerPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Random;

public class AddAndEditNewCustomerTest extends BaseTest {

    AddNewCustomerPage objAddNC;
    LoginPage loginPage;
    HomePage objHomePage;
    CustomerRegistrationSuccessfullyPage objCRS;
    EditCustomerPage objEditCustomerPage;


    public static String CustomerIDFromAdd;

//	ArrayList <String> propertiesFromConfig = PropertiesFile2.getProperties();


//	public AddNewCustomer (WebDriver driver) {
//		this.driver = driver;
//	}

    @BeforeClass
    public void setupAddAndEditCustomer() {
        objHomePage = new HomePage(getDriver());
        objAddNC = new AddNewCustomerPage(getDriver());
        loginPage = new LoginPage(getDriver());
        objCRS = new CustomerRegistrationSuccessfullyPage(getDriver());
        objEditCustomerPage = new EditCustomerPage(getDriver());


    }


    @Test(priority = -2)
    public void createNewCustomer() {
        loginPage.goToPageAndLoginWithValidUser();
        objHomePage.goToAddNewCustomer();
        objAddNC.insertCustomerName(RandomStringUtils.randomAlphabetic(8));
        objAddNC.selectFemaleGender();
        objAddNC.insertDoB("11111999");
        objAddNC.insertAddress("Las heras 88");
        objAddNC.insertCity("Quilmes");
        objAddNC.insertState("Bernal");
        objAddNC.insertPin("123456");
        objAddNC.insertTelephone("123123123123123123");
        objAddNC.insertEmail(RandomStringUtils.randomAlphanumeric(10)+"@"+RandomStringUtils.randomAlphanumeric(6)+".com");
        objAddNC.insertPassword("1234");
        objAddNC.submitForm();

        Assert.assertTrue(objCRS.getTitleCustomerRegistrationSuccessfully().contains("Customer Registered Successfully!!!"));
        CustomerIDFromAdd = objCRS.getCustomerId();
    }

    @Test(priority = 1)
    public void editCustomer() {
//        loginPage.goToPageAndLoginWithValidUser();
        objHomePage.goToEditCustomer();
        objEditCustomerPage.insertCustomerId(CustomerIDFromAdd);
        objEditCustomerPage.clickOnSubmit();
//      objAddNC.insertCustomerName(RandomStringUtils.randomAlphabetic(10));
//      objAddNC.selectFemaleGender();
        //objAddNC.insertDoB("11111999");
        objEditCustomerPage.insertAddress(RandomStringUtils.randomAlphanumeric(10));
        objEditCustomerPage.insertCity(RandomStringUtils.randomAlphabetic(10));
        objEditCustomerPage.insertState(RandomStringUtils.randomAlphabetic(10));
        objEditCustomerPage.insertPin(RandomStringUtils.randomNumeric(6));
        objEditCustomerPage.insertTelephone(RandomStringUtils.randomNumeric(10));
        objEditCustomerPage.insertEmail(RandomStringUtils.randomAlphanumeric(10)+"@"+RandomStringUtils.randomAlphanumeric(6)+".com");
        //objEditCustomerPage.insertPassword(RandomStringUtils.randomAlphanumeric(4));
        objEditCustomerPage.submitForm();
        //Assert 1, old school
        Assert.assertTrue(objCRS.getTitleCustomerRegistrationSuccessfully().contains("Customer details updated Successfully!!!"));
        //AsserrEqualss from the BasePage, making the By object public
        objCRS.assertEqualss(objCRS.customerRegistrationSuccessfullyTitle,"Customer details updated Successfully!!!");


    }

//    @AfterClass
//    public void cleanUp() {
//        objHomePage.goToDeleteCustomer();
//        objDeleteCustomerPage.insertCustomerId(CustomerIDFromAdd);
//        objDeleteCustomerPage.clickOnSubmit();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//
//        Alert alert2 = driver.switchTo().alert();
//        String deleteConfirmationText = alert2.getText();
//        Assert.assertEquals(deleteConfirmationText, "Customer deleted Successfully");
//        alert.accept();
//    }

}