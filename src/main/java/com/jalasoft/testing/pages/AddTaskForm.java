package com.jalasoft.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/30/2016.
 */
public class AddTaskForm extends AbstractAddTaskForm {

    @FindBy(css = "span[class='truncated p_name']")
    private WebElement projectCheckbox;

    public void addTask(String taskName, int priority, String project) {
        setTaskNameWithPriority(taskName + " " + HomePage.PRIORITY_CHARACTER + priority);
        selectProject(project);
        clickAddNewTask();
    }

    private void selectProject(String project) {
        wait.until(ExpectedConditions.visibilityOf(projectCheckbox));
        projectCheckbox.click();
        ProjectOptions options = new ProjectOptions();
        options.selectOption(project);
    }
}
