package ProiectOOP.HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsMethods {
    WebDriver driver;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void clickOnElementByText(List<WebElement> webElementList, String text){
        for(int i=0; i< webElementList.size(); i++){
            if(webElementList.get(i).getText().equals(text)){
                clickOnElement(webElementList.get(i));
                break;
            }
        }
    }

    public void fillElement(WebElement element, String text){
        element.sendKeys(text);
    }
}


