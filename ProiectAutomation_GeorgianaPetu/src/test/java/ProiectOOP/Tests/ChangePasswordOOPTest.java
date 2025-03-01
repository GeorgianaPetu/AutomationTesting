package ProiectOOP.Tests;
import ProiectOOP.HelperMethods.PopUp;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.Logout;
import ProiectOOP.Pages.SchimbareParola;
import ProiectOOP.ShareDataBrowser.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getDriver;
public class ChangePasswordOOPTest extends ShareData {
    Login login1;
    Login login2;
    SchimbareParola schimbareParola;
    SchimbareParola schimbareParola2;
    Logout logout;

    @Test
    public void metodaTest() {
        login1 = new Login(getDriver());
        login1.metodaLogin("georgiana.petu@gmail.com", "Test12345!");
        schimbareParola = new SchimbareParola(getDriver());
        schimbareParola.metodaSchimbareParola("Test12345!", "Test23451!");
        logout = new Logout(getDriver());
        logout.metodaLogout();
        login2 = new Login(getDriver());
        login2.metodaLogin("georgiana.petu@gmail.com", "Test23451!");
        //SCHIMB PAROLA LA CEA INITIALA CA SA NU AFECTEZE RESTUL TESTELOR
        schimbareParola.metodaSchimbareParola("Test23451!", "Test12345!");
    }
}