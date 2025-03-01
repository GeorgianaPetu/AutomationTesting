package ProiectOOP.Tests;
import ObjectData.TableVinothQAObjectData;
import ProiectOOP.HelperMethods.Delay;
import ProiectOOP.Pages.AddRow;
import ProiectOOP.Pages.DeleteRow;
import ProiectOOP.ShareDataBrowser.Hooks;
import ProiectOOP.ShareDataBrowser.HooksTableQA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import xmlReaderUtility.xmlReader;

import java.util.Map;

public class TableVinothQAOOPTest extends HooksTableQA /*ShareDataTableQA*/ {
    AddRow addRow;
    DeleteRow deleteRow;
    Delay delay;
    private Map<String, TableVinothQAObjectData> tableVinothQAObjectDataMap;

    @Test
    public void metodaTest() {
        /*data driven t*/ tableVinothQAObjectDataMap = xmlReader.loadData("src/test/resources/tableVinothQAData.xml", TableVinothQAObjectData.class);
        addRow = new AddRow(getDriver());
        TableVinothQAObjectData data = tableVinothQAObjectDataMap.get("dataSet_1");
        addRow.metodaAddRow(data);
        //Assert
        Assert.assertTrue(addRow.outputUsernameText.contains(data.getName()));
        Assert.assertTrue(addRow.outputRoleText.contains(data.getRole()));
        Assert.assertTrue(addRow.outputEmailText.contains(data.getEmail()));
        Assert.assertTrue(addRow.outputLocationText.contains(data.getLocation()));
        Assert.assertTrue(addRow.outputDepartmentText.contains(data.getDepartment()));

        TableVinothQAObjectData data2 = tableVinothQAObjectDataMap.get("dataSet_2");
        addRow.metodaAddRow(data2);
        //Assert
        Assert.assertTrue(addRow.outputUsernameText.contains(data2.getName()));
        Assert.assertTrue(addRow.outputRoleText.contains(data2.getRole()));
        Assert.assertTrue(addRow.outputEmailText.contains(data2.getEmail()));
        Assert.assertTrue(addRow.outputLocationText.contains(data2.getLocation()));
        Assert.assertTrue(addRow.outputDepartmentText.contains(data2.getDepartment()));

        deleteRow = new DeleteRow(getDriver());
        deleteRow.metodaDeleteRow();
        //ASSERT
        WebElement outputName1 = getDriver().findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[2]"));
        Assert.assertTrue(outputName1.getText().contains("Vinoth R"));
        WebElement outputName2 = getDriver().findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr[2]/td[2]"));
        Assert.assertTrue(outputName2.getText().contains("Samuel Johnson"));
    }
}
