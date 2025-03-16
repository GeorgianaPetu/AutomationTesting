//package ProiectOOP.Pages;
//
//import ProiectOOP.HelperMethods.Delay;
//import ProiectOOP.HelperMethods.ElementsMethods;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//
//import java.util.concurrent.TimeUnit;
//
//public class AddToCart extends CommonMenu {
//
//    //WebDriver driver;
//    ElementsMethods elementsMethods;
//    Delay delay;
//    CommonMenu commonMenu;
//    public String searchResult1Text;
//    public String searchResult2Text;
//    public String quantityResult1Text;
//    public String quantityResult2Text;
//    public String priceResult1Text;
//    public String priceResult2Text;
//    public String totalProduseText;
//    public String costLivareText;
//
//    public AddToCart(WebDriver driver){
//        super(driver);
//        //this.driver = driver;
//        this.elementsMethods = new ElementsMethods(driver);
//        this.delay = new Delay(driver);
//        this.commonMenu = new CommonMenu(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "//*[@data-id='4458']") //"//*[@data-id='4458']" // //*[@class='nav-item level-1']//*[@title='CARTI']
//    WebElement cartiButton;
//
//    @FindBy(xpath = "//*[@title='Fizica']")
//    WebElement cartiFizicaButton;
//
//    @FindBy(id = "order")
//    WebElement sortareField;
//
//    @FindBy(xpath = "//*[@data-id='29376']//*[@title='Adauga in cos']")
//    WebElement primaCarteButton;
//
//    @FindBy(xpath = "//*[@class='close-button btn nice-btn gray-btn ']")
//    WebElement continuaCumparaturileButton;
//
//    @FindBy(xpath = "//*[@data-id='26692']//*[@title='Adauga in cos']")
//    WebElement aDouaCarteButton;
//
//    @FindBy(id = "go-to-cart")
//    WebElement finalizeazaCumparaturileButton;
//
//    public void metodaAddToCart() {
//        clickOnOfertaProduse();
//        elementsMethods.clickOnElement(cartiButton);
//        elementsMethods.clickOnElement(cartiFizicaButton);
//        elementsMethods.fillElement(sortareField, "Popularitate");
//        sortareField.sendKeys(Keys.ENTER);
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
//        javascriptExecutor.executeScript("window.scrollTo(0, 400)");
//        delay.metodaDelaySec(1);
//        elementsMethods.clickOnElement(primaCarteButton);
//        delay.metodaDelaySec(1);
//        elementsMethods.clickOnElement(continuaCumparaturileButton);
//        elementsMethods.clickOnElement(aDouaCarteButton);
//        delay.metodaDelaySec(1);
//        elementsMethods.clickOnElement(finalizeazaCumparaturileButton);
//        //ASSERT
//        WebElement searchResult1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/main/div[1]/div/div/div[1]/form/div[1]/section/table/tbody/tr[2]/td[1]/a/span[2]"));
//        searchResult1Text = searchResult1.getText();
//        WebElement searchResult2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/main/div[1]/div/div/div[1]/form/div[1]/section/table/tbody/tr[4]/td[1]/a/span[2]"));
//        searchResult2Text = searchResult2.getText();
//        WebElement quantityResult1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/main/div[1]/div/div/div[1]/form/div[1]/section/table/tbody/tr[2]/td[2]/div/input"));
//        quantityResult1Text = quantityResult1.getText();
//        WebElement quantityResult2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/main/div[1]/div/div/div[1]/form/div[1]/section/table/tbody/tr[4]/td[2]/div/input"));
//        quantityResult2Text = quantityResult2.getText();
//        WebElement priceResult1 = driver.findElement(By.xpath("//*[@id=\"ProductChangeInput\"]/div[1]/section/table/tbody/tr[2]/td[3]/div/div[1]"));
//        priceResult1Text = priceResult1.getText();
//        WebElement priceResult2 = driver.findElement(By.xpath("//*[@id=\"ProductChangeInput\"]/div[1]/section/table/tbody/tr[2]/td[3]/div/div[1]"));
//        priceResult2Text = priceResult2.getText();
//        WebElement totalProduse = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/main/div[1]/div/div/div[1]/form/div[1]/section/table/tfoot/tr/td/h6/span"));
//        totalProduseText = totalProduse.getText();
//        WebElement costLivare = driver.findElement(By.xpath("//*[@id=\"ProductChangeInput\"]/div[2]/div/div[1]/div/div[3]/span[2]/span"));
//        costLivareText = costLivare.getText();
//
//        //WebElement totalProduse = driver.findElement(By.xpath("//*[@id=\"ProductChangeInput\"]/div[2]/div/div[2]/div/div[2]/span"));
//        //Assert.assertTrue(totalProduse.getText().contains("151.99"));
//
//    }
//
//}
