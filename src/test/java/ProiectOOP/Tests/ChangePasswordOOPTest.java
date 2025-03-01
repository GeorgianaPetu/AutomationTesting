package ProiectOOP.Tests;
import ObjectData.ChangePasswordObjectData;
import ObjectData.LoginObjectData;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.Logout;
import ProiectOOP.Pages.SchimbareParola;
import ProiectOOP.ShareDataBrowser.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class ChangePasswordOOPTest extends Hooks /*ShareData*/ {
    Login login;
    SchimbareParola schimbareParola;
    Logout logout;
    private Map<String, LoginObjectData> loginObjectDataMap;
    private Map<String, ChangePasswordObjectData> changePasswordObjectDataMap;

    @Test
    public void metodaTest() {
        /*data driven t*/ loginObjectDataMap = xmlReader.loadData("src/test/resources/loginData.xml", LoginObjectData.class);
       /*data driven t*/ changePasswordObjectDataMap = xmlReader.loadData("src/test/resources/changePasswordData.xml", ChangePasswordObjectData.class);
        login = new Login(getDriver());
        LoginObjectData dataL = loginObjectDataMap.get("dataSet_1");
        login.metodaLogin(dataL);
        schimbareParola = new SchimbareParola(getDriver());
        /*data driven t*/ ChangePasswordObjectData data = changePasswordObjectDataMap.get("dataSet_1");
        schimbareParola.metodaSchimbareParola(data);
        Assert.assertTrue(schimbareParola.outputSuccessText.contains(data.getPassChangeSuccess())); /*schimbareParola.getPassChangeSuccess())*/
        logout = new Logout(getDriver());
        logout.metodaLogout();
        LoginObjectData dataL2 = loginObjectDataMap.get("dataSet_2");
        login.metodaLogin(dataL2);
        //SCHIMB PAROLA LA CEA INITIALA CA SA NU AFECTEZE RESTUL TESTELOR
        /*data driven t*/ ChangePasswordObjectData data2 = changePasswordObjectDataMap.get("dataSet_2");
        schimbareParola.metodaSchimbareParola(data2);
        Assert.assertTrue(schimbareParola.outputSuccessText.contains(data2.getPassChangeSuccess()));
    }
}