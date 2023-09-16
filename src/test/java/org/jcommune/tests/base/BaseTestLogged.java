package org.jcommune.tests.base;

import org.jcommune.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;

import static org.jcommune.utils.Constants.*;

public class BaseTestLogged extends BaseTest{
    @BeforeEach
    public void setUpLogin(){
        MainPage mainPage = new MainPage(super.driver);
        mainPage.enterLoginModal()
                .login(LOGIN, PASSWORD)
                .checkThatUserIsLogged(LOGIN);
    }
}