package ProiectOOP.Tests;
import ProiectOOP.HelperMethods.PopUp;
import ProiectOOP.Pages.AddToCart;
import ProiectOOP.Pages.FormularComanda;
import ProiectOOP.Pages.Login;
import ProiectOOP.ShareDataBrowser.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class AddToCartOOPTest extends ShareData {
    Login login;
    AddToCart addToCart;
    FormularComanda formularComanda;

    @Test
    public void metodaTest(){
        login = new Login(getDriver());
        login.metodaLogin("georgiana.petu@gmail.com", "Test12345!");
        addToCart = new AddToCart(getDriver());
        addToCart.metodaAddToCart();
        formularComanda = new FormularComanda(getDriver());
        formularComanda.metodaFormularComanda("Calarasi", "Calarasi", "Strada Lalelelor nr30");
    }
}
