package TesteleInitiale;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchFunctionality {

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
        metodaSearch("carte");
        metodaCautareAvansata("Pov", "3", "100");
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

    public void metodaSearch(String cuvant) {
        //Delay 2 secunde
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        WebElement searchBar = driver.findElement(By.xpath("//*[@class='search-query ui-autocomplete-input']"));
        searchBar.click();
        searchBar.sendKeys(cuvant);
        //Delay 2 secunde
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        searchBar.sendKeys(Keys.ARROW_DOWN);
        searchBar.sendKeys(Keys.ENTER);
        WebElement searchButton = driver.findElement(By.xpath("//*[@class='default t-config-search-color']"));
        searchButton.click();

        WebElement sortareField = driver.findElement(By.id("order"));
        sortareField.sendKeys("Nume");
        sortareField.sendKeys(Keys.ENTER);

        WebElement afisareTipListaButton = driver.findElement(By.xpath("//*[@title='Tip afisare Lista']"));
        afisareTipListaButton.click();

        //pentru a da scroll
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0, 1200)");
    }

    public void metodaCautareAvansata(String categorie, String pretMinim, String pretMaxim){
        WebElement categorieField = driver.findElement(By.xpath("//*[@name='cat']"));
        categorieField.sendKeys(categorie);
        categorieField.sendKeys(Keys.ENTER);
        //categorieField.sendKeys(Keys.ENTER);

        WebElement pretMinimField = driver.findElement(By.xpath("//*[@name='min']"));
        pretMinimField.sendKeys(pretMinim);


        WebElement pretMaximField = driver.findElement(By.xpath("//*[@name='max']"));
        pretMaximField.sendKeys(pretMaxim);

        WebElement searchButton = driver.findElement(By.xpath("//*[@name='search']"));
        //searchButton.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();", searchButton);

        String searchedBook = "Din lumea celor care nu cuvanta";

        //ASSERT
        //WebElement searchResult = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Din lumea celor care nu cuvanta']"));
        //Assert.assertTrue(searchResult.getText().contains(searchedBook));

        //WebElement cautareDupaField = driver.findElement(By.xpath("//*[@class='col-12']//*[@class='input_text valid']"));
        //Assert.assertTrue(cautareDupaField.getText().contains("Carte scolara"));

        //WebElement categorieAField = driver.findElement(By.xpath("..."));
        //Assert.assertTrue(categorieAField.getText().contains("Povesti si povestiri"));
    }

}


