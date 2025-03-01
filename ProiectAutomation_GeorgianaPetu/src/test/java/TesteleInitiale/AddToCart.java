package TesteleInitiale;//la pagina de final nu merge sa dau click pe checkbox-ul de la 'Accept termenii si conditiile'
//apare ca e conexiune securizata
//la check box-uri nu stiu inca cum sa scriu xpath-ul manual am luat momentan cu copy-paste

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddToCart {
    WebDriver driver;
    @Test

    public void metodaTest(){
        driver = new ChromeDriver();
        driver.get("https://www.librarul.ro/");

        WebElement popUp = driver.findElement(By.xpath("//*[@class='gdpr_submit']"));
        popUp.click();

        driver.manage().window().maximize();

        String email = "georgiana.petu@gmail.com";
        String password = "Test12345!";

        metodaLogin(email, password);
        metodaAddToCart();
        metodaFormularComanda("Calarasi", "Calarasi", "Strada Lalelelor nr30");

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

        WebElement backToHomeButton = driver.findElement(By.xpath("//*[@alt='Librarie online. Cărți. Cadouri. Jucării - Librarul.ro']"));
        backToHomeButton.click();
    }

    public void metodaAddToCart() {
        WebElement cartiButton = driver.findElement(By.xpath("//*[@data-id='4458']"));
        cartiButton.click();

        WebElement cartiFizicaButton = driver.findElement(By.xpath("//*[@title='Fizica']"));
        cartiFizicaButton.click();

        WebElement sortareField = driver.findElement(By.id("order"));
        sortareField.sendKeys("Popularitate");
        sortareField.sendKeys(Keys.ENTER);

        //pentru a da scroll
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0, 400)");

        //Delay 1 secunda
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        WebElement primaCarteButton = driver.findElement(By.xpath("//*[@data-id='29376']//*[@title='Adauga in cos']"));
        primaCarteButton.click();

        //Delay 1 secunda
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        WebElement continuaCumparaturileButton = driver.findElement(By.xpath("//*[@class='close-button btn nice-btn gray-btn ']"));
        continuaCumparaturileButton.click();

        WebElement aDouaCarteButton = driver.findElement(By.xpath("//*[@data-id='26692']//*[@title='Adauga in cos']"));
        aDouaCarteButton.click();

        //Delay 1 secunda
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        WebElement finalizeazaCumparaturileButton = driver.findElement(By.id("go-to-cart"));
        finalizeazaCumparaturileButton.click();
    }

    public void metodaFormularComanda(String judetSectorLabel, String orasLabel, String adresaLabel){

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0, 500)");

        //xpath copy paste
        WebElement checkBoxAdresaNoua = driver.findElement(By.xpath("//*[@id=\"cart\"]/fieldset/div[5]/div[1]/div/label[2]"));
        checkBoxAdresaNoua.click();

        javascriptExecutor.executeScript("window.scrollTo(0, 500)");

        WebElement judetSectorField = driver.findElement(By.id("cart-element-19"));
        judetSectorField.sendKeys(judetSectorLabel);
        judetSectorField.sendKeys(Keys.ENTER);

        WebElement orasField = driver.findElement(By.id("cart-element-18"));
        orasField.sendKeys(orasLabel);
        orasField.sendKeys(Keys.ENTER);

        WebElement adresaField = driver.findElement(By.id("cart-element-20"));
        adresaField.clear();
        adresaField.sendKeys(adresaLabel);

        /*
        javascriptExecutor.executeScript("window.scrollTo(0, 1000)");

        //conexiune securizata / nu pot bifa termenii si conditiile
        WebElement acceptTermeniCheckBox = driver.findElement(By.name("termeni[]"));
        WebElement checkbox = driver.findElement(By.xpath("//input[@name='termeni[]' and @type='checkbox']"));
        checkbox.click();

         */

        javascriptExecutor.executeScript("window.scrollTo(0, 1800)");

        WebElement checkbox = driver.findElement(By.xpath("//input[@name='termeni[]' and @type='checkbox']"));
        javascriptExecutor.executeScript("arguments[0].click();", checkbox);

        //butonul bun
        //WebElement finalizeazaComandaButton = driver.findElement(By.xpath("//*[@class='wrap-text4']//*[@class='form-actions']//*[@name='button']"));
        //finalizeazaComandaButton.click();

        //WebElement finalizeazaComandaButton = driver.findElement(By.xpath("//*[@class='btn nice-btn t-call-to-action t-action-text finish-order button_tab-order btnag']"));
        //finalizeazaComandaButton.click();
    }
}
