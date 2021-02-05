package SeleniumProgramms;

import org.openqa.selenium.By;

import java.util.Set;

public class MultipleWindowHandling extends ReusableSeleniumScript{
    public static void main(String[]args){
        launchBrowser("chrome");
        openURL("https://candidate.psiexams.com/");
        String parent_window=driver.getWindowHandle();
        click(By.linkText("PSI Bookstore"));
        Set<String> child_windows=driver.getWindowHandles();
        for(String windownames : child_windows){
            System.out.println(windownames);

            if(!windownames.equals(parent_window)){
                driver.switchTo().window(windownames);
                driver.findElement(By.id("search_queryispbxi_")).sendKeys("book");

            }
        }
        driver.close(); // closes current window
        driver.switchTo().window(parent_window);
        driver.findElement(By.linkText("Academic")).click();
        //driver.quit(); // closes all windows
    }
}
