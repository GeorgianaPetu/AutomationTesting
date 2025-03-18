package ProiectOOP.Pages;

import ProiectOOP.HelperMethods.ElementsMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class DeleteRow {
    WebDriver driver;
    ElementsMethods elementsMethods;

    public DeleteRow(WebDriver driver){
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"myTable\"]/tbody/tr[1]/td[1]/input")
    WebElement checkBox1;

    @FindBy(xpath = "//*[@id=\"myTable\"]/tbody/tr[2]/td[1]/input")
    WebElement checkBox2;

    @FindBy(id = "deleteBtn")
    WebElement deleteButton;

    public void metodaDeleteRow() {
        elementsMethods.clickOnElement(checkBox1);
        elementsMethods.clickOnElement(checkBox2);
        elementsMethods.clickOnElement(deleteButton);
    }
}
