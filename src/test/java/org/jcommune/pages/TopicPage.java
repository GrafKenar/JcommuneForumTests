package org.jcommune.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

import java.util.List;

import static org.jcommune.utils.AdditionalMethods.isElementInvisible;

public class TopicPage extends BasePage {
    public TopicPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".word-wrap")
    List<WebElement> topicPosts;

    @FindBy(css = "#branch-header>h1>a")
    WebElement topicHeader;

    @FindBy(id = "postBody")
    WebElement postBodyInput;

    @FindBy(id = "post")
    WebElement addPostButton;

    public TopicPage checkThatTopicIsCorrect(String topicName, String topicBody){
        Assert.assertEquals(topicHeader.getText(), topicName);
        Assert.assertEquals(topicPosts.get(0).getText(), topicBody);

        return this;
    }

    public TopicPage addPostToTopic(String postBody){
        postBodyInput.sendKeys(postBody);
        addPostButton.click();

        return this;
    }

    public TopicPage checkThatPostIsAdded(String postBody){
        Assert.assertTrue(topicPosts.stream().anyMatch(x -> x.getText().contains(postBody)));

        return this;
    }

    public TopicPage checkThatThereIsNoAddNewPostForm(){
        Assert.assertTrue(isElementInvisible(addPostButton));

        return this;
    }
}
