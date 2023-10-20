package org.example.pages;

import org.example.driverManager.BasePage;
import org.example.readProperties.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement password;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement wrongAuthMessage;

    public LoginPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public InventoryPage auth(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        buttonLogin.click();
        return new InventoryPage();
    }

    public String wrongAuthMessage(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        buttonLogin.click();
        return wrongAuthMessage.getText();
    }

    public String getLoginMessage(){
        return buttonLogin.getAttribute("value");
    }

}
