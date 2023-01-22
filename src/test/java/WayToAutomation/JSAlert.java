package WayToAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSAlert {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/alerts");
    }
    @Test
    void test_Alert1() throws  InterruptedException{
        By LocatorAlertButton = new By.ByCssSelector(".row:first-child button");
        WebElement AlertButton = driver.findElement(LocatorAlertButton);
        AlertButton.click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();


    }
    @Test
    void test_Alert2() throws InterruptedException{
        Thread.sleep(3000);
        WebDriverWait wait =  new WebDriverWait(driver , Duration.ofSeconds(10));
        By LocatorAlertButton = new By.ByCssSelector("#timerAlertButton");
        WebElement AlertButton = driver.findElement(LocatorAlertButton);
        AlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
    @Test
    void test_Alert3() throws InterruptedException{
        Thread.sleep(3000);
        By LocatorAlertButton = new By.ByCssSelector("#confirmButton");
        WebElement AlertButton = driver.findElement(LocatorAlertButton);

        //clicking ok
        AlertButton.click();
        driver.switchTo().alert().accept();

        //confirm the right text shows up
        By resultLocator = new By.ByCssSelector("#confirmResult");
        WebElement resultEl = driver.findElement(resultLocator);


        String result = resultEl.getText();
        Assert.assertTrue(result.contains("Ok"));


        //clicking cancel
        //AlertButton.click();
        //driver.switchTo().alert().dismiss();

        //confirm the right text shows up
        //result = resultEl.getText();
        //Assert.assertTrue(result.contains("Cancel"));

    }
    @Test
    void test_Alert4() throws InterruptedException{
        By promptLocator = new By.ByCssSelector("#promtButton");
        WebElement promptButton = driver.findElement(promptLocator);

        //Negative test
        promptButton.click();
        driver.switchTo().alert().sendKeys("Lamia");
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        By resultSelector = new By.ByCssSelector("#promptResult");
        Assert.assertThrows( () ->driver.findElement(resultSelector) );

        //POSITIVE TEST
        promptButton.click();
        driver.switchTo().alert().sendKeys("Lamia");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        WebElement resultEl = driver.findElement(resultSelector);
        String resultText = resultEl.getText();
        Assert.assertTrue(resultText.contains("Lamia"));


    }

    @AfterClass
    void wrapup() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }
}
