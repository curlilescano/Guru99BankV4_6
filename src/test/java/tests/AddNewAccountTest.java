package tests;

import Framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountRegistrationSuccessfullyPage;
import pages.AddNewCustomerPage;
import pages.CustomerRegistrationSuccessfullyPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;

public class AddNewAccountTest extends BaseTest {

    LoginPage objLoginPage;
    HomePage objHomePage;
    AddNewCustomerPage objAddNC;
    AddNewCustomerTest objANCT;
    NewAccountPage objNewAccountPage;
    CustomerRegistrationSuccessfullyPage objCRS;
    AccountRegistrationSuccessfullyPage objARSP;
    String CustomerIDFromAdd;
    String AccountIDFromAdd;


    @BeforeClass
    public void setupAddNewAccount(){
        objLoginPage = new LoginPage(getDriver());
        objAddNC = new AddNewCustomerPage(getDriver());
        objANCT = new AddNewCustomerTest();
        objNewAccountPage = new NewAccountPage(getDriver());
        objHomePage = new HomePage(getDriver());
        objCRS = new CustomerRegistrationSuccessfullyPage(getDriver());
        objARSP = new AccountRegistrationSuccessfullyPage(getDriver());
    }

    @Test
    public void addNewAccount(){
        objLoginPage.goToPageAndLoginWithValidUser();
        objHomePage.goToAddNewCustomer();
        objAddNC.createNewValidRandomCustomer();
        CustomerIDFromAdd = objCRS.getCustomerId();
        objHomePage.goToNewAccount();
        objNewAccountPage.insertCustomer(CustomerIDFromAdd);
        objNewAccountPage.selectAccountTypeCurrent();
        objNewAccountPage.insertInitialDeposit("650");
        objNewAccountPage.clickOnSubmitBtn();

        Assert.assertTrue(objARSP.getTitleCustomerRegistrationSuccessfully().contains("Account Generated Successfully!!!"));
        AccountIDFromAdd = objARSP.getAccountId();



    }

}
