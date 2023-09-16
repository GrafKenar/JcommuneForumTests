package org.jcommune.tests;

import org.jcommune.pages.MainPage;
import org.jcommune.pages.TopicPage;
import org.jcommune.tests.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.jcommune.utils.Constants.*;


public class SmokeTestGuestUser extends BaseTest {

    @Test
    void searchingTopic(){
        MainPage mainPage = new MainPage(super.driver);
        mainPage.searchByTopicName(TEST_TOPIC_NAME)
                .checkThatTopicIsShownOnThePage(TEST_TOPIC_NAME);
    }

   @Test
    void GuestUserCantCreateTopic() {
       MainPage mainPage = new MainPage(super.driver);
       mainPage.goToBranchPage(TEST_BRANCH)
               .checkThatThereAreNoCreateTopicButtons();
   }

    @Test
    void GuestUserCantMakeNewPostsInATopic() {
        driver.get(BASE_URL+TEST_TOPIC);
        TopicPage topicPage = new TopicPage(driver);
        topicPage.checkThatThereIsNoAddNewPostForm();
    }
}
