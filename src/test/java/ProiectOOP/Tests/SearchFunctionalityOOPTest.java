package ProiectOOP.Tests;
import Logger.LoggerUtility;
import ObjectData.LoginObjectData;
import ObjectData.SearchFunctionalityObjectData;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.Search;
import ProiectOOP.ShareDataBrowser.Hooks;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class SearchFunctionalityOOPTest extends Hooks {
    Login login;
    Search search;
    private Map<String, LoginObjectData> loginObjectDataMap;
    private Map<String, SearchFunctionalityObjectData> searchFunctionalityObjectDataMap;

    @Test
    public void metodaTest() {
        ChainTestListener.log("Opened with Chrome");
        loginObjectDataMap = xmlReader.loadData("src/test/resources/loginData.xml", LoginObjectData.class);
        login = new Login(getDriver());
        LoginObjectData dataL = loginObjectDataMap.get("dataSet_1");
        login.metodaLogin(dataL);
        ChainTestListener.log("User logs in");
        LoggerUtility.infoTest("User logs in");
        searchFunctionalityObjectDataMap = xmlReader.loadData("src/test/resources/searchFunctionalityData.xml", SearchFunctionalityObjectData.class);
        search = new Search(getDriver());
        SearchFunctionalityObjectData data = searchFunctionalityObjectDataMap.get("dataSet_A");
        search.metodaSearch(data);
        ChainTestListener.log("User clicks on search");
        LoggerUtility.infoTest("User clicks on search");
        //Assert
        Assert.assertTrue(search.searchResult1Text.contains(data.getSearchedBook1()));
        Assert.assertTrue(search.searchResult2Text.contains(data.getSearchedBook2()));
        Assert.assertTrue(search.searchResult3Text.contains(data.getSearchedBook3()));
        Assert.assertTrue(search.searchResult4Text.contains(data.getSearchedBook4()));
        Assert.assertTrue(search.searchResult5Text.contains(data.getSearchedBook5()));
        Assert.assertTrue(search.searchResult6Text.contains(data.getSearchedBook6()));
        Assert.assertTrue(search.searchResult7Text.contains(data.getSearchedBook7()));
        ChainTestListener.log("User sees the searched result on screen");
    }
}


