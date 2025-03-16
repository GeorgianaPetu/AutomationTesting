package ProiectOOP.Tests;
import Logger.LoggerUtility;
import ObjectData.LoginObjectData;
import ObjectData.SearchFunctionalityObjectData;
import ProiectOOP.Pages.Login;
import ProiectOOP.Pages.Search;
import ProiectOOP.ShareDataBrowser.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class SearchFunctionalityOOPTest extends Hooks /*ShareData*/ {
    Login login;
    Search search;
    //CautareAvansata cautareAvansata;
    private Map<String, LoginObjectData> loginObjectDataMap;
    private Map<String, SearchFunctionalityObjectData> searchFunctionalityObjectDataMap;

    @Test
    public void metodaTest() {
        /*data driven t*/ loginObjectDataMap = xmlReader.loadData("src/test/resources/loginData.xml", LoginObjectData.class);
        login = new Login(getDriver());
        LoginObjectData dataL = loginObjectDataMap.get("dataSet_1");
        login.metodaLogin(dataL);
        LoggerUtility.infoTest("The user logs in");
        searchFunctionalityObjectDataMap = xmlReader.loadData("src/test/resources/searchFunctionalityData.xml", SearchFunctionalityObjectData.class);
        search = new Search(getDriver());
        SearchFunctionalityObjectData data = searchFunctionalityObjectDataMap.get("dataSet_A");
        search.metodaSearch(data);
        LoggerUtility.infoTest("The user clicks on search");
        //Assert
        Assert.assertTrue(search.searchResult1Text.contains(data.getSearchedBook1()));
        //Assert.assertEquals();
        Assert.assertTrue(search.searchResult2Text.contains(data.getSearchedBook2()));
        Assert.assertTrue(search.searchResult3Text.contains(data.getSearchedBook3()));
        Assert.assertTrue(search.searchResult4Text.contains(data.getSearchedBook4()));
        Assert.assertTrue(search.searchResult5Text.contains(data.getSearchedBook5()));
        Assert.assertTrue(search.searchResult6Text.contains(data.getSearchedBook6()));
        Assert.assertTrue(search.searchResult7Text.contains(data.getSearchedBook7()));

        //cautareAvansata = new CautareAvansata(getDriver(),"Pov", "3", "100");
        //cautareAvansata.metodaCautareAvansata();
    }
}


