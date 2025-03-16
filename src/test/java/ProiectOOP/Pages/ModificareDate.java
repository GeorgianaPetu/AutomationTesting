package ProiectOOP.Pages;

import ObjectData.UpdateAccountObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import ProiectOOP.HelperMethods.ScrollMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ModificareDate {
    WebDriver driver;
    ElementsMethods elementsMethods;
    ScrollMethod scrollMethod;
    Delay delay;
    String prenume;
    String nume;
    String email;
    String telefon;
    String judetSector;
    String oras;
    String adresa;
    public String outputUsernameText;
    public String outputEmailText;
    public String outputTelefonText;

    @FindBy(xpath = "//*[@title='Modifica']")
    WebElement modificaButton;

    @FindBy(xpath = "//*[@name='firstname']")
    WebElement prenumeField;

    @FindBy(xpath = "//*[@name='lastname']")
    WebElement numeField;

    @FindBy(xpath = "//*[@name='phone']")
    WebElement telefonField;

    @FindBy(id = "county")
    WebElement judetSectorField;

    @FindBy(id = "citys")
    WebElement orasField;

    @FindBy(xpath = "//*[@name='streetaddress']")
    WebElement adresaField;

    @FindBy(xpath = "//*[@class='btn nice-btn-new-full t-call-to-action t-action-text ']")
    WebElement trimiteButton;

    @FindBy(xpath = "//*[@id=\"info\"]/div/div[1]/div[1]/div/div[2]/div[1]/span")
    WebElement outputUsername;

    @FindBy(xpath = "//*[@id=\"info\"]/div/div[1]/div[1]/div/div[2]/div[2]/span")
    WebElement outputEmail;

    @FindBy(xpath = "//*[@id=\"info\"]/div/div[1]/div[1]/div/div[2]/div[3]/span")
    WebElement outputTelefon;

    public ModificareDate(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.scrollMethod = new ScrollMethod(driver);
        this.prenume = prenume;
        this.nume = nume;
        this.email = email;
        this.telefon = telefon;
        this.judetSector = judetSector;
        this.oras = oras;
        this.adresa = adresa;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this);
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void metodaModificareDate(UpdateAccountObjectData data) {
        this.nume = data.getNume();
        this.prenume = data.getPrenume();
        this.email = data.getEmail();
        this.telefon = data.getTelefon();
        delay.metodaDelaySec(2);
        elementsMethods.assertElementDisplayed(modificaButton);
        elementsMethods.clickOnElement(modificaButton);
        scrollMethod.metodaScroll(500);
        delay.metodaDelaySec(5);
        prenumeField.clear();
        elementsMethods.fillElement(prenumeField, data.getPrenume());
        delay.metodaDelaySec(1);
        elementsMethods.assertElementDisplayed(numeField);
        numeField.clear();
        elementsMethods.fillElement(numeField, data.getNume());
        delay.metodaDelaySec(1);
        elementsMethods.assertElementDisplayed(telefonField);
        telefonField.clear();
        elementsMethods.fillElement(telefonField, data.getTelefon());
        delay.metodaDelaySec(1);
        elementsMethods.assertElementDisplayed(judetSectorField);
        elementsMethods.fillElement(judetSectorField, data.getJudetSector());
        delay.metodaDelaySec(3);
        judetSectorField.sendKeys(Keys.ENTER);
        delay.metodaDelaySec(2);
        elementsMethods.assertElementDisplayed(orasField);
        elementsMethods.fillElement(orasField, data.getOras());
        delay.metodaDelaySec(5);
        orasField.sendKeys(Keys.ENTER);
        delay.metodaDelaySec(2);
        elementsMethods.assertElementDisplayed(adresaField);
        adresaField.clear();
        elementsMethods.fillElement(adresaField, data.getAdresa());
        delay.metodaDelaySec(2);
        elementsMethods.assertElementDisplayed(trimiteButton);

        elementsMethods.clickOnElement(trimiteButton);
        delay.metodaDelaySec(2);

        outputUsernameText = outputUsername.getText();
        outputEmailText = outputEmail.getText();
        outputTelefonText = outputTelefon.getText();

        //assert
//        Assert.assertTrue(outputUsername.getText().contains(nume + " " + prenume));
//        Assert.assertTrue(outputEmail.getText().contains(email));
//        Assert.assertTrue(outputTelefon.getText().contains(telefon));
    }

}
