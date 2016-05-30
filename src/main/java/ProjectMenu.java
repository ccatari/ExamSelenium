import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by ccatari on 5/30/2016.
 */
public class ProjectMenu extends AbstractBasePage {
    @FindBy(id="project_list")
    private WebElement menuOptions;

    public ProjectHomePage goToProject(String project) {
        wait.until(ExpectedConditions.visibilityOf(menuOptions));
        List<WebElement> options = menuOptions.findElements(By.tagName("span"));
        for (WebElement option: options) {
            if(option.getText().equalsIgnoreCase(project)){
                option.click();
                return new ProjectHomePage();
            }
        }
        return new ProjectHomePage();
    }
}
