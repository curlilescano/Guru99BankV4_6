package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framework.BasePage;

public class HomePage extends BasePage 	{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	By btnManagerHome = By.partialLinkText("Manager");
	By btnNewCustomer = By.partialLinkText("New Customer");
	By editCustomerBtn = By.partialLinkText("Edit Customer");
	By deleteCustomerLink = By.partialLinkText("Delete Customer");
	public By managerTitleText = By.xpath("//tr[@class='heading3']");
	By welcomeText = By.xpath("//marquee[@class='heading3']");
	By newAccountLink = By.partialLinkText("New Account");
	By editAccountLink = By.partialLinkText("Edit Account");
	By deleteAccountLink = By.partialLinkText("Delete Account");
	By depositLink = By.partialLinkText("Deposit");
	By withdrawLink = By.partialLinkText("Withdrawal");



	
	//click on New customer button
	public  void goToAddNewCustomer() {
		driver.findElement(btnNewCustomer).click();
	}
	public void goToEditCustomer() {
		driver.findElement(editCustomerBtn).click();
	}
	public void goToDeleteCustomer () {driver.findElement(deleteCustomerLink).click();	}
	public void goToNewAccount() {driver.findElement(newAccountLink).click();}
	public void goToEditAccount() {driver.findElement(editAccountLink).click();}
	public void goToDeleteAccount() {driver.findElement(deleteAccountLink).click();}
	public void goToDeposit() {driver.findElement(depositLink).click();}
	public void goToWithdraw() {driver.findElement(withdrawLink).click();}
	public String getHomePageDashboardUserName () {return driver.findElement(managerTitleText).getText();}
	public String getWelcomeText () { return driver.findElement(welcomeText).getText();}
	
}
