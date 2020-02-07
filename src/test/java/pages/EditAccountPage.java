package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage extends BasePage {

    public EditAccountPage (WebDriver driver) {
        super(driver);
    }

    By accountNumber = By.name("accountno");
    By SubmitBtn = By.name("AccSubmit");
    By accountTypeSelect = By.name("a_type");

    public void insertAccountNumber (String accNo){
        //driver.findElement(accountNumber).sendKeys(accNo);
        writeText(accountNumber,accNo);
    }

    public void clickOnSubmitBtn (){
        click(SubmitBtn);
    }
    public void selectAccountTypeSavings(){
        Select drpAccountType = new Select(driver.findElement(accountTypeSelect));
        drpAccountType.selectByVisibleText("Savings");
    }
    public void selectAccountTypeCurrent(){
        Select drpAccountType = new Select(driver.findElement(accountTypeSelect));
        drpAccountType.selectByVisibleText("Current");
    }

}
