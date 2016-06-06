package com.jalasoft.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/25/2016.
 */
public class InboxHome extends AbstractListSection {
    @FindBy(css = "a[class='action']")
    private WebElement addtaskLink;

    public void clickAddNewTask() {
        wait.until(ExpectedConditions.elementToBeClickable(addtaskLink));
        addtaskLink.click();
    }

    public void addNexTask(String taskName, int priority) {
        setTaskNameWithPriority(taskName + " " + HomePage.PRIORITY_CHARACTER + priority);
        clickAddNewTask();
    }


    public String getLastTaskAsText() {
        return getLastTaskNameText() + " " + getLastTaskPriorityText();
    }
}
