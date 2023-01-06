package WayToAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RegistrationFormTest {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");


    }

    @Test
    void completeRegistration() throws InterruptedException {
        //locator for Registration menu
        By regLink = new By.ByCssSelector(".linkbox:nth-child(5) a");
        WebElement reglinkElement = driver.findElement(regLink);
        reglinkElement.click();
        Thread.sleep(1000);


        //steps to get all opened tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        String secondTabAddress = tabs.get(1);

        //navigate to tab #2
        driver.switchTo().window(secondTabAddress);

        Thread.sleep(5000);

        //enter first name
        By firstName = new By.ByCssSelector("fieldset:first-child p:first-child input");
        WebElement firstnameEl = driver.findElement(firstName);
        firstnameEl.sendKeys("Lamia");

        //enter last name
        By lastName = new By.ByCssSelector("fieldset:first-child p:last-child input");
        WebElement lastNameEl = driver.findElement(lastName);
        lastNameEl.sendKeys("Hossain");

        //Select married
        By Married = new By.ByCssSelector("label:nth-child(2) [name='m_status']");
        WebElement MarriedRadio = driver.findElement(Married);
        MarriedRadio.click();

        //select hobby reading
        By reading = new By.ByCssSelector("label:nth-child(2) [name='hobby']");
        WebElement readingCheckbox = driver.findElement(reading);
        readingCheckbox.click();

        //select country
        By country = new By.ByCssSelector("fieldset:nth-child(4) select");
        Select countryselect = new Select(driver.findElement(country));
        countryselect.selectByVisibleText("India");

        ////select month
        By month = new By.ByCssSelector(".time_feild:nth-child(2) select");
        Select monthselect = new Select(driver.findElement(month));
        monthselect.selectByVisibleText("1");

        //select day
        By day = new By.ByCssSelector(".time_feild:nth-child(3) select");
        Select dayselect = new Select(driver.findElement(day));
        dayselect.selectByVisibleText("1");

        //select year
        By year = new By.ByCssSelector(".time_feild:nth-child(4) select");
        Select yearselect = new Select(driver.findElement(year));
        yearselect.selectByVisibleText("2014");

        //select phone number
        By phoneNumber = new By.ByCssSelector("fieldset [name='phone']");
        WebElement phoneNumberEl = driver.findElement(phoneNumber);
        phoneNumberEl.sendKeys("9877356");

        //select username
        By userName = new By.ByCssSelector("fieldset [name='username']");
        WebElement userNameEl = driver.findElement(userName);
        userNameEl.sendKeys("Lamia Hossain");


        //select email
        By email = new By.ByCssSelector("fieldset [name= 'email']");
        WebElement emailEl = driver.findElement(email);
        emailEl.sendKeys("jdhjd@gmail.com");

        //select profile picture
        // By profilepicture = new By.ByCssSelector("fieldset [type='file']");
        // WebElement profilepictureEl = driver.findElement(profilepicture);
        //profilepictureEl.sendKeys("\"C:\\Users\\hossa\\Downloads\\pexels-louis-2101187.jpg\"");

        //write about yourself
        By aboutyourself = new By.ByCssSelector("fieldset [rows= '5']");
        WebElement aboutyourselfEl = driver.findElement(aboutyourself);
        aboutyourselfEl.sendKeys("kjhiohiherigherkgkjdfvkjdfb");


        // password
        By password = new By.ByCssSelector("fieldset [name= 'password']");
        WebElement passwordEl = driver.findElement(password);
        passwordEl.sendKeys("Lamia7143");

        //confirm password
        By confirmpassword = new By.ByCssSelector("fieldset [name= 'c_password']");
        WebElement confirmpasswordEl = driver.findElement(confirmpassword);
        confirmpasswordEl.sendKeys("Lamia7143");

        //select submit
        By submit = new By.ByCssSelector("fieldset [value='submit']");
        WebElement submitCheckbox = driver.findElement(submit);
        submitCheckbox.click();

    }

    // @AfterClass
    void wrapUp() {
        driver.quit();
    }
}


