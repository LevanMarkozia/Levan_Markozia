package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class FormPage extends BasePage{
    private By firstName=By.id("firstName");
    private By lastName=By.id("lastName");
    private By gender=By.xpath("//label[@for=\"gender-radio-1\"]");
    private By userEmail=By.id("userEmail");
    private By userNumber=By.id("userNumber");
    private By dateOfBirthInput=By.id("dateOfBirthInput");
    private By subjectsInput=By.id("subjectsInput");
    private By hobbiesCheckbox1=By.xpath("//label[@for=\"hobbies-checkbox-1\"]");
    private By hobbiesCheckbox2=By.xpath("//label[@for=\"hobbies-checkbox-2\"]");
    private By hobbiesCheckbox3=By.xpath("//label[@for=\"hobbies-checkbox-3\"]");
    private By currentAddress=By.id("currentAddress");
    private By state=By.id("state");
    private By stateSelect=By.xpath("//*[text()=\"NCR\"]");
    private By city=By.id("city");
    private By citySelect=By.xpath("//*[text()=\"Delhi\"]");
    private By submit=By.id("submit");
    public FormPage(WebDriver driver) throws AWTException {
        super(driver);
    }
    public FormPage enterFirstName(String fName){
        type(firstName,fName);
        return this;
    }
    public FormPage enterLastName(String lName){
        type(lastName,lName);
        return this;
    }
    public FormPage selectGender(){
        click(gender);
        return this;
    }
    public FormPage enterEmail(String email){
        type(userEmail,email);
        return this;
    }
    public FormPage enterNumber(String number){
        type(userNumber,number);
        return this;
    }
    public FormPage scrollDown(int amount){
        scroll(amount);
        return this;
    }
    public FormPage enterDoB(String dob1,String dob2) throws InterruptedException {
        click(dateOfBirthInput);
        selectAll(dateOfBirthInput);
        type(dateOfBirthInput,dob1+" "+dob2);
        enter(dateOfBirthInput);
        return this;
    }
    public FormPage enterSubject(String subject){
        type(subjectsInput,subject);
        enter(subjectsInput);
        return this;
    }
    public FormPage selectHobbies(){
        click(hobbiesCheckbox1);
        click(hobbiesCheckbox2);
        click(hobbiesCheckbox3);
        return this;
    }
    public FormPage enterCurrentAddress(String address){
        type(currentAddress,address);
        return this;
    }
    public FormPage enterState(){
        click(state);
        click(stateSelect);
        return this;
    }
    public FormPage enterCity(){
        click(city);
        click(citySelect);
        return this;
    }
    public FormPage submit(){
        click(submit);
        return this;
    }
}
