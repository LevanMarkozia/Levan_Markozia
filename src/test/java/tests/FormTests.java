package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class FormTests {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1() throws AWTException {
        driver.get("https://demoqa.com/automation-practice-form");
        String fname="Levan",lname="Markozia",email="email@mail.com",mobile="1234567890",dob1="03 June",dob2="2006",subj1="English",subj2="Chemistry",address="Street Street 123",state="NCR",city="Delhi";
        Robot robot=new Robot();

        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
        driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]")).click();
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userNumber")).sendKeys(mobile);
        robot.mouseWheel(5);
        driver.findElement(By.id("dateOfBirthInput")).click();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(dob1+" "+dob2);
        driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("subjectsInput")).sendKeys("English");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("subjectsInput")).sendKeys("Chemistry");
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//label[@for=\"hobbies-checkbox-1\"]")).click();
        driver.findElement(By.xpath("//label[@for=\"hobbies-checkbox-2\"]")).click();
        driver.findElement(By.xpath("//label[@for=\"hobbies-checkbox-3\"]")).click();
        driver.findElement(By.id("currentAddress")).sendKeys(address);
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//*[text()=\""+state+"\"]")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//*[text()=\""+city+"\"]")).click();
        driver.findElement(By.id("submit")).click();

        List<WebElement> table=driver.findElements(By.xpath("//td"));
        Assert.assertEquals(table.get(1).getText(),fname+" "+lname,"Displayed name is incorrect");
        Assert.assertEquals(table.get(3).getText(),email,"Displayed email is incorrect");
        Assert.assertEquals(table.get(5).getText(),"Male","Displayed gender is incorrect");
        Assert.assertEquals(table.get(7).getText(),mobile,"Displayed phone number is incorrect");
        Assert.assertEquals(table.get(9).getText(),dob1+","+dob2,"Displayed date of birth is incorrect");
        Assert.assertEquals(table.get(11).getText(),subj1+", "+subj2,"Displayed subjects are incorrect");
        Assert.assertEquals(table.get(13).getText(),"Sports, Reading, Music","Displayed hobbies are incorrect");
        Assert.assertEquals(table.get(17).getText(),address,"Displayed address is incorrect");
        Assert.assertEquals(table.get(19).getText(),state+" "+city,"Displayed state and/or city are incorrect");
    }
}