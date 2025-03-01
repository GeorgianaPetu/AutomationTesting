package ProiectOOP.ShareDataBrowser;

import ProiectOOP.ShareDataBrowser.Browser.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class ShareDataTableQA {
    private WebDriver driver;

//    @BeforeMethod //= initializeaza browserul inainte de metoda test
    public void initializeBrowser(){
        driver = new BrowserFactory().getBrowserFactory();
//        this.driver = new ChromeDriver();
        driver.get("https://vinothqaacademy.com/webtable/");
//        driver.manage().window().maximize();
    }

//    @AfterMethod //= sa inchida browserul dupa metoda de test
    public void clearBrowser(){
        driver.quit();
//        //driver.close(); //alta varianta
    }

    public WebDriver getDriver(){
        return driver;
    }
}
