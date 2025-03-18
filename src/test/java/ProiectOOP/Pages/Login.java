package ProiectOOP.Pages;

import ObjectData.LoginObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Login extends CommonMenu {

    ElementsMethods elementsMethods;
    Delay delay;
    String email;
    String parola;

    @FindBy(xpath = "//*[@name='cs_customer_email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@name='cs_customer_password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@class='form-actions']//*[@class='btn nice-btn t-call-to-action t-action-text ']")
    WebElement autentificareButton;

    public Login(WebDriver driver){
        super(driver);
        //this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.email = email;
        this.parola = parola;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this);
    }

    public void metodaLogin(LoginObjectData dataL) {
        delay.metodaDelaySec(2);
        clickContulMeu();
        delay.metodaDelaySec(2);
        clickIntraInCont();
        elementsMethods.fillElement(emailField, dataL.getEmail());
        elementsMethods.fillElement(passwordField, dataL.getPassword());
        elementsMethods.clickOnElement(autentificareButton);
    }
}
