package SeleniumProgramms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutoComplete extends ReusableSeleniumScript {
    public static void main(String[]args){
        launchBrowser("chrome");
        openURL("https://jqueryui.com/autocomplete/");
        switchToFrame(0);
        send_keys(By.id("tags"),"a");

        List<WebElement> listOfValues=driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
        for(int i=0;i<listOfValues.size();i++){
            String values=listOfValues.get(i).getText();
            if(values.equalsIgnoreCase("basic")){
                listOfValues.get(i).click();
                break;
            }
        }
        //closeApp();
    }

}
