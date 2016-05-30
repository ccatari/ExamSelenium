import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/25/2016.
 */
public class InboxHome extends AbstractListSection {
    @FindBy(xpath = "//a[contains(.,'Add Task')]")
    private WebElement addtaskLink;
    @FindBy(css = "div[class='richtext_editor sel_richtext_editor']")
    private WebElement tastNameField;
    @FindBy(xpath = "//span[contains(.,'Add Task')]")
    private WebElement addTaskButton;


    public void clickAddNewTask() {
        wait.until(ExpectedConditions.elementToBeClickable(addtaskLink));
        addtaskLink.click();
    }

    public void addNexTask(String taskName, int priority) {
        setTaskNameField(taskName + " " + PRIORITY_CHARACTER + priority);
        clickAddnewTask();
    }

    private void clickAddnewTask() {
        wait.until(ExpectedConditions.elementToBeClickable(addTaskButton));
        addTaskButton.click();
    }

    private void setTaskNameField(String taskName) {
        wait.until(ExpectedConditions.elementToBeClickable(tastNameField));
        tastNameField.clear();
        tastNameField.sendKeys(taskName);
    }

    public String getLastTaskAsText() {
        String lastTask = "";
        lastTask = getLastTaskNameText() + " " + getLastTaskPriorityText();
        System.out.println(lastTask);
        return lastTask;
    }
}
