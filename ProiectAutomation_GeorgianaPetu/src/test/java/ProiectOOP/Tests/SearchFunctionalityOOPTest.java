package ProiectOOP.Tests;
import ProiectOOP.HelperMethods.PopUp;
import ProiectOOP.Pages.CautareAvansata;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.Search;
import ProiectOOP.ShareDataBrowser.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class SearchFunctionalityOOPTest extends ShareData {
    Login login;
    Search search;
    CautareAvansata cautareAvansata;

    @Test
    public void metodaTest() {
        login = new Login(getDriver());
        login.metodaLogin("georgiana.petu@gmail.com", "Test12345!");
        search = new Search(getDriver());
        search.metodaSearch("carte");
        //cautareAvansata = new CautareAvansata(getDriver(),"Pov", "3", "100");
        //cautareAvansata.metodaCautareAvansata();
    }
}


