package com.jalasoft.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ccatari on 5/29/2016.
 */
public class TaskPriorityPopUp extends AbstractBasePage {

    public static final String SELECTED_OPTION_CLASS = "pri_selected";
    @FindBy(css = "div[class='AmiMenu priority_menu']")

    private WebElement priorityIcons;

    public int getSelectedPriority() {
        return getSelectedPriorityFromAList(getPriorityOptions());
    }

    public int getSelectedPriorityFromAList(List<WebElement> priorities) {
        for (WebElement priority : priorities) {
            if (isSelected(priority)) {
                return priorities.indexOf(priority) + 1;
            }
        }
        return 0;
    }

    public boolean isSelected(WebElement priority) {
        return priority.getAttribute("class").contains(SELECTED_OPTION_CLASS);
    }

    public List<WebElement> getPriorityOptions() {
        return priorityIcons.findElements(By.tagName("a"));
    }

    public String getlastTaskPriorityAsText() {
        StringBuilder priorityText = new StringBuilder(HomePage.PRIORITY_CHARACTER + getSelectedPriority());
        return priorityText.toString();
    }
}
