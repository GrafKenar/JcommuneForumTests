package org.jcommune.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

import java.util.List;

import static org.jcommune.utils.AdditionalMethods.isTextFromFirstElementEqualsValue;

public class PrivateMessagesPage extends BasePage {
    public PrivateMessagesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Новое сообщение')]")
    WebElement newMessageButton;

    @FindBy(css = ".pm_user_to_from>a")
    List<WebElement> recipientsLinks;

    @FindBy(css = " td:nth-child(odd) > a")
    List<WebElement> messagesLinks;

    public MessageCreatingPage openMessageCreationPage(){
        newMessageButton.click();

        return new MessageCreatingPage(driver);
    }

    public PrivateMessagesPage checkThatMessageWasSent(String recipientName, String messageTitle){
        Assert.assertTrue(isTextFromFirstElementEqualsValue(recipientsLinks, recipientName) &&
                isTextFromFirstElementEqualsValue(messagesLinks, messageTitle));

        return this;
    }
}
