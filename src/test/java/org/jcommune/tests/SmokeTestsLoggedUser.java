package org.jcommune.tests;

import org.jcommune.utils.TestDataGeneration;
import org.jcommune.pages.MainPage;
import org.jcommune.pages.TopicPage;
import org.jcommune.tests.base.BaseTestLogged;
import org.junit.jupiter.api.Test;

import static org.jcommune.utils.Constants.*;


public class SmokeTestsLoggedUser extends BaseTestLogged {

    @Test
    void creatingTopic() {
        MainPage mainPage = new MainPage(super.driver);
        TestDataGeneration generated = new TestDataGeneration();
        mainPage.goToBranchPage(TEST_BRANCH)
                .goToTopicCreationPage()
                .createNewTopic(generated.TOPIC_NAME, generated.POST_BODY)
                .checkThatTopicIsCorrect(generated.TOPIC_NAME, generated.POST_BODY);
    }

    @Test
    void searchingTopic(){
        MainPage mainPage = new MainPage(super.driver);
        mainPage.searchByTopicName(TEST_TOPIC_NAME)
                .checkThatTopicIsShownOnThePage(TEST_TOPIC_NAME);
    }

    @Test
    void addingPostToTopic(){
        driver.get(BASE_URL+TEST_TOPIC);
        TopicPage topicPage = new TopicPage(driver);
        TestDataGeneration generated = new TestDataGeneration();
        topicPage.addPostToTopic(generated.POST_BODY)
                .checkThatPostIsAdded(generated.POST_BODY);
    }
}
