package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends BasePage {

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }


    public By customerIDTextbox = By.name("cusid");
    public By accountTypeSelect = By.name("selaccount");
    public By initialDepositTextbox = By.name("inideposit");
    public By submitBtn = By.name("button2");



//    Select drpAccountType = new Select(driver.findElement(accountTypeSelect));

    public void insertCustomer(String customerId){
        writeText(customerIDTextbox,customerId);
    }
    public void selectAccountTypeSavings(){
        Select drpAccountType = new Select(driver.findElement(accountTypeSelect));
        drpAccountType.selectByVisibleText("Savings");
    }
    public void selectAccountTypeCurrent(){
        Select drpAccountType = new Select(driver.findElement(accountTypeSelect));
        drpAccountType.selectByVisibleText("Current");
    }
    public void insertInitialDeposit (String i) {
        writeText(initialDepositTextbox,i);
    }
    public void clickOnSubmitBtn(){
        click(submitBtn);
    }
}
