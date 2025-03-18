package ProiectOOP.Tests;
import Logger.LoggerUtility;
import ObjectData.ChangePasswordObjectData;
import ObjectData.LoginObjectData;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.Logout;
import ProiectOOP.Pages.SchimbareParola;
import ProiectOOP.ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class ChangePasswordOOPTest extends Hooks {
    Login login;
    SchimbareParola schimbareParola;
    Logout logout;
    private Map<String, LoginObjectData> loginObjectDataMap;
    private Map<String, ChangePasswordObjectData> changePasswordObjectDataMap;

    @Test
    public void metodaTest() {
        ChainTestListener.log("Opened with Chrome");
        loginObjectDataMap = xmlReader.loadData("src/test/resources/loginData.xml", LoginObjectData.class);
        changePasswordObjectDataMap = xmlReader.loadData("src/test/resources/changePasswordData.xml", ChangePasswordObjectData.class);
        login = new Login(getDriver());
        LoginObjectData dataL = loginObjectDataMap.get("dataSet_1");

        login.metodaLogin(dataL);
        ChainTestListener.log("User logs in");
        LoggerUtility.infoTest("The user logs in");
        schimbareParola = new SchimbareParola(getDriver());
        ChangePasswordObjectData data = changePasswordObjectDataMap.get("dataSet_1");
        schimbareParola.metodaSchimbareParola(data);
        ChainTestListener.log("User successfully changes password");
        LoggerUtility.infoTest("User changes password");
        Assert.assertTrue(schimbareParola.outputSuccessText.contains(data.getPassChangeSuccess())); /*schimbareParola.getPassChangeSuccess())*/
        logout = new Logout(getDriver());
        logout.metodaLogout();
        ChainTestListener.log("User logs out");
        LoggerUtility.infoTest("User logs out");
        LoginObjectData dataL2 = loginObjectDataMap.get("dataSet_2");
        login.metodaLogin(dataL2);
        ChainTestListener.log("User logs in using updated password");
        LoggerUtility.infoTest("User logs in using updated password");
        //SCHIMB PAROLA LA CEA INITIALA CA SA NU AFECTEZE RESTUL TESTELOR
        ChangePasswordObjectData data2 = changePasswordObjectDataMap.get("dataSet_2");
        schimbareParola.metodaSchimbareParola(data2);
        ChainTestListener.log("User successfully changes password to the initial password");
        LoggerUtility.infoTest("User successfully changes password to the initial password");
        Assert.assertTrue(schimbareParola.outputSuccessText.contains(data2.getPassChangeSuccess()));
    }
}