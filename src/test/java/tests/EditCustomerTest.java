package tests;

import Framework.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddNewCustomerPage;
import pages.EditCustomerPage;
import pages.HomePage;
import pages.LoginPage;

public class EditCustomerTest extends BaseTest {
    EditCustomerPage objEditCustomerPage;
    HomePage objHomePage;
    AddNewCustomerTest objAddNewCustomer;
    LoginPage loginPage;
    String CustomerID;



    @BeforeTest
    public void setup() {
        loginPage = new LoginPage(getDriver());
        loginPage.goToPageAndLoginWithValidUser();
        objHomePage = new HomePage(getDriver());
        objEditCustomerPage = new EditCustomerPage(getDriver());
        CustomerID = "40306";
    }

    @Test
    public void insertCustomerIdInEditMenu () {
        objHomePage.goToEditCustomer();
        objEditCustomerPage.insertCustomerId(CustomerID);
        objEditCustomerPage.clickOnSubmit();

    }
}
