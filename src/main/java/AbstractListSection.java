import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/30/2016.
 */
public class AbstractListSection extends AbstractBasePage {

    @FindAll({
            @FindBy(css = "span[class='text sel_item_content']")
    })
    private List<WebElement> taskList;
    @FindBy(xpath = "//img[contains(@class,'cmp_priority')]")
    private WebElement inputBoxMenu;

    public String getLastTaskNameText() {
        System.out.println("taskSize: "+taskList.size());
        return getLastTask().getText();
    }

    public String getLastTaskPriorityText() {
        wait.until(ExpectedConditions.visibilityOf(getLastTask()));
        getLastTask().click();
        wait.until(ExpectedConditions.visibilityOf(inputBoxMenu));
        inputBoxMenu.click();
        TaskPriorityPopUp lastTaskPriority = new TaskPriorityPopUp();
        return lastTaskPriority.getlastTaskPriorityAsText();
    }

    public WebElement getLastTask() {
        return taskList.get(taskList.size() - 1);
    }
}
