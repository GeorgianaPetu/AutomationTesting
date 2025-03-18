package ProiectOOP.Tests;
import Logger.LoggerUtility;
import ObjectData.TableVinothQAObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.Pages.AddRow;
import ProiectOOP.Pages.DeleteRow;
import ProiectOOP.ShareDataBrowser.Hooks;
import ProiectOOP.ShareDataBrowser.HooksTableQA;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.sql.SQLException;
import java.util.Map;

public class TableVinothQAOOPTest extends HooksTableQA {
    AddRow addRow;
    DeleteRow deleteRow;
    Delay delay;
    private Map<String, TableVinothQAObjectData> tableVinothQAObjectDataMap;

    @Test
    public void metodaTest() {
        ChainTestListener.log("Opened with Chrome");
        tableVinothQAObjectDataMap = xmlReader.loadData("src/test/resources/tableVinothQAData.xml", TableVinothQAObjectData.class);
        addRow = new AddRow(getDriver());
        TableVinothQAObjectData data = tableVinothQAObjectDataMap.get("dataSet_1");
        addRow.metodaAddRow(data);
        ChainTestListener.log("User adds one entry using valid credentials");
        LoggerUtility.infoTest("User adds one entry using valid credentials");
        //Assert
        Assert.assertTrue(addRow.outputUsernameText.contains(data.getName()));
        Assert.assertTrue(addRow.outputRoleText.contains(data.getRole()));
        Assert.assertTrue(addRow.outputEmailText.contains(data.getEmail()));
        Assert.assertTrue(addRow.outputLocationText.contains(data.getLocation()));
        Assert.assertTrue(addRow.outputDepartmentText.contains(data.getDepartment()));

        TableVinothQAObjectData data2 = tableVinothQAObjectDataMap.get("dataSet_2");
        addRow.metodaAddRow(data2);
        ChainTestListener.log("User adds the second entry using valid credentials");
        LoggerUtility.infoTest("User adds the second entry using valid credentials");
        //Assert
        Assert.assertTrue(addRow.outputUsernameText.contains(data2.getName()));
        Assert.assertTrue(addRow.outputRoleText.contains(data2.getRole()));
        Assert.assertTrue(addRow.outputEmailText.contains(data2.getEmail()));
        Assert.assertTrue(addRow.outputLocationText.contains(data2.getLocation()));
        Assert.assertTrue(addRow.outputDepartmentText.contains(data2.getDepartment()));

        deleteRow = new DeleteRow(getDriver());
        deleteRow.metodaDeleteRow();
        ChainTestListener.log("User deletes one entry");
        LoggerUtility.infoTest("User deletes one entry");
        //ASSERT
        WebElement outputName1 = getDriver().findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[2]"));
        Assert.assertTrue(outputName1.getText().contains("Vinoth R"));
        WebElement outputName2 = getDriver().findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[2]/td[2]"));
        Assert.assertTrue(outputName2.getText().contains("Samuel Johnson"));
    }
}
