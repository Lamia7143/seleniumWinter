import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class DemoQA {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://demoqa.com/");

        //Click on the element menu
        By elementLocator = new By.ByCssSelector(" .nt-4:first-child");
        WebElement element = driver.findElement(elementLocator);
        element.click();

        By headerLocator = new By.ByCssSelector(".main-header");
        WebElement header = driver.findElement(headerLocator);
        String headerText = header.getText();
        Assert.assertEquals(headerText, "Elements");
        //if(headerText.equals ("Elements")){

            //System.out.println("'Elements' found in the header" );

        //}else{
            //System.out.println("'Elements' not found in the header");
        //}

        //Click on the logo to come to the home screen
        By logoLocator = new By.ByCssSelector("header ing");
        WebElement logo = driver.findElement( logoLocator );
        logo.click();

        //click on the form menu
        By formsLocator = new By.ByCssSelector(".nt-4:nth-child(2)");
        WebElement forms = driver.findElement(formsLocator);
        forms.click();

        header = driver.findElement( headerLocator );
        headerText = header.getText();
        Assert.assertEquals(headerText, "forms");

        driver.quit();


    }


    }

