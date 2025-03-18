package ProiectOOP.Pages;

import ObjectData.ChangePasswordObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.By;
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
    String passChangeSuccess;
    public String outputSuccessText;

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

    public SchimbareParola(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.passChangeSuccess = passChangeSuccess;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPassChangeSuccess() {
        return passChangeSuccess;
    }

    public void metodaSchimbareParola(ChangePasswordObjectData data) {
        this.passChangeSuccess = data.getPassChangeSuccess();
        elementsMethods.assertElementDisplayed(schimbaParolaButton);
        elementsMethods.clickOnElement(schimbaParolaButton);
        delay.metodaDelaySec(2);
        elementsMethods.assertElementDisplayed(oldPassField);
        elementsMethods.assertElementDisplayed(newPassField);
        elementsMethods.assertElementDisplayed(confNewPassField);
        elementsMethods.fillElement(oldPassField, data.getOldPass());
        elementsMethods.fillElement(newPassField, data.getNewPass());
        elementsMethods.fillElement(confNewPassField, data.getNewPass());
        elementsMethods.clickOnElement(salveazaButton);
        WebElement outputSuccess = driver.findElement(By.xpath("//*[@id='middle-column']//*[@class='notice danger']"));
        outputSuccessText = outputSuccess.getText();
    }
}
