package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountRegistrationSuccessfullyPage extends BasePage {

    public AccountRegistrationSuccessfullyPage(WebDriver driver) {
        super(driver);
    }

    public By accountRegistrationSuccessfullyTitle = By.className("heading3");
    By customerIdField = By.xpath("//tr[td[contains(text(),'Customer ID')]]/td[2]");
    By accountIdField = By.xpath("//tr[td[contains(text(),'Account ID')]]/td[2]");
    By continueBtn = By.partialLinkText("Continue");
    By homeBtn = By.linkText("Home");

    public  String getTitleCustomerRegistrationSuccessfully () {
        return driver.findElement(accountRegistrationSuccessfullyTitle).getText();
    }

    public String getCustomerId () {
        return driver.findElement(customerIdField).getText();
    }
    public String getAccountId () { return driver.findElement(accountIdField).getText(); }
    public void clickContinueBtn () {driver.findElement(homeBtn).click();}

}