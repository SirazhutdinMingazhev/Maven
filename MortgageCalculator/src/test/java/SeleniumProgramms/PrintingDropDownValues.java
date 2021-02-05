package SeleniumProgramms;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PrintingDropDownValues extends ReusableSeleniumScript{


    public static void main(String [] args) throws IOException {
        launchBrowser("chrome");
        openURL("https://candidate.psiexams.com/catalog/displayagencylicenses.jsp?catalogID=334");
        List<WebElement> sponsorname = driver.findElements(By.xpath("//*[@id='c0']/option"));

        for(int i=0;i<sponsorname.size();i++){
           String values =  sponsorname.get(i).getText();
           System.out.println(i +" : " + values);
        }

        // printing values to excel file
        File f=new File("/Users/sirazhutdinmingazhev/Desktop/SeleniumWorkFolder/ExcelFileForSelenium.xlsx"); // Create an object of File class to open xlsx file
        FileInputStream fi=new FileInputStream(f); //Create an object of FileInputStream class to read excel file // or enter excel file path instead of (f)
        XSSFWorkbook wb=new XSSFWorkbook(fi); // creating object for workbook
        XSSFSheet sh=wb.getSheet("Sheet2"); // reading sheet
       // driver.close();
    }
}
