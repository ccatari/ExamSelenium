import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/30/2016.
 */
public class AddTaskForm extends AbstractBasePage{
    @FindBy(css = "div[class='richtext_editor sel_richtext_editor']")
    private WebElement taskNameField;
    @FindBy(css = "a[class='amibutton amibutton_red submit_btn']")
    private WebElement addTaskButton;
    @FindBy(css= "span[class='truncated p_name']")
    private WebElement projectCheckbox;

    public void addTask(String taskName, int priority, String project) {
        setTaskNameWithPriority(taskName+" "+PRIORITY_CHARACTER+priority);
        selectProject(project);
        wait.until(ExpectedConditions.elementToBeClickable(addTaskButton));
        addTaskButton.click();
    }

    private void selectProject(String project) {
        wait.until(ExpectedConditions.visibilityOf(projectCheckbox));
        projectCheckbox.click();
        ProjectOptions options = new ProjectOptions();
        options.selectOption(project);
    }

    public void setTaskNameWithPriority(String taskName) {
        wait.until(ExpectedConditions.visibilityOf(taskNameField));
        taskNameField.clear();
        taskNameField.sendKeys(taskName);
    }
}
