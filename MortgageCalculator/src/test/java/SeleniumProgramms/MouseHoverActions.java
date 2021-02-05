package SeleniumProgramms;

import org.openqa.selenium.By;

public class MouseHoverActions extends ReusableSeleniumScript {
    public static void main(String[] arghs) throws InterruptedException {
        launchBrowser("chrome");
        openURL("https://www.flipkart.com/");
        // mouse hovering action
        mouseHover(By.xpath("//*[@id='container']/div/div[2]/div/div/span[1]"));
        click(By.linkText("Mi"));
        get_text(By.className("_10rmr"));
        closeApp();
    }
}