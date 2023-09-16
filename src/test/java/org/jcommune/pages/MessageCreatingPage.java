package org.jcommune.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

public class MessageCreatingPage extends BasePage {
    public MessageCreatingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "recipient")
    WebElement recipientInput;

    @FindBy(id = "title")
    WebElement titleInput;

    @FindBy(id = "postBody")
    WebElement postBodyInput;

    @FindBy(id = "post")
    WebElement sendMessageButton;

    public PrivateMessagesPage sendNewMessage(String recipient, String messageTitle, String postBody) throws InterruptedException {
        recipientInput.sendKeys(recipient);
        titleInput.sendKeys(messageTitle);
        postBodyInput.sendKeys(postBody);
        sendMessageButton.click();

        return new PrivateMessagesPage(driver);
    }

}
