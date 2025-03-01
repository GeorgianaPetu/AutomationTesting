package ProiectOOP.Tests;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.Pages.AddRow;
import ProiectOOP.Pages.DeleteRow;
import ProiectOOP.ShareDataBrowser.ShareData;
import ProiectOOP.ShareDataBrowser.ShareDataTableQA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
public class TableVinothQAOOPTest extends ShareDataTableQA {
    AddRow addRow;
    DeleteRow deleteRow;
    Delay delay;

    @Test
    public void metodaTest() {
        addRow = new AddRow(getDriver());
        addRow.metodaAddRow("Anca Popescu", "Business Analyst", "anca.popescu@gmail.com", "Galati", "Analysis");
        //Assert
        Assert.assertTrue(addRow.outputUsernameText.contains("Anca Popescu"));
        Assert.assertTrue(addRow.outputRoleText.contains("Business Analyst"));
        Assert.assertTrue(addRow.outputEmailText.contains("anca.popescu@gmail.com"));
        Assert.assertTrue(addRow.outputLocationText.contains("Galati"));
        Assert.assertTrue(addRow.outputDepartmentText.contains("Analysis"));

        addRow.metodaAddRow("Maria Diaconescu", "Project Manager", "maria.diaconescu@gmail.com", "Brasov", "Management");
        //Assert
        Assert.assertTrue(addRow.outputUsernameText.contains("Maria Diaconescu"));
        Assert.assertTrue(addRow.outputRoleText.contains("Project Manager"));
        Assert.assertTrue(addRow.outputEmailText.contains("maria.diaconescu@gmail.com"));
        Assert.assertTrue(addRow.outputLocationText.contains("Brasov"));
        Assert.assertTrue(addRow.outputDepartmentText.contains("Management"));

        deleteRow = new DeleteRow(getDriver());
        deleteRow.metodaDeleteRow();
        //ASSERT
        WebElement outputName1 = getDriver().findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[2]"));
        Assert.assertTrue(outputName1.getText().contains("Vinoth R"));
        WebElement outputName2 = getDriver().findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[2]/td[2]"));
        Assert.assertTrue(outputName2.getText().contains("Samuel Johnson"));
    }
}
