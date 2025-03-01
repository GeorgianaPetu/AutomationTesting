package ProiectOOP.ShareDataBrowser;

import ProiectOOP.HelperMethods.PopUp;
import ProiectOOP.ShareDataBrowser.Browser.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class ShareData {
    private WebDriver driver;
    PopUp popUp;

//    @BeforeMethod //= initializeaza browserul inainte de metoda test
    public void initializeBrowser(){
        driver = new BrowserFactory().getBrowserFactory();
//        this.driver = new ChromeDriver();
        driver.get("https://www.librarul.ro/");
        popUp = new PopUp(driver);
        popUp.clickOnPopUp();
//        driver.manage().window().maximize();
//
    }
//
//    @AfterMethod //= sa inchida browserul dupa metoda de test
    public void clearBrowser(){
        driver.quit();
////        //driver.close(); //alta varianta
    }
//
    public WebDriver getDriver(){
        return driver;
    }
}
