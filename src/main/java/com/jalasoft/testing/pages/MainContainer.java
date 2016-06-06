package com.jalasoft.testing.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/25/2016.
 */
public class MainContainer extends AbstractBasePage {

    @FindBy(id = "filter_inbox")
    private WebElement inboxMenu;


    @FindAll({@FindBy(css = "span[class='pname']")})
    private List<WebElement> projects;

    public MainContainer() {
    }

    public InboxHome goToInboxMenu() {
        wait.until(ExpectedConditions.visibilityOf(inboxMenu));
        inboxMenu.click();
        return new InboxHome();
    }

    public TopBar goToTopBar() {
        return new TopBar();
    }

    public ProjectMenu goToProjectMenu() {
        return new ProjectMenu();
    }

}
