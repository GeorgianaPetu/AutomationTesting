package ProiectOOP.Pages;

import ObjectData.SearchFunctionalityObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import ProiectOOP.HelperMethods.ScrollMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Search extends CommonMenu{
    ElementsMethods elementsMethods;
    Delay delay;
    ScrollMethod scrollMethod;
    String cuvant;
    String searchedBook1;
    String searchedBook2;
    String searchedBook3;
    String searchedBook4;
    String searchedBook5;
    String searchedBook6;
    String searchedBook7;
    CommonMenu commonMenu;
    public String searchResult1Text;
    public String searchResult2Text;
    public String searchResult3Text;
    public String searchResult4Text;
    public String searchResult5Text;
    public String searchResult6Text;
    public String searchResult7Text;

    @FindBy(id = "order")
    WebElement sortareField;

    @FindBy(xpath = "//*[@title='Tip afisare Lista']")
    WebElement afisareTipListaButton;

    public String getSearchedBook1() {
        return searchedBook1;
    }
    public String getSearchedBook2() {
        return searchedBook2;
    }

    public String getSearchedBook3() {
        return searchedBook3;
    }

    public String getSearchedBook4() {
        return searchedBook4;
    }

    public String getSearchedBook5() {
        return searchedBook5;
    }

    public String getSearchedBook6() {
        return searchedBook6;
    }

    public String getSearchedBook7() {
        return searchedBook7;
    }

    public Search(WebDriver driver) {
        super(driver);
        this.elementsMethods = new ElementsMethods(driver);
        this.scrollMethod = new ScrollMethod(driver);
        this.commonMenu = new CommonMenu(driver);
        this.cuvant = cuvant;
        this.searchedBook1 = searchedBook1;
        this.searchedBook2 = searchedBook2;
        this.searchedBook3 = searchedBook3;
        this.searchedBook4 = searchedBook4;
        this.searchedBook5 = searchedBook5;
        this.searchedBook6 = searchedBook6;
        this.searchedBook7 = searchedBook7;
        this.delay = new Delay(driver);
        PageFactory.initElements(driver, this);
    }

    public void metodaSearch(SearchFunctionalityObjectData data) {
       this.searchedBook1 = data.getSearchedBook1();
       this.searchedBook2 = data.getSearchedBook2();
       this.searchedBook3 = data.getSearchedBook3();
       this.searchedBook4 = data.getSearchedBook4();
       this.searchedBook5 = data.getSearchedBook5();
       this.searchedBook6 = data.getSearchedBook6();
       this.searchedBook7 = data.getSearchedBook7();
        delay.metodaDelaySec(2);
        elementsMethods.assertElementDisplayed(searchBar);
        elementsMethods.assertElementDisplayed(searchButton);
        clickAndFillSearchField(data.getCuvant());         //elementsMethods.clickOnElement(searchBar);//searchBar.sendKeys(cuvant);
        delay.metodaDelaySec(2);
        commonMenu.searchBar.sendKeys(Keys.ARROW_DOWN); // searchBar.sendKeys(Keys.ARROW_DOWN);
        commonMenu.searchBar.sendKeys(Keys.ENTER);
        clickOnSearchButton();
        elementsMethods.fillElement(sortareField, "Nume");
        sortareField.sendKeys(Keys.ENTER);
        elementsMethods.clickOnElement(afisareTipListaButton);
        scrollMethod.metodaScroll(1200);
        //ASSERT
        WebElement searchResult1 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Din lumea celor care nu cuvanta']"));
        searchResult1Text = searchResult1.getText();
        scrollMethod.metodaScroll(-500);
        WebElement searchResult2 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Comoara din insula']"));
        searchResult2Text = searchResult2.getText();
        WebElement searchResult3 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Ciuma stacojie']"));
        searchResult3Text = searchResult3.getText();
        WebElement searchResult4 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Ciulinii baraganului. Codin']"));
        searchResult4Text = searchResult4.getText();
        WebElement searchResult5 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Capitan la 15 ani']"));
        searchResult5Text = searchResult5.getText();
        WebElement searchResult6 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Beau Geste']"));
        searchResult6Text = searchResult6.getText();
        WebElement searchResult7 = driver.findElement(By.xpath("//*[@class='product-name t-font-heading']//*[@title='Balade si idile']"));
        searchResult7Text = searchResult7.getText();
    }
}
