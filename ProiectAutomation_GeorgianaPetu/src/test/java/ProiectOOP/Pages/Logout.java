package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Logout {
    WebDriver driver;
    ElementsMethods elementsMethods;

    public Logout(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='left-column']//*[@class='box-menu']//*[@title='Logout']")
    WebElement delogareButton;

    public void metodaLogout() {
        elementsMethods.clickOnElement(delogareButton);
    }
}
