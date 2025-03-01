package ProiectOOP.HelperMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PopUp {
    WebDriver driver;

    public PopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@class='gdpr_submit']")
    WebElement popUpButton;

    public void clickOnPopUp(){
        popUpButton.click();
    }

}


