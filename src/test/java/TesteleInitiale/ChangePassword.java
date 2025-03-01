package TesteleInitiale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChangePassword {
    WebDriver driver;

    @Test

    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://www.librarul.ro/");

        WebElement popUp = driver.findElement(By.xpath("//*[@class='gdpr_submit']"));
        popUp.click();

        driver.manage().window().maximize();

        String email = "georgiana.petu@gmail.com";
        String oldPassword = "Test12345!";
        String newPassword = "Test23451!";

        metodaLogin(email, oldPassword);
        metodaSchimbareParola(oldPassword, newPassword);
        metodaLogout();
        metodaLogin(email, newPassword);
        //SCHIMB PAROLA LA CEA INITIALA CA SA NU AFECTEZE RESTUL TESTELOR
        metodaSchimbareParola(newPassword, oldPassword);
    }

    public void metodaLogin(String emailLabel, String passwordLabel){
        WebElement contulMeuButton = driver.findElement(By.xpath("//span[text()='Contul meu']"));
        contulMeuButton.click();

        //Delay 2 secunde
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        //LOGIN
        WebElement intraInContButton = driver.findElement(By.xpath("//*[@class='btn nice-btn t-call-to-action t-action-text ']"));
        intraInContButton.click();

        WebElement emailField = driver.findElement(By.xpath("//*[@name='cs_customer_email']"));
        emailField.sendKeys(emailLabel);

        WebElement passwordField = driver.findElement(By.xpath("//*[@name='cs_customer_password']"));
        passwordField.sendKeys(passwordLabel);

        WebElement autentificareButton = driver.findElement(By.xpath("//*[@class='form-actions']//*[@class='btn nice-btn t-call-to-action t-action-text ']"));
        autentificareButton.click();
    }

    //CHANGE PASSWORD
    public void metodaSchimbareParola(String passwordLabel, String newPassLabel) {

        String passChangeSuccess = "Parola a fost modificata";

        WebElement schimbaParolaButton = driver.findElement(By.xpath("//*[@id='left-column']//*[@class='box-menu']//*[@title='Schimba parola']"));
        schimbaParolaButton.click();

        //Delay 2 secunde
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        WebElement oldPassField = driver.findElement(By.xpath("//*[@name='oldpass']"));
        oldPassField.sendKeys(passwordLabel);

        WebElement newPassField = driver.findElement(By.xpath("//*[@name='newpass']"));
        newPassField.sendKeys(newPassLabel);

        WebElement confNewPassField = driver.findElement(By.xpath("//*[@name='cnewpass']"));
        confNewPassField.sendKeys(newPassLabel);

        WebElement salveazaButton = driver.findElement(By.xpath("//*[@class='btn nice-btn-new-full t-call-to-action t-action-text ']"));
        salveazaButton.click();

        //ASSERT -Verific ca s-a schimbat parola cu succes
        WebElement outputSuccess = driver.findElement(By.xpath("//*[@id='middle-column']//*[@class='notice danger']"));
        Assert.assertTrue(outputSuccess.getText().contains(passChangeSuccess));
    }

    //Ma deloghez si ma loghez din nou cu noua parola
    //LOGOUT
    public void metodaLogout() {
        WebElement delogareButton = driver.findElement(By.xpath("//*[@id='left-column']//*[@class='box-menu']//*[@title='Logout']"));
        delogareButton.click();
    }

}
