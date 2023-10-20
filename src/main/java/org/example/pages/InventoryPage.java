package org.example.pages;

import org.example.driverManager.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement buttonAddBackpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement buttonAddBike;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement buttonAddTShirt;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement buttonAddJacket;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement buttonAddAllTheThings;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement buttonAddOnesie;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement buttonMenu;

    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    private WebElement buttonCloseMenu;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement buttonLogout;

    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }

    public BasketPage addAllToBasket(){
        buttonAddBackpack.click();
        buttonAddBike.click();
        buttonAddTShirt.click();
        buttonAddJacket.click();
        buttonAddAllTheThings.click();
        buttonAddOnesie.click();
        shoppingCartLink.click();

        return new BasketPage();
    }

    public LoginPage logout(){
        buttonMenu.click();
        buttonLogout.click();

        return new LoginPage();
    }

    public BasketPage openBasket(){
        shoppingCartLink.click();

        return new BasketPage();
    }
}
