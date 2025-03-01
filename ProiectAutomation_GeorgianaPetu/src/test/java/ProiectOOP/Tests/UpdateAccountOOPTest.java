package ProiectOOP.Tests;
import ProiectOOP.HelperMethods.PopUp;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.ModificareDate;
import ProiectOOP.ShareDataBrowser.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class UpdateAccountOOPTest extends ShareData {
    Login login;
    ModificareDate modificareDate;

    @Test
    public void metodaTest() {
        login = new Login(getDriver());
        login.metodaLogin("georgiana.petu@gmail.com", "Test12345!");
        modificareDate = new ModificareDate(getDriver());
        modificareDate.metodaModificareDate("Anca", "Popescu", "georgiana.petu@gmail.com", "0721445772", "Brasov", "Bradeanca", "Strada Lacului nr3");
        //assert
        Assert.assertTrue(modificareDate.outputUsernameText.contains(modificareDate.getNume() + " " + modificareDate.getPrenume()));
        Assert.assertTrue(modificareDate.outputEmailText.contains(modificareDate.getEmail()));
        Assert.assertTrue(modificareDate.outputTelefonText.contains(modificareDate.getTelefon()));
        //SCHIMB DATELE CU CELE INITIALE
        modificareDate.metodaModificareDate("Georgiana", "Petu", "georgiana.petu@gmail.com", "0744444444", "Ilfov", "Voluntari", "Strada Garii nr5");
        //assert
        Assert.assertTrue(modificareDate.outputUsernameText.contains(modificareDate.getNume() + " " + modificareDate.getPrenume()));
        Assert.assertTrue(modificareDate.outputEmailText.contains(modificareDate.getEmail()));
        Assert.assertTrue(modificareDate.outputTelefonText.contains(modificareDate.getTelefon()));
    }
}