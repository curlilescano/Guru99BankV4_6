package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositSuccessfulPage extends BasePage {

    public DepositSuccessfulPage(WebDriver driver) {
        super(driver);
    }

    By depositSuccessfulTitle = By.className("heading3");
    By transactionId = By.xpath("//tr[td[contains(text(),'Transaction ID')]]/td[2]");
    By accountNo = By.xpath("//tr[td[contains(text(),'Account No')]]/td[2]");
    By amountCredited = By.xpath("//tr[td[contains(text(),'Amount Credited')]]/td[2]");
    By amountDebited = By.xpath("//tr[td[contains(text(),'Amount Debited')]]/td[2]");
    By currentBalance = By.xpath("//tr[td[contains(text(),'Current Balance')]]/td[2]");

    public String getDepositSuccessfulTitle () {
        return driver.findElement(depositSuccessfulTitle).getText();
    }
    public String getAccountNo () {
        return driver.findElement(accountNo).getText();
    }
    public String getAmountCredited () {
        return driver.findElement(amountCredited).getText();
    }
    public String getAmountDebited() {
        return driver.findElement(amountDebited).getText();
    }
    public String getCurrentBalance() {
        return driver.findElement(currentBalance).getText();
    }

}
