package ProiectOOP.Tests;
import Logger.LoggerUtility;
import ObjectData.LoginObjectData;
import ObjectData.UpdateAccountObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.ModificareDate;
import ProiectOOP.ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class UpdateAccountOOPTest extends Hooks {
    Login login;
    Delay delay;
    ModificareDate modificareDate;
    private Map<String, LoginObjectData> loginObjectDataMap;
    private Map<String, UpdateAccountObjectData> updateAccountObjectDataMap;

    @Test
    public void metodaTest() {
        ChainTestListener.log("Opened with Chrome");
        loginObjectDataMap = xmlReader.loadData("src/test/resources/loginData.xml", LoginObjectData.class);
        login = new Login(getDriver());
        delay = new Delay(getDriver());
        LoginObjectData dataL = loginObjectDataMap.get("dataSet_1");
        login.metodaLogin(dataL);
        ChainTestListener.log("User logs in");
        LoggerUtility.infoTest("User logs in");
        updateAccountObjectDataMap = xmlReader.loadData("src/test/resources/updateAccountData.xml", UpdateAccountObjectData.class);
        modificareDate = new ModificareDate(getDriver());
        UpdateAccountObjectData data = updateAccountObjectDataMap.get("dataSet_1");
        modificareDate.metodaModificareDate(data);
        delay.metodaDelaySec(2);
        ChainTestListener.log("User successfully updates information using valid credentials");
        LoggerUtility.infoTest("User successfully updates information using valid credentials");
        //Assert
        Assert.assertTrue(modificareDate.outputUsernameText.contains(data.getNume() + " " + data.getPrenume()));
        Assert.assertTrue(modificareDate.outputEmailText.contains(data.getEmail()));
        Assert.assertTrue(modificareDate.outputTelefonText.contains(data.getTelefon()));
        //SCHIMB DATELE CU CELE INITIALE
        delay = new Delay(getDriver());
        delay.metodaDelaySec(4);
        UpdateAccountObjectData data2 = updateAccountObjectDataMap.get("dataSet_2");
        modificareDate.metodaModificareDate(data2);
        ChainTestListener.log("User successfully updates information to the initial one");
        LoggerUtility.infoTest("User successfully updates information to the initial one");
        //Assert
        Assert.assertTrue(modificareDate.outputUsernameText.contains(data2.getNume() + " " + data2.getPrenume()));
        Assert.assertTrue(modificareDate.outputEmailText.contains(data2.getEmail()));
        Assert.assertTrue(modificareDate.outputTelefonText.contains(data2.getTelefon()));
    }
}
