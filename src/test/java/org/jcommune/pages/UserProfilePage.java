package org.jcommune.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.jcommune.pages.base.BasePage;

public class UserProfilePage extends BasePage {
    public UserProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userProfileDto.signature")
    WebElement signatureInput;

    @FindBy(id = "saveChanges")
    WebElement saveChangesButton;

    public UserProfilePage changeUserSignature(String newSignature){
        signatureInput.clear();
        signatureInput.sendKeys(newSignature);
        saveChangesButton.click();

        return this;
    }

    public UserProfilePage checkThatSignatureIsChanged(String newSignature){
        Assert.assertEquals(newSignature, signatureInput.getText());

        return this;
    }
}
