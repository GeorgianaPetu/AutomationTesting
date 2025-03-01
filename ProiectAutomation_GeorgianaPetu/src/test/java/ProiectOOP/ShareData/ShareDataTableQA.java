package ProiectOOP.ShareDataBrowser;

import ProiectOOP.HelperMethods.PopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ShareDataTableQA {
    private WebDriver driver;

    @BeforeMethod //= initializeaza browserul inainte de metoda test
    public void initializeBrowser(){
        this.driver = new ChromeDriver();
        driver.get("https://vinothqaacademy.com/webtable/");
        driver.manage().window().maximize();
    }

//    @AfterMethod //= sa inchida browserul dupa metoda de test
//    public void clearBrowser(){
//        driver.quit();
//        //driver.close(); //alta varianta
//    }

    public WebDriver getDriver(){
        return driver;
    }
}
