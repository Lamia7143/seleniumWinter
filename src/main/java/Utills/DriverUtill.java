package Utills;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverUtill {
    public static WebDriver driver;
    public static WebDriver getWebdriver(){
        WebDriverManager.edgedriver().setup();
        if(driver != null && !driver.toString().contains("null")){
            return driver;
        }
        driver = new EdgeDriver();
        return driver;
    }

    public static void clickUsingJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickUsingJS(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void zoomOutToPercentage(double percentage){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom="+percentage+"'");
    }






}
