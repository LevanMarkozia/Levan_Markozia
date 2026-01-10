package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class AlertPage extends BasePage{
    private By textbox=By.xpath("//a[@href=\"#Textbox\"]");
    private By promptbox=By.xpath("//button[@onclick=\"promptbox()\"]");
    public AlertPage(WebDriver driver){
        super(driver);
    }
    public AlertPage triggerTextboxAlert(){
        click(textbox);
        click(promptbox);
        return this;
    }
    public AlertPage enterName(String name){
        Alert alert=DriverFactory.getDriver().switchTo().alert();
        typeAlert(name);
        alert.accept();
        return this;
    }
}
