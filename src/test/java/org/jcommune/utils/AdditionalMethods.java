package org.jcommune.utils;

import org.openqa.selenium.*;
import java.util.List;


public class AdditionalMethods {
    public static boolean isElementInvisible(WebElement element){
        try {
            return !(element.isDisplayed());
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return true;
        }
    }

    public static boolean areElementsNotPresent(List<WebElement> elements){
        return elements.stream().findAny().isEmpty();
    }

    public static void clickOnFirstElementInCollection(List<WebElement> elements){
        elements.stream().findFirst().get().click();
    }

    public static boolean isTextFromFirstElementEqualsValue(List<WebElement> elements, String expectedResult){
        return elements.stream().findFirst().get().getText().contains(expectedResult);
    }

    public static boolean isAnyElementHasSuchText(List<WebElement> elements, String text){
        return elements.stream().anyMatch(x -> x.getText().contains(text));
    }
}
