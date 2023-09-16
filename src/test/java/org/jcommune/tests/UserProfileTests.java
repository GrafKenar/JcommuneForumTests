package org.jcommune.tests;

import org.jcommune.utils.TestDataGeneration;
import org.jcommune.pages.MainPage;
import org.jcommune.tests.base.BaseTestLogged;
import org.junit.jupiter.api.Test;

public class UserProfileTests extends BaseTestLogged {
    @Test
    void changeSignatureOfAUser(){
        MainPage mainPage = new MainPage(driver);
        TestDataGeneration generated = new TestDataGeneration();

        mainPage.enterTheUserProfile()
                .changeUserSignature(generated.USER_SIGNATURE)
                .checkThatSignatureIsChanged(generated.USER_SIGNATURE);
    }
}
