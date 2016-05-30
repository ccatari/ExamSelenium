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
        List<WebElement> options = getOptions();
        for (WebElement option: options) {
            if(isSelectedProject(option,project)){
                option.click();
                return new ProjectHomePage();
            }
        }
        return new ProjectHomePage();
    }
    public boolean isSelectedProject(WebElement option,String project){
        return option.getText().equalsIgnoreCase(project);
    }
    public List<WebElement> getOptions(){
        return menuOptions.findElements(By.tagName("span"));
    }
}
