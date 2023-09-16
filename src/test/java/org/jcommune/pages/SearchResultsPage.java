package org.jcommune.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

import java.util.List;

import static org.jcommune.utils.AdditionalMethods.isAnyElementHasSuchText;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "space-left-small-nf")
    List<WebElement> setOfTopicNames;

    public SearchResultsPage checkThatTopicIsShownOnThePage(String topicName){
        Assert.assertTrue(isAnyElementHasSuchText(setOfTopicNames, topicName));

        return this;
    }
}
