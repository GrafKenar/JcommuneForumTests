package org.jcommune.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.jcommune.utils.Constants.BASE_URL;

public class BaseTest {
    public WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();

        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown(){
        driver.close();
    }
}
