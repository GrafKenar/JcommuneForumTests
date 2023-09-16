package org.jcommune.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

public class TopicCreationPage extends BasePage {
    public TopicCreationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "subject")
    WebElement topicNameInput;

    @FindBy(id = "postBody")
    WebElement postBodyInput;

    @FindBy(id = "post")
    WebElement createTopicButton;

    public TopicPage createNewTopic (String topicName, String topicBody){
        topicNameInput.sendKeys(topicName);
        postBodyInput.sendKeys(topicBody);
        createTopicButton.click();

        return new TopicPage(driver);
    }
}
