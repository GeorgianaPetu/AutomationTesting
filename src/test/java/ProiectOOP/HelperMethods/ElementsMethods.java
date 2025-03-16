package ProiectOOP.HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ElementsMethods extends CommonMethods {
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

    public void assertElementDisplayed(WebElement element){
        Assert.assertTrue(isDisplayed(element));
        //Assert.assertTrue(element.isDisplayed());
    }

    public void assertElementNotEmpty(WebElement element, String text){
        Assert.assertTrue(!element.getText().isEmpty());
    }

    public void assertFillElement(WebElement element, String text){
        //String textElement = element.getText();
        Assert.assertTrue(!element.getText().isEmpty());
        Assert.assertTrue(element.getText().equals(text));
    }


}


