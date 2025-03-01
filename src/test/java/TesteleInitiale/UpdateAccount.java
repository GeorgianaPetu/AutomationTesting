package TesteleInitiale;//am incercat sa incarc poza, dar imi da eroare
//La Assert nu stiu inca cum sa scriu xpath-ul manual/ am luat momentan cu copy-paste


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class UpdateAccount {

    WebDriver driver;

    @Test

    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://www.librarul.ro/");

        WebElement popUp = driver.findElement(By.xpath("//*[@class='gdpr_submit']"));
        popUp.click();

        driver.manage().window().maximize();

        String email = "georgiana.petu@gmail.com";
        String password = "Test12345!";

        metodaLogin(email, password);
        metodaModificareDate("Anca", "Popescu", "georgiana.petu@gmail.com", "0721445772", "Brasov", "Brasov", "Strada Lacului nr3");
        //SCHIMB DATELE CU CELE INITIALE
        metodaModificareDate("Georgiana", "Petu", "georgiana.petu@gmail.com", "0744444444", "Bucuresti", "Bucuresti", "Strada Garii nr5");

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

    public void metodaModificareDate(String prenumeLabel, String numeLabel, String emailLabel, String telefonLabel, String judetSectorLabel, String orasLabel, String adresaLabel){
        WebElement modificaButton = driver.findElement(By.xpath("//*[@title='Modifica']"));
        modificaButton.click();

        //pentru a da scroll
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0, 500)");

        WebElement prenumeField = driver.findElement(By.xpath("//*[@name='firstname']"));
        prenumeField.clear();
        prenumeField.sendKeys(prenumeLabel);

        WebElement numeField = driver.findElement(By.xpath("//*[@name='lastname']"));
        numeField.clear();
        numeField.sendKeys(numeLabel);

        WebElement telefonField = driver.findElement(By.xpath("//*[@name='phone']"));
        telefonField.clear();
        telefonField.sendKeys(telefonLabel);

        WebElement judetSectorField = driver.findElement(By.id("county"));
        judetSectorField.sendKeys(judetSectorLabel);
        judetSectorField.sendKeys(Keys.ENTER);

        //Delay 1 secunda
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        WebElement orasField = driver.findElement(By.id("citys"));
        orasField.sendKeys(orasLabel);
        orasField.sendKeys(Keys.ENTER);

        WebElement adresaField = driver.findElement(By.xpath("//*[@name='streetaddress']"));
        adresaField.clear();
        adresaField.sendKeys(adresaLabel);

        WebElement trimiteButton = driver.findElement(By.xpath("//*[@class='btn nice-btn-new-full t-call-to-action t-action-text ']"));
        trimiteButton.click();

        //assert
        //xpath copy paste
        WebElement outputUsername = driver.findElement(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div/div[2]/div[1]/span"));
        Assert.assertTrue(outputUsername.getText().contains(numeLabel + " " + prenumeLabel));

        //xpath copy paste
        WebElement outputEmail = driver.findElement(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div/div[2]/div[2]/span"));
        Assert.assertTrue(outputEmail.getText().contains(emailLabel));

        //xpath copy paste
        WebElement outputTelefon = driver.findElement(By.xpath("//*[@id=\"info\"]/div/div[1]/div[1]/div/div[2]/div[3]/span"));
        Assert.assertTrue(outputTelefon.getText().contains(telefonLabel));


//        WebElement uploadButton = driver.findElement(By.id("customerAvatar"));
//        File poza = new File("src/test/resources/peisaj.jpg");
//        String absPath = poza.getAbsolutePath();
//        uploadButton.sendKeys(absPath);


    }

}
