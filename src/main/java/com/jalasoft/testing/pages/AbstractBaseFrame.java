package com.jalasoft.testing.pages;

/**
 * Created by ccatari on 5/25/2016.
 */
public abstract class AbstractBaseFrame extends AbstractBasePage {
    public void returnDefault() {
        driver.switchTo().defaultContent();
    }

    public void returnRoot() {
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
    }
}
