package SeleniumProgramms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollBarActions extends ReusableSeleniumScript {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        openURL("http://automationpractice.com/index.php?id_category=9&controller=category");
        waitTime(3000);
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement checkbox=driver.findElement(By.xpath("//*[@id='layered_condition_new']"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
    }
}
