package ProiectOOP.ShareDataBrowser.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeService implements BrowserServiceInterface {
    private WebDriver driver;

    @Override
    public void openBrowser() {
        ChromeOptions options = (ChromeOptions) browserOptions();
        driver = new ChromeDriver(options);
    }

    @Override
    public Object browserOptions() {
        //sesiune 25
        String ci_cd = System.getProperty("ci_cd");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1366,768");

        //sesiune 25 2:00:00
        if (Boolean.parseBoolean(ci_cd)){
            options.addArguments("--headless");
        }

        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
