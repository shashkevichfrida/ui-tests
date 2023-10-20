package org.example.pages;

import org.example.driverManager.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finish;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancel;

    public CheckoutOverviewPage(){
        PageFactory.initElements(driver, this);
    }

    public CheckoutCompletePage clickFinish(){
        finish.click();
        return new CheckoutCompletePage();
    }

}
