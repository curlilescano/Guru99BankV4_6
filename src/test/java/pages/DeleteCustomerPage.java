package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCustomerPage extends BasePage {

    public DeleteCustomerPage(WebDriver driver){
        super(driver);

    }

    By CustomerIdField = By.name("cusid");
    By SubmitBtn = By.name("AccSubmit");

    public void insertCustomerId (String c) {
        driver.findElement(CustomerIdField).sendKeys(c);
    }

    public void clickOnSubmit () {
        driver.findElement(SubmitBtn).click();
    }

}
