package WayToAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeFormTest {
    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

    }

    @Test
    void name(){

        //enter first name
        By firstName = new By.ByCssSelector("#userName-wrapper :nth-child(2) input");
        WebElement firstNameEl = driver.findElement(firstName);
        firstNameEl.sendKeys("Lamia");

        //enter last name
        By lastName = new By.ByCssSelector("#userName-wrapper :nth-child(4) input");
        WebElement lastNameEl = driver.findElement(lastName);
        lastNameEl.sendKeys("Hossain");

        //enter email
        By email = new By.ByCssSelector("#userEmail");
        WebElement emailEl = driver.findElement(email);
        emailEl.sendKeys("bjkbddkjf@gmail.com");

        //select genderFemale
        By gender_Female = new By.ByCssSelector("[for=\"gender-radio-2\"]");
        WebElement genderFemale = driver.findElement(gender_Female);
        genderFemale.click();

        //enter mobile number
        By MobileNumber = new By.ByCssSelector("#userNumber-wrapper :nth-child(2) input");
        WebElement MobileNumberEl = driver.findElement(MobileNumber);
        MobileNumberEl.sendKeys("8462847893");

        //DOB
        //By DateOfBirth = new By.ByCssSelector("#dateOfBirth-wrapper :nth-child(2)");
       /// WebElement DateOfBirthEl = driver.findElement(DateOfBirth);
        //DateOfBirthEl.sendKeys("12 June 2022");

        //select subject
        //By Subject = new By.ByCssSelector("#subjectsContainer");
        //WebElement SubjectEl = driver.findElement(Subject);
        //SubjectEl.sendKeys("Accounting");

    }
    //@AfterClass
    //void wrapUp(){
        //driver.quit();
    }

