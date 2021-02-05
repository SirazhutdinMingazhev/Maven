package SeleniumProgramms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTableDemo extends ReusableSeleniumScript{
    public static void main(String[] args){
        launchBrowser("chrome");
        openURL("https://money.rediff.com/gainers/bsc/dailygropa?");
        WebElement web_tableBody=driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody"));
        List<WebElement> table_row = web_tableBody.findElements(By.tagName("tr"));

        for(int row=0;row<2;row++){
            List<WebElement> table_col =table_row.get(row).findElements(By.tagName("td"));
            for(int col=0;col<table_col.size();col++){
                String values=table_col.get(col).getText();
                print(values);
            }
            print("");
        }
    }
}
