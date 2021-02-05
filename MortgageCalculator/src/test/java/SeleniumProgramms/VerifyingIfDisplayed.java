package SeleniumProgramms;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyingIfDisplayed extends ReusableSeleniumScript{
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        openURL("https://www.bing.com/");
        isLogoDisplayed(By.id("bLogo")); // verifying if the Logo is displayed
        isSearchboxEnabled(By.id("sb_form_q")); // verifying if Search-box is enabled
        click(By.id("id_sc"));
        click(By.id("hbsettings"));
        click(By.linkText("More"));
        isRadiobuttonSelected(By.id("adlt_set_strict")); // verifying if Radio-button is Set ON
        closeApp();
    }
}
