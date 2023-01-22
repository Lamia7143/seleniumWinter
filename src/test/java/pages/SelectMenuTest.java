package pages;

import Utills.DriverUtill;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectMenuTest {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = DriverUtill.getWebDriver();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    void SelectValue() throws InterruptedException{
        Thread.sleep(1000);
        By SelectValueLocator = new By.ByCssSelector("#withOptGroup .css-tlfecz-indicatorContainer");
        WebElement SelectValueEl = driver.findElement(SelectValueLocator);
        SelectValueEl.click();

        By SelectOption = new By.ByXPath("//div[contains(text(),'Group 1 option 2)]");
        WebElement SelectOptionEl = driver.findElement(SelectOption);
        SelectOptionEl.click();
        Thread.sleep(2000);
    }



}
