/*package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CautareAvansata {

    WebDriver driver;
    Delay delay;
    ElementsMethods elementsMethods;
    String categorie;
    String pretMinim;
    String pretMaxim;

    public CautareAvansata(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.categorie = categorie;
        this.pretMinim = pretMinim;
        this.pretMaxim = pretMaxim;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@name='cat']")
    WebElement categorieField;

    @FindBy(xpath = "//*[@name='min']")
    WebElement pretMinimField;

    @FindBy(xpath = "//*[@name='max']")
    WebElement pretMaximField;

    @FindBy(xpath = "//*[@name='search']")
    WebElement searchButton;


    public void metodaCautareAvansata(String categorie, String pretMinim, String pretMaxim) {
        elementsMethods.fillElement(categorieField, categorie);
        categorieField.sendKeys(Keys.ENTER);
        elementsMethods.fillElement(pretMinimField, pretMinim);
        elementsMethods.fillElement(pretMaximField, pretMaxim);
        delay.metodaDelaySec(15);
        elementsMethods.clickOnElement(searchButton);
    }
}

 */
