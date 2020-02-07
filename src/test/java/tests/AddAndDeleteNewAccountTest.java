package tests;

import Framework.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountRegistrationSuccessfullyPage;
import pages.AddNewCustomerPage;
import pages.CustomerRegistrationSuccessfullyPage;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;

public class AddAndDeleteNewAccountTest extends BaseTest {

    LoginPage objLoginPage;
    HomePage objHomePage;
    AddNewCustomerPage objAddNC;
    AddNewCustomerTest objANCT;
    NewAccountPage objNewAccountPage;
    CustomerRegistrationSuccessfullyPage objCRS;
    AccountRegistrationSuccessfullyPage objARSP;
    DeleteAccountPage objDeleteAccount;
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
        objDeleteAccount = new DeleteAccountPage(getDriver());
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
    public void deleteAccount(){
        objHomePage.goToDeleteAccount();
        objDeleteAccount.insertAccountNumber(AccountIDFromAdd);
        objDeleteAccount.submit();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Alert alert2 = driver.switchTo().alert();
        String deleteConfirmationText = alert2.getText();
        Assert.assertEquals(deleteConfirmationText,"Account Deleted Sucessfully");
        alert.accept();
    }

}
