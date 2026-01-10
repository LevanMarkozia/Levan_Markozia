package tests;

import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.DriverFactory;

import java.awt.*;
import java.util.List;

public class FormTests extends TestBase{

    @Description("Enter dummy user credentials and submit, then verify that the output matches the input")
    @Test
    public void test1() throws AWTException, InterruptedException {
        DriverFactory.getDriver().get("https://demoqa.com/automation-practice-form");
        String fname="Levan",lname="Markozia",email="email@mail.com",mobile="1234567890",dob1="03 June",dob2="2006",subj1="English",subj2="Chemistry",address="Street Street 123",state="NCR",city="Delhi";
        FormPage formPage=new FormPage(DriverFactory.getDriver())
                .enterFirstName(fname)
                .enterLastName(lname)
                .selectGender()
                .enterEmail(email)
                .scrollDown(5)
                .enterSubject(subj1)
                .enterSubject(subj2)
                .selectHobbies()
                .enterCurrentAddress(address)
                .enterState()
                .enterCity()
                .enterDoB(dob1,dob2)
                .enterNumber(mobile)
                .submit();

        List<WebElement> table=DriverFactory.getDriver().findElements(By.xpath("//td"));
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