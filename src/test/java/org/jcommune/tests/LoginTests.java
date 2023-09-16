package org.jcommune.tests;

import org.jcommune.pages.MainPage;
import org.jcommune.tests.base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.jcommune.utils.Constants.*;


public class LoginTests extends BaseTest {
    @Test
    void login() {
        MainPage mp = new MainPage(super.driver);
        mp.enterLoginModal()
                .login(LOGIN, PASSWORD)
                .checkThatUserIsLogged(LOGIN);
      }

    @Test
    void loginWithInvalidCredentials(){
          MainPage mp = new MainPage(super.driver);
          mp.enterLoginModal()
                  .loginWithInvalidCredentials(LOGIN, INCORRECT_PASSWORD)
                  .checkThatLoginWithInvalidCredentialsFailed();
      }
}
