package org.jcommune.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userName")
    WebElement userNameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="signin-submit-button")
    WebElement signInButton;

    @FindBy(className = "help-inline")
    WebElement errorLoginMessage;

    public MainPage login(String login, String password) {
        userNameField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();

        return new MainPage(driver);
    }

    public LoginPage loginWithInvalidCredentials(String login, String password) {
        userNameField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();

        return this;
    }

    public LoginPage checkThatLoginWithInvalidCredentialsFailed(){
        Assert.assertEquals("Неверное имя пользователя или пароль", wait(errorLoginMessage, 3).getText());

        return this;
    }
}
