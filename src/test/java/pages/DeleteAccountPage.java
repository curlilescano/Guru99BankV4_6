package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage extends BasePage {

    public DeleteAccountPage (WebDriver driver) {
        super(driver);
    }

    By accountNumber = By.name("accountno");
    By submitBtn = By.name("AccSubmit");

    public void insertAccountNumber (String accNo) {
        writeText(accountNumber,accNo);
    }
    public void submit (){
        click(submitBtn);
    }

}
