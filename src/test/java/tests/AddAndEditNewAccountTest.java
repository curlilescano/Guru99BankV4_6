package tests;

import Framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountRegistrationSuccessfullyPage;
import pages.AddNewCustomerPage;
import pages.CustomerRegistrationSuccessfullyPage;
import pages.EditAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;

public class AddAndEditNewAccountTest extends BaseTest {

    LoginPage objLoginPage;
    HomePage objHomePage;
    AddNewCustomerPage objAddNC;
    AddNewCustomerTest objANCT;
    NewAccountPage objNewAccountPage;
    CustomerRegistrationSuccessfullyPage objCRS;
    AccountRegistrationSuccessfullyPage objARSP;
    EditAccountPage objEditAccountPage;
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
        objEditAccountPage = new EditAccountPage(getDriver());
    }

    @Test (priority = -2)
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

    @Test (priority = -1)
    public void editAccount () {
        objHomePage.goToEditAccount();
        objEditAccountPage.insertAccountNumber(AccountIDFromAdd);
        objEditAccountPage.clickOnSubmitBtn();
        objEditAccountPage.selectAccountTypeSavings();
        //objNewAccountPage.selectAccountTypeSavings();
        objEditAccountPage.clickOnSubmitBtn();

        Assert.assertTrue(objARSP.getTitleCustomerRegistrationSuccessfully().contains("Account details updated Successfully!!!"));
    }

}
