package pages;

import Framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AddNewCustomerTest;

public class EditCustomerPage extends BasePage {

    public EditCustomerPage (WebDriver driver){
        super(driver);

    }

    By CustomerIdField = By.name("cusid");
    By SubmitBtn = By.name("AccSubmit");

    By addressTextbox = By.name("addr");
    By cityTextbox = By.name("city");
    By stateTextbox = By.name("state");
    By pinTextbox = By.name("pinno");
    By telephoneNumberTextbox = By.name("telephoneno");
    By emailTextbox = By.name("emailid");
    By passwordTextbox = By.name("password");
    By submitBtn2 = By.xpath("//input[@name='sub']");

    public void insertCustomerId (String c) { driver.findElement(CustomerIdField).sendKeys(c); }

    public void clickOnSubmit () {
        driver.findElement(SubmitBtn).click();
    }


    public void insertAddress(String address) {
        driver.findElement(addressTextbox).clear();
        driver.findElement(addressTextbox).sendKeys(address);
    }

    public void insertCity(String city) {
        driver.findElement(cityTextbox).clear();
        driver.findElement(cityTextbox).sendKeys(city);
//		wait.until(ready -> driver.findElement(cityTextbox));
    }

    public void insertState(String state) {
        driver.findElement(stateTextbox).clear();
        driver.findElement(stateTextbox).sendKeys(state);
    }

    public void insertPin(String pin) {
        driver.findElement(pinTextbox).clear();
        driver.findElement(pinTextbox).sendKeys(pin);
    }

    public void insertTelephone(String telephoneasd) {
        driver.findElement(telephoneNumberTextbox).clear();
        driver.findElement(telephoneNumberTextbox).sendKeys(telephoneasd);
    }

    public void insertEmail(String email) {
        driver.findElement(emailTextbox).clear();
        driver.findElement(emailTextbox).sendKeys(email);
    }

    public void insertPassword(String password) {
        driver.findElement(passwordTextbox).clear();
        driver.findElement(passwordTextbox).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(submitBtn2).click();
    }

}
