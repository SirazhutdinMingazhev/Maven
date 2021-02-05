package SeleniumProgramms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Dropdown extends ReusableSeleniumScript{

    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        openURL("https://candidate.psiexams.com/catalog/displayagencylicenses.jsp?catalogID=334");
        waitTime(3000);
        List<WebElement> sponsorname=driver.findElements(By.id("c0"));
        for(int i=0;i<sponsorname.size();i++){
            String values=sponsorname.get(i).getText();
            print(values);
        }
        closeApp();
    }

}
