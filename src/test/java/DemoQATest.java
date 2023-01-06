import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQATest {
    WebDriver driver;
    WebElement header;
    By headerLocator;
    String headerText;

    //declare and initialize driver
    @BeforeClass
    void setup(){

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/"); //.get() method to navigate to a website

    }

    @Test
    void testsetup(){
        //click on the element menu
        By elementLocator = new By.ByCssSelector(".mt-4:first-child");
        WebElement element = driver.findElement(elementLocator);
        element.click();


        //header element
        headerLocator = new By.ByCssSelector(".main-header");
        header = driver.findElement(headerLocator);
        headerText = header.getText();
        Assert.assertEquals(headerText,"Elements");
    }

    @Test
    void testform(){
        //click on the logo to come to the home screen
        By logoLocator = new By.ByCssSelector("header ing");
        WebElement logo = driver.findElement(logoLocator);
        logo.click();

        //click on the form menu
        By formsLocator = new By.ByCssSelector(".mt-4:nth-child(2)");
        WebElement forms = driver.findElement(formsLocator);
        forms.click();

        header = driver.findElement(headerLocator);
        headerText = header.getText();
        Assert.assertEquals(headerText, "Forms");
    }

    @AfterClass
    void wrapUp(){
        //quitting the browser
        driver.quit();
    }

}
