package com.jalasoft.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/25/2016.
 */
public class HomePage extends AbstractBasePage {
    public static final Character PRIORITY_CHARACTER = 'p';
    private static final String URL_SALESFORCE = "https://en.todoist.com/";
    @FindBy(className = "sel_login")
    private WebElement loginLink;

    public HomePage() {
        driver.get(URL_SALESFORCE);
    }

    public LoginFrame goToLogin() {
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        loginLink.click();
        return new LoginFrame();
    }
}
