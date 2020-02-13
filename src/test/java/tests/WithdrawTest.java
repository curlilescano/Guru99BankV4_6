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
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.WithdrawPage;

public class WithdrawTest extends BaseTest {

    LoginPage objLoginPage;
    HomePage objHomePage;
    AddNewCustomerPage objAddNC;
    AddNewCustomerTest objANCT;
    NewAccountPage objNewAccountPage;
    CustomerRegistrationSuccessfullyPage objCRS;
    AccountRegistrationSuccessfullyPage objARSP;
    DepositPage objDepositPage;
    DepositSuccessfulPage objDSP;
    WithdrawPage objWithdrawPage;

    String CustomerIDFromAdd;
    String AccountIDFromAdd;
    String amountInitialDeposit = "650";
    String amountCredited = "800";
    String amountWithdrew = "300";


    @BeforeClass
    public void setupWithdrawal () {
        objLoginPage = new LoginPage(getDriver());
        objAddNC = new AddNewCustomerPage(getDriver());
        objANCT = new AddNewCustomerTest();
        objNewAccountPage = new NewAccountPage(getDriver());
        objHomePage = new HomePage(getDriver());
        objCRS = new CustomerRegistrationSuccessfullyPage(getDriver());
        objARSP = new AccountRegistrationSuccessfullyPage(getDriver());
        objDepositPage = new DepositPage(getDriver());
        objDSP = new DepositSuccessfulPage(getDriver());
        objWithdrawPage = new WithdrawPage(getDriver());
    }

    @Test
    public void withdrawFromAccount () {
        objLoginPage.goToPageAndLoginWithValidUser();
        objHomePage.goToAddNewCustomer();
        objAddNC.createNewValidRandomCustomer();
        CustomerIDFromAdd = objCRS.getCustomerId();
        objHomePage.goToNewAccount();
        objNewAccountPage.insertCustomer(CustomerIDFromAdd);
        objNewAccountPage.selectAccountTypeCurrent();
        objNewAccountPage.insertInitialDeposit(amountInitialDeposit);
        objNewAccountPage.clickOnSubmitBtn();
        AccountIDFromAdd = objARSP.getAccountId();
        objHomePage.goToDeposit();
        objDepositPage.insertAccNo(AccountIDFromAdd);
        objDepositPage.insertAmount(amountCredited);
        objDepositPage.insertDescription("Making a d");
        objDepositPage.submitDeposit();
        objHomePage.goToWithdraw();
        objWithdrawPage.insertAccNo(AccountIDFromAdd);
        objWithdrawPage.insertAmount(amountWithdrew);
        objWithdrawPage.insertDescription("Withd 300");
        objWithdrawPage.submitWithdrawal();

        //check title displayed correctly
        Assert.assertEquals(objDSP.getDepositSuccessfulTitle() , ("Transaction details of Withdrawal for Account "+AccountIDFromAdd));
        Assert.assertEquals(objDSP.getAmountDebited() , amountWithdrew);
        //amounts convertions to ints
        int iInitialDeposit = Integer.parseInt(amountInitialDeposit);
        int iCredited = Integer.parseInt(amountCredited);
        int iDebited = Integer.parseInt(amountWithdrew);
        int iCurrentBalance = Integer.parseInt(objDSP.getCurrentBalance());

        Assert.assertEquals(iCurrentBalance , (iInitialDeposit + iCredited - iDebited));

    }

}
