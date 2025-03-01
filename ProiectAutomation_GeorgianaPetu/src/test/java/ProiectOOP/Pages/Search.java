package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Search extends CommonMenu{

    //WebDriver driver;
    ElementsMethods elementsMethods;
    Delay delay;
    String cuvant;
    CommonMenu commonMenu;

    public Search(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.commonMenu = new CommonMenu(driver);
        this.cuvant = cuvant;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "//*[@class='search-query ui-autocomplete-input']")
//    WebElement searchBar;
//
//    @FindBy(xpath = "//*[@class='default t-config-search-color']")
//    WebElement searchButton;

    @FindBy(id = "order")
    WebElement sortareField;

    @FindBy(xpath = "//*[@title='Tip afisare Lista']")
    WebElement afisareTipListaButton;

    public void metodaSearch(String cuvant) {
        delay.metodaDelaySec(2);
        clickAndFillSearchField(cuvant);         //elementsMethods.clickOnElement(searchBar);//searchBar.sendKeys(cuvant);
        delay.metodaDelaySec(2);
        commonMenu.searchBar.sendKeys(Keys.ARROW_DOWN); // searchBar.sendKeys(Keys.ARROW_DOWN);
        commonMenu.searchBar.sendKeys(Keys.ENTER);
        clickOnSearchButton();
        elementsMethods.fillElement(sortareField, "Nume");
        sortareField.sendKeys(Keys.ENTER);
        elementsMethods.clickOnElement(afisareTipListaButton);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollTo(0, 1200)");
        //ASSERT
        String searchedBook1 = "Din lumea celor care nu cuvanta";
        WebElement searchResult1 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Din lumea celor care nu cuvanta']"));
        Assert.assertTrue(searchResult1.getText().contains(searchedBook1));
        javascriptExecutor.executeScript("window.scrollTo(0, -500)");
        String searchedBook2 = "Comoara din insula";
        WebElement searchResult2 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Comoara din insula']"));
        Assert.assertTrue(searchResult2.getText().contains(searchedBook2));
    }
}
