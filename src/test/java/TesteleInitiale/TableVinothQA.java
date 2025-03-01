package TesteleInitiale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TableVinothQA {

    WebDriver driver;

    @Test

    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://vinothqaacademy.com/webtable/");
        driver.manage().window().maximize();

        metodaAddRow("Anca Popescu", "Business Analyst", "anca.popescu@gmail.com", "Galati", "Analysis");
        metodaAddRow("Maria Diaconescu", "Project Manager", "maria.diaconescu@gmail.com", "Brasov", "Management");
        //metodaDeleteRow();
    }

    public void metodaAddRow(String name, String role, String email, String location, String department){
        WebElement numeField = driver.findElement(By.id("nameInput"));
        numeField.sendKeys(name);

        WebElement roleField = driver.findElement(By.id("roleInput"));
        roleField.sendKeys(role);

        WebElement emailField = driver.findElement(By.id("emailInput"));
        emailField.sendKeys(email);

        WebElement locationField = driver.findElement(By.id("locationInput"));
        locationField.sendKeys(location);

        WebElement departmentField = driver.findElement(By.id("departmentInput"));
        departmentField.sendKeys(department);

        WebElement addRowButton = driver.findElement(By.id("addBtn"));
        addRowButton.click();

        List<WebElement> listaTabelUpdated = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr"));
        int nrRand = listaTabelUpdated.size();

        //Assert
        WebElement outputUsername = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[2]"));
        WebElement outputRole = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[3]"));
        WebElement outputEmail = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[4]"));
        WebElement outputLocation = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[5]"));
        WebElement outputDepartment = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[" + nrRand + "]/td[6]"));
        Assert.assertTrue(outputUsername.getText().contains(name));
        Assert.assertTrue(outputRole.getText().contains(role));
        Assert.assertTrue(outputEmail.getText().contains(email));
        Assert.assertTrue(outputLocation.getText().contains(location));
        Assert.assertTrue(outputDepartment.getText().contains(department));
    }

    public void metodaDeleteRow(){
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[1]/input"));
        checkBox1.click();

        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[2]/td[1]/input"));
        checkBox2.click();

        WebElement deleteButton = driver.findElement(By.id("deleteBtn"));
        deleteButton.click();
    }

}
