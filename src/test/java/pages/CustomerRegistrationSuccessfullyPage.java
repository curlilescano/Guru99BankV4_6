package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerRegistrationSuccessfullyPage extends BasePage {

    public CustomerRegistrationSuccessfullyPage(WebDriver driver) {
        super(driver);
    }

    public By customerRegistrationSuccessfullyTitle = By.className("heading3");
    By customerIdField = By.xpath("//tr[td[contains(text(),'Customer ID')]]/td[2]");
    By continueBtn = By.partialLinkText("Continue");
    By homeBtn = By.linkText("Home");

    public  String getTitleCustomerRegistrationSuccessfully () {
        return driver.findElement(customerRegistrationSuccessfullyTitle).getText();
    }

    public String getCustomerId () {
        return driver.findElement(customerIdField).getText();
    }

    public void clickContinueBtn () {driver.findElement(homeBtn).click();}

}