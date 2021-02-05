package SeleniumProgramms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands extends ReusableSeleniumScript {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        openURL("https://www.selenium.dev/");
        click(By.linkText("Downloads"));
        click(By.linkText("Projects"));
        click(By.linkText("Documentation"));
        navigate_back();  // checking URL after clicked on back button (checkpoint)
        print(driver.getCurrentUrl());
        navigate_forward();
        print(driver.getCurrentUrl());  // checking URL after clicked on forward button (checkpoint)

        // refreshing page in lot of different ways
        navigate_refresh();
        refresh_webPage_2();
        refresh_webPage_3();
        refresh_webPage_4(By.id("search-by"));
        closeApp();
    }
}
