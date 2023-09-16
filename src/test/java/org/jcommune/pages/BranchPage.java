package org.jcommune.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

import java.util.List;

import static org.jcommune.utils.AdditionalMethods.areElementsNotPresent;
import static org.jcommune.utils.AdditionalMethods.clickOnFirstElementInCollection;

public class BranchPage extends BasePage {
    public BranchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Начать Обсуждение')]")
    List<WebElement> startTopicButtons;

    public TopicCreationPage goToTopicCreationPage(){
        clickOnFirstElementInCollection(startTopicButtons);

        return new TopicCreationPage(driver);
    }

    public BranchPage checkThatThereAreNoCreateTopicButtons(){
        Assert.assertTrue(areElementsNotPresent(startTopicButtons));

        return this;
    }
}
