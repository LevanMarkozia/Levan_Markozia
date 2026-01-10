package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertPage;
import utils.DriverFactory;

import java.time.Duration;

public class AlertTests {

    @Test
    public void test1(){
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Alerts.html");

//        driver.findElement(By.xpath("//a[@href=\"#Textbox\"]")).click();
//        driver.findElement(By.xpath("//button[@onclick=\"promptbox()\"]")).click();
//        Alert alert=driver.switchTo().alert();
//        alert.sendKeys("Levan Markozia");
//        alert.accept();
//        Assert.assertEquals(driver.findElement(By.id("demo1")).getText(),"Hello Levan Markozia How are you today");
        AlertPage alertPage=new AlertPage(DriverFactory.getDriver())
                .triggerTextboxAlert()
                .enterName("Levan Markozia");
        Assert.assertEquals(DriverFactory.getDriver().findElement(By.id("demo1")).getText(),"Hello Levan Markozia How are you today");
    }
}
