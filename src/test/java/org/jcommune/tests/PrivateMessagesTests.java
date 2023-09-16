package org.jcommune.tests;

import org.jcommune.utils.TestDataGeneration;
import org.jcommune.pages.MainPage;
import org.jcommune.tests.base.BaseTestLogged;
import org.junit.jupiter.api.Test;

import static org.jcommune.utils.Constants.SIDE_USER_NAME;

public class PrivateMessagesTests extends BaseTestLogged {
    @Test
    void sendingPrivateMessageToAnotherUser() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        TestDataGeneration generated = new TestDataGeneration();

        mainPage.enterPrivateMessagesPage()
                .openMessageCreationPage()
                .sendNewMessage(SIDE_USER_NAME, generated.TOPIC_NAME, generated.POST_BODY)
                .checkThatMessageWasSent(SIDE_USER_NAME, generated.TOPIC_NAME);
    }
}
