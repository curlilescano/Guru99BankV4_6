package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage extends BasePage {

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    By accountNumber = By.name("accountno");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void insertAccNo (String accNo) {
        driver.findElement(accountNumber).sendKeys(accNo);
    }
    public void insertAmount (String amo) {
        driver.findElement(amount).sendKeys(amo);
    }
    public void insertDescription (String desc) {
        driver.findElement(description).sendKeys(desc);
    }
    public void submitDeposit () {
        driver.findElement(submitBtn).click();

    }
}
