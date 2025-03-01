package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Login extends CommonMenu {

    //WebDriver driver;
    ElementsMethods elementsMethods;
    Delay delay;
    String email;
    String parola;

    public Login(WebDriver driver){
        super(driver);
        //this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.email = email;
        this.parola = parola;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this); //astfel poate sa gaseasca elementele scrise de mine cu FindBy
    }

//    @FindBy(xpath = "//span[text()='Contul meu']")
//    WebElement contulMeuButton;

//    @FindBy(xpath = "//*[@class='btn nice-btn t-call-to-action t-action-text ']")
//    WebElement intraInContButton;

    @FindBy(xpath = "//*[@name='cs_customer_email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@name='cs_customer_password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@class='form-actions']//*[@class='btn nice-btn t-call-to-action t-action-text ']")
    WebElement autentificareButton;

    public void metodaLogin(String email, String parola) {
        clickContulMeu();
        delay.metodaDelaySec(2);
        clickIntraInCont();
        elementsMethods.fillElement(emailField, email);
        elementsMethods.fillElement(passwordField, parola);
        elementsMethods.clickOnElement(autentificareButton);
    }
}
