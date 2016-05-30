import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ccatari on 5/30/2016.
 */
public class ProjectOptions extends AbstractBasePage{
    @FindBy(id = "amicomplete_floater")
    private WebElement menuOption;


    public void selectOption(String project) {
        List<WebElement> options = getOptions();
        for (WebElement option: options) {
            if(isOptionToSelect(option,project)){
                option.click();
                return;
            }
        }
    }
    public boolean isOptionToSelect(WebElement option,String project){
        return option.getText().equalsIgnoreCase(project);
    }
    public List<WebElement> getOptions(){
        return menuOption.findElements(By.cssSelector("span[class='truncated p_name']"));
    }
}
