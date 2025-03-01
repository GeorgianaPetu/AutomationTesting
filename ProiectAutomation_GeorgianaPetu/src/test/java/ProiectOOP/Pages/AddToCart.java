package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AddToCart extends CommonMenu {

    //WebDriver driver;
    ElementsMethods elementsMethods;
    Delay delay;
    CommonMenu commonMenu;

    public AddToCart(WebDriver driver){
        super(driver);
        //this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.delay = new Delay(driver);
        this.commonMenu = new CommonMenu(driver);
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "//*[@title='Oferta produse']")
//    WebElement ofertaProduseMenuButton;

    @FindBy(xpath = "//*[@data-id='4458']") //"//*[@data-id='4458']" // //*[@class='nav-item level-1']//*[@title='CARTI']
    WebElement cartiButton;

    @FindBy(xpath = "//*[@title='Fizica']")
    WebElement cartiFizicaButton;

    @FindBy(id = "order")
    WebElement sortareField;

    @FindBy(xpath = "//*[@data-id='29376']//*[@title='Adauga in cos']")
    WebElement primaCarteButton;

    @FindBy(xpath = "//*[@class='close-button btn nice-btn gray-btn ']")
    WebElement continuaCumparaturileButton;

    @FindBy(xpath = "//*[@data-id='26692']//*[@title='Adauga in cos']")
    WebElement aDouaCarteButton;

    @FindBy(id = "go-to-cart")
    WebElement finalizeazaCumparaturileButton;

    public void metodaAddToCart() {
        clickOnOfertaProduse();
        elementsMethods.clickOnElement(cartiButton);
        elementsMethods.clickOnElement(cartiFizicaButton);
        elementsMethods.fillElement(sortareField, "Popularitate");
        sortareField.sendKeys(Keys.ENTER);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0, 400)");
        delay.metodaDelaySec(1);
        elementsMethods.clickOnElement(primaCarteButton);
        delay.metodaDelaySec(1);
        elementsMethods.clickOnElement(continuaCumparaturileButton);
        elementsMethods.clickOnElement(aDouaCarteButton);
        delay.metodaDelaySec(1);
        elementsMethods.clickOnElement(finalizeazaCumparaturileButton);
        //ASSERT
        //String addedBook1 = "Curiozitati incredibile despre gaurile negre";
        //WebElement searchResult1 = driver.findElement(By.xpath("//*[@class='cart-table-pic']//*[@alt='Curiozitati incredibile despre gaurile negre']"));
        //Assert.assertTrue(searchResult1.getText().contains(addedBook1));
        //String addedBook2 = "Universul intr-o coaja de nuca";
        //WebElement searchResult2 = driver.findElement(By.id("product_338489"));
        //Assert.assertTrue(searchResult2.getText().contains(addedBook2));
        //WebElement totalProduse = driver.findElement(By.xpath("//*[@id=\"ProductChangeInput\"]/div[2]/div/div[2]/div/div[2]/span"));
        //Assert.assertTrue(totalProduse.getText().contains("151.99"));

    }

}
