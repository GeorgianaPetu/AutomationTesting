package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FormularComanda {
    WebDriver driver;
    ElementsMethods elementsMethods;
    String judetSector;
    String oras;
    String adresa;

    public FormularComanda(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.judetSector = judetSector;
        this.oras = oras;
        this.adresa = adresa;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cart\"]/fieldset/div[5]/div[1]/div/label[2]")
    WebElement checkBoxAdresaNoua;

    @FindBy(id = "cart-element-19")
    WebElement judetSectorField;

    @FindBy(id = "cart-element-18")
    WebElement orasField;

    @FindBy(id = "cart-element-20")
    WebElement adresaField;

    @FindBy(xpath = "//input[@name='termeni[]' and @type='checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//*[@class='wrap-text4']//*[@class='form-actions']//*[@name='button']")
    WebElement finalizeazaComandaButton;

    public void metodaFormularComanda(String judetSector, String oras, String adresa) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0, 500)");
        elementsMethods.clickOnElement(checkBoxAdresaNoua);
        javascriptExecutor.executeScript("window.scrollTo(0, 500)");
        elementsMethods.fillElement(judetSectorField, judetSector);
        judetSectorField.sendKeys(Keys.ENTER);
        elementsMethods.fillElement(orasField, oras);
        orasField.sendKeys(Keys.ENTER);
        adresaField.clear();
        elementsMethods.fillElement(adresaField,adresa);
        javascriptExecutor.executeScript("window.scrollTo(0, 1800)");
        javascriptExecutor.executeScript("arguments[0].click();", checkbox);
        //elementsMethods.clickOnElement(finalizeazaComandaButton);


    }
}
