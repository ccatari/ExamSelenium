import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ccatari on 5/30/2016.
 */
public class ProjectHomePage extends AbstractListSection {
    @FindBy(css="a[class='project_link']>span")
    private WebElement projectName;

    public String getLastTaskCreated() {
        return getLastTaskNameText() + " " + getLastTaskProjectText() + " " + getLastTaskPriorityText();
    }
    public String getLastTaskProjectText(){
        System.out.println("Project: "+projectName.getText());
        return projectName.getText();
    }

    public WebElement getLastTaskProject() {
        return getLastTask().findElement(By.cssSelector("span[class='name']"));
    }

}
