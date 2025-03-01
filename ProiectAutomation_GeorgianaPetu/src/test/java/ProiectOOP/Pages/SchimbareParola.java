package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SchimbareParola {
    WebDriver driver;
    ElementsMethods elementsMethods;
    Delay delay;
    String oldPass;
    String newPass;

    public SchimbareParola(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='left-column']//*[@class='box-menu']//*[@title='Schimba parola']")
    WebElement schimbaParolaButton;

    @FindBy(xpath = "//*[@name='oldpass']")
    WebElement oldPassField;

    @FindBy(xpath = "//*[@name='newpass']")
    WebElement newPassField;

    @FindBy(xpath = "//*[@name='cnewpass']")
    WebElement confNewPassField;

    @FindBy(xpath = "//*[@class='btn nice-btn-new-full t-call-to-action t-action-text ']")
    WebElement salveazaButton;

    @FindBy(xpath = "//*[@id='middle-column']//*[@class='notice danger']")
    WebElement outputSuccess;

    public void metodaSchimbareParola(String oldPass, String newPass) {
        String passChangeSuccess = "Parola a fost modificata";
        elementsMethods.clickOnElement(schimbaParolaButton);
        delay.metodaDelaySec(2);
        elementsMethods.fillElement(oldPassField, oldPass);
        elementsMethods.fillElement(newPassField, newPass);
        elementsMethods.fillElement(confNewPassField, newPass);
        elementsMethods.clickOnElement(salveazaButton);
        Assert.assertTrue(outputSuccess.getText().contains(passChangeSuccess));
    }
}
