package tests;

import Framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountRegistrationSuccessfullyPage;
import pages.AddNewCustomerPage;
import pages.CustomerRegistrationSuccessfullyPage;
import pages.DepositPage;
import pages.DepositSuccessfulPage;
import pages.EditAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;

public class DepositTest extends BaseTest {

    LoginPage objLoginPage;
    HomePage objHomePage;
    AddNewCustomerPage objAddNC;
    AddNewCustomerTest objANCT;
    NewAccountPage objNewAccountPage;
    CustomerRegistrationSuccessfullyPage objCRS;
    AccountRegistrationSuccessfullyPage objARSP;
    String CustomerIDFromAdd;
    String AccountIDFromAdd;
    String amountCredited = "800";
    DepositPage objDepositPage;
    DepositSuccessfulPage objDSP;

    @BeforeClass
    public void setupDeposit () {
        objLoginPage = new LoginPage(getDriver());
        objAddNC = new AddNewCustomerPage(getDriver());
        objANCT = new AddNewCustomerTest();
        objNewAccountPage = new NewAccountPage(getDriver());
        objHomePage = new HomePage(getDriver());
        objCRS = new CustomerRegistrationSuccessfullyPage(getDriver());
        objARSP = new AccountRegistrationSuccessfullyPage(getDriver());
        objDepositPage = new DepositPage(getDriver());
        objDSP = new DepositSuccessfulPage(getDriver());
    }

    @Test
    public void makeDeposit () {
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
        objHomePage.goToDeposit();
        objDepositPage.insertAccNo(AccountIDFromAdd);
        objDepositPage.insertAmount(amountCredited);
        objDepositPage.insertDescription("Making a d");
        objDepositPage.submitDeposit();
        //check title displayed correctly
        Assert.assertEquals(objDSP.getDepositSuccessfulTitle() , ("Transaction details of Deposit for Account "+AccountIDFromAdd));
        Assert.assertEquals(objDSP.getAmountCredited() , amountCredited);

    }
}
