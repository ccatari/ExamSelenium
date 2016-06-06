package com.jalasoft.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 6/4/2016.
 */
public class AbstractAddTaskForm extends AbstractBasePage {
    @FindBy(css = "div[class='richtext_editor sel_richtext_editor']")
    private WebElement taskNameField;
    @FindBy(css = "a[class='amibutton amibutton_red submit_btn']")
    private WebElement addTaskButton;

    protected void clickAddNewTask() {
        wait.until(ExpectedConditions.elementToBeClickable(addTaskButton));
        addTaskButton.click();
    }

    protected void setTaskNameWithPriority(String taskName) {
        wait.until(ExpectedConditions.elementToBeClickable(taskNameField));
        taskNameField.clear();
        taskNameField.sendKeys(taskName);
    }
}
