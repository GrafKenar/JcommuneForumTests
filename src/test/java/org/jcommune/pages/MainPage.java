package org.jcommune.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="signin")
    WebElement signInButton;

    @FindBy(id="user-dropdown-menu-link")
    WebElement userDropdownLink;

    @FindBy(className = "branch-title")
    List<WebElement> branchesLinks;

    @FindBy(id = "searchText")
    WebElement searchInput;

    @FindBy(id = "user-dropdown-menu-link")
    WebElement userMenuDropdownButton;

    @FindBy(id = "user-menu-profile")
    WebElement userProfileButton;

    @FindBy(id = "user-menu-private-messages")
    WebElement privateMessagesButton;

    public LoginPage enterLoginModal(){
        wait(signInButton, 10).click();

        return new LoginPage(driver);
    }

    public BranchPage goToBranchPage(String branch) {
        WebElement branchLink = branchesLinks.stream().filter(x -> x.getText().contains(branch)).findFirst().get();
        branchLink.click();

        return new BranchPage(driver);
    }

    public MainPage checkThatUserIsLogged(String login) {
        Assert.assertTrue(wait(userDropdownLink).getText().contains(login));

        return this;
    }

    public SearchResultsPage searchByTopicName (String topicName){
        searchInput.sendKeys(topicName);
        searchInput.submit();

        return new SearchResultsPage(driver);
    }

    public UserProfilePage enterTheUserProfile (){
        userMenuDropdownButton.click();
        userProfileButton.click();

        return new UserProfilePage(driver);
    }

    public PrivateMessagesPage enterPrivateMessagesPage(){
        userMenuDropdownButton.click();
        privateMessagesButton.click();

        return new PrivateMessagesPage(driver);
    }


}
