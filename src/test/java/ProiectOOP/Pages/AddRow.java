package ProiectOOP.Pages;

import ObjectData.TableVinothQAObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.HelperMethods.ElementsMethods;
import dataBase.queries.TableVinothQA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRow {
    WebDriver driver;
    ElementsMethods elementsMethods;
    Delay delay;
    String name;
    String role;
    String email;
    String location;
    String department;
    TableVinothQA tableVinothQA;
    public String outputUsernameText;
    public String outputRoleText;
    public String outputEmailText;
    public String outputLocationText;
    public String outputDepartmentText;


    @FindBy(id = "nameInput")
    WebElement numeField;

    @FindBy(id = "roleInput")
    WebElement roleField;

    @FindBy(id = "emailInput")
    WebElement emailField;

    @FindBy(id = "locationInput")
    WebElement locationField;

    @FindBy(id = "departmentInput")
    WebElement departmentField;

    @FindBy(id = "addBtn")
    WebElement addRowButton;


    public AddRow(WebDriver driver) throws SQLException {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.delay = new Delay(driver);
        this.name = name;
        this.role = role;
        this.email = email;
        this.location = location;
        this.department = department;
        tableVinothQA = new TableVinothQA();
        PageFactory.initElements(driver, this); //astfel poate sa gaseasca elementele scrise de mine cu FindBy
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getDepartment() {
        return department;
    }

    public void metodaAddRow(TableVinothQAObjectData data) {
        elementsMethods.assertElementDisplayed(numeField);
        elementsMethods.assertElementDisplayed(roleField);
        elementsMethods.assertElementDisplayed(emailField);
        elementsMethods.assertElementDisplayed(locationField);
        elementsMethods.assertElementDisplayed(departmentField);
        elementsMethods.assertElementDisplayed(addRowButton);

        elementsMethods.fillElement(numeField, data.getName());
        elementsMethods.fillElement(roleField, data.getRole());
        elementsMethods.fillElement(emailField, data.getEmail());
        elementsMethods.fillElement(locationField, data.getLocation());
        elementsMethods.fillElement(departmentField, data.getDepartment());
        elementsMethods.clickOnElement(addRowButton);
        delay.metodaDelaySec(1);

        List<WebElement> listaTabelUpdated = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr"));
        int nrRand = listaTabelUpdated.size();
        //Assert
        WebElement outputUsername = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[2]"));
        WebElement outputRole = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[3]"));
        WebElement outputEmail = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[4]"));
        WebElement outputLocation = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[5]"));
        WebElement outputDepartment = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[6]"));
        outputUsernameText = outputUsername.getText();
        outputRoleText = outputRole.getText();
        outputEmailText = outputEmail.getText();
        outputLocationText = outputLocation.getText();
        outputDepartmentText = outputDepartment.getText();
//        Assert.assertTrue(outputUsername.getText().contains(name));
//        Assert.assertTrue(outputRole.getText().contains(role));
//        Assert.assertTrue(outputEmail.getText().contains(email));
//        Assert.assertTrue(outputLocation.getText().contains(location));
//        Assert.assertTrue(outputDepartment.getText().contains(department));
    }

    public void addEntryInTable(TableVinothQAObjectData data) throws SQLException {
        tableVinothQA.insertTableObject(data);
    }

}
