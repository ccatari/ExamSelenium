import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/30/2016.
 */
public class TopBar extends AbstractBasePage {
    @FindBy(css="img[class=' icon fixed_pos cmp_light_add_task']")
    private WebElement quickAddTask;

    public AddTaskForm clickQuickAddTask() {
        wait.until(ExpectedConditions.visibilityOf(quickAddTask));
        quickAddTask.click();
        return new AddTaskForm();
    }
}
