package ui_tests;

import org.example.driverManager.DriverManager;
import org.example.pages.CheckoutCompletePage;
import org.example.pages.LoginPage;
import org.example.readProperties.ConfigProvider;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class BaseTest extends DriverManager {
    /**
     * Проверка на успешность заказа
     * 1. Аунтификация
     * 2. Добавление всех товаров в корзину
     * 3. Ввод персональной информации для офомления заказа
     * 4. Проверка на успешно оформленный заказ
     */
    @Test
    public void makeOrder(){
        CheckoutCompletePage checkoutCompletePage = new LoginPage()
                .auth(ConfigProvider.LOGIN_STANDARD_USER, ConfigProvider.PASSWORD_STANDARD_USER)
                .addAllToBasket()
                .checkout()
                .inputPersonalInformation("Name", "LastName", "postalCode")
                .clickFinish();

        Assert.assertEquals(ConfigProvider.SUCCESS_ORDER_MESSAGE, checkoutCompletePage.getCompleteHeader());
    }

    /**
     * Неправильный ввод логина/пароля
     */
    @Test
    public void wrongAuth(){
        String wrongMessage = new LoginPage()
                .wrongAuthMessage("wrongLogin", ConfigProvider.PASSWORD_STANDARD_USER);
        Assert.assertEquals(ConfigProvider.WRONG_AUTH_MESSAGE, wrongMessage);
    }

    /**
     * Проверка выхода из аккаунта
     */
    @Test
    public void checkLogout(){
        String loginMessage = new LoginPage()
                .auth(ConfigProvider.LOGIN_STANDARD_USER, ConfigProvider.PASSWORD_STANDARD_USER)
                .logout()
                .getLoginMessage();

        Assert.assertEquals("Login", loginMessage);
    }

    /**
     * Проверка на наличие добавленных товаров в корзине
     * 1. Аунтификация
     * 2. Добавление всех товаров в корзину
     * 3. Проверка, что в эту корзину все добавилось
     */
    @Test
    public void checkBasket(){
        Integer basketSize = new LoginPage()
                .auth(ConfigProvider.LOGIN_STANDARD_USER, ConfigProvider.PASSWORD_STANDARD_USER)
                .addAllToBasket()
                .getSizeOfCartItems();

        Assert.assertEquals(Optional.of(6).get(), basketSize);
    }

    /**
     * Проверка на наличие добавленных товаров в корзине после повторной аунтификации
     * 1. Аунтификация
     * 2. Добавление всех товаров в корзину
     * 3. Выход пользователя
     * 4. Аунтификация
     * 5. Проверка корзины, что в ней остались товары, которые были добавлены до выхода из аккаунта
     */
    @Test
    public void checkBasketAfterLogout(){
        Integer basketSize = new LoginPage()
                .auth(ConfigProvider.LOGIN_STANDARD_USER, ConfigProvider.PASSWORD_STANDARD_USER)
                .addAllToBasket()
                .continueShopping()
                .logout()
                .auth(ConfigProvider.LOGIN_STANDARD_USER, ConfigProvider.PASSWORD_STANDARD_USER)
                .openBasket()
                .getSizeOfCartItems();

        Assert.assertEquals(Optional.of(6).get(), basketSize);
    }

    /**
     * Проверка заблокированного пользователя на попытку входа
     */
    @Test
    public void lockedOutUserAuth(){
        String wrongMessage = new LoginPage()
                .wrongAuthMessage(ConfigProvider.LOGIN_LOCKED_OUT_USER, ConfigProvider.PASSWORD_LOCKED_OUT_USER);
        Assert.assertEquals(ConfigProvider.LOCKED_OUT_USER_AUTH_MESSAGE, wrongMessage);
    }
}
