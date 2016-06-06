package com.jalasoft.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/25/2016.
 */
public class LoginFrame extends AbstractBaseFrame {


    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(css = "a[class='amibutton amibutton_red sel_login']")
    private WebElement loginButton;

    @FindBy(className = "GB_frame")
    private WebElement firstLoginFrame;

    @FindBy(id = "GB_frame")
    private WebElement LoginFrame;

    public LoginFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstLoginFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LoginFrame));
    }

    public MainContainer loginAs(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickLoginToMainContainer();
    }

    private MainContainer clickLoginToMainContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        returnRoot();
        return new MainContainer();
    }

    public void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField));
        emailTextField.clear();
        emailTextField.sendKeys(email);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }
}
