package tests;

import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import utils.DriverFactory;

import java.awt.*;

public class AlertTests extends TestBase {

    @Description("Trigger a textbox alert and verify that the output matches the input")
    @Test
    public void test1() throws AWTException {
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Alerts.html");
        AlertPage alertPage=new AlertPage(DriverFactory.getDriver())
                .triggerTextboxAlert()
                .enterName("Levan Markozia");
        Assert.assertEquals(DriverFactory.getDriver().findElement(By.id("demo1")).getText(),"Hello Levan Markozia How are you today");
    }
}
