package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonMenu {
    WebDriver driver;
    ElementsMethods elementsMethods;
    String cuvant;

    public CommonMenu(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.cuvant = cuvant;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Contul meu']")
    WebElement contulMeuButton;

    @FindBy(xpath = "//*[@class='btn nice-btn t-call-to-action t-action-text ']")
    WebElement intraInContButton;

    @FindBy(xpath = "//*[@class='search-query ui-autocomplete-input']")
    WebElement searchBar;

    @FindBy(xpath = "//*[@class='default t-config-search-color']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@title='Oferta produse']")
    WebElement ofertaProduseMenuButton;

    public void clickContulMeu(){
        elementsMethods.clickOnElement(contulMeuButton);
    }
    public void clickIntraInCont(){
        elementsMethods.clickOnElement(intraInContButton);
    }
    public void clickAndFillSearchField(String cuvant){
        elementsMethods.clickOnElement(searchBar);
        searchBar.sendKeys(cuvant);
    }
    public void clickOnSearchButton(){
        elementsMethods.clickOnElement(searchButton);
    }
    public void clickOnOfertaProduse() {
        elementsMethods.clickOnElement(ofertaProduseMenuButton);
    }
}
