package ProiectOOP.HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Delay {
    WebDriver driver;

    public Delay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void metodaDelaySec(int secunde) {
        try {
            TimeUnit.SECONDS.sleep(secunde);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}


