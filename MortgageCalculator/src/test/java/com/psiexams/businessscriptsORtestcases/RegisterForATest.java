package com.psiexams.businessscriptsORtestcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.psiexams.reusableseleniumscripts.ReusableTestNGSelenium;

public class RegisterForATest extends ReusableTestNGSelenium {
    
//	@BeforeTest and @AfterTest are relocated to ReusableTestNGSelenium Class
	
	@BeforeClass
	public void clicki_on_RegisterForAnExamination_link() {
		click(By.linkText("Register"), "clicking on Register for an examination link");
	}
	
	@Test(priority=5,groups= {"regression"})
	public void registerforATest() throws IOException, FileNotFoundException {
		File f=new File("/Users/sirazhutdinmingazhev/Desktop/SeleniumWorkFolder/ExcelFileForSelenium.xlsx"); 
	    FileInputStream fi=new FileInputStream(f);
	    XSSFWorkbook wb=new XSSFWorkbook(fi); 
	    XSSFSheet sh=wb.getSheet("Sheet5");
		click(By.linkText("Register for a test"), "clicking on the register for a test link");
		dropdown_selection(By.id("c0"),"Certification/Professional Associations");
//		Select organization=new Select(driver.findElement(By.id("c0")));
//		organization.selectByVisibleText("Certification/Professional Associations");
		dropdown_selection(By.id("c1"),"ACTION Certification");
//		Select sponsorname=new Select(driver.findElement(By.id("c1")));
//		sponsorname.selectByVisibleText("ACTION Certification");
		click(By.linkText("ACTION Certified Personal Trainer Examination"),"clicking on Examination Name");
		String parent_window=driver.getWindowHandle();
		click(By.linkText("Test Centers"),"clicking on Test Centers link");
		Set<String> child_windows=driver.getWindowHandles();
		for(String windownames : child_windows){
            System.out.println(windownames);
            if(!windownames.equals(parent_window)){
                driver.switchTo().window(windownames);
                break;
            }
        }
		 WebElement table_body=driver.findElement(By.xpath("//*[@id=\'testcenterdetailsTable\']/tbody"));
         List<WebElement> rows=table_body.findElements(By.tagName("tr"));
         for(int i=0;i<rows.size();i++) {
         	List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
         	for(int j=0;j<columns.size();j++) {
         		String values=columns.get(j).getText();
         		if(sh.getRow(i)!=null) {
         			sh.getRow(i).createCell(j).setCellValue(values);
         		}else {
         			sh.createRow(i).createCell(j).setCellValue(values);
         		}
         	}
         }
         FileOutputStream fo=new FileOutputStream(f);
         wb.write(fo);
         fo.close();
         wb.close();
         fi.close();
         driver.close();
         driver.switchTo().window(parent_window);
         driver.quit();
	//	click(By.linkText("Logout"),"clickong on Log in button on parrent window");
	}
	

	@Test(priority=6,groups= {"regression","sanity"})
	public void examinationTestDates() throws InterruptedException, IOException {
		launchBrowser("chrome");
		driver.get("https://candidate.psiexams.com/catalog/agency_license_details_home.jsp?testid=2662#");
		File f=new File("/Users/sirazhutdinmingazhev/Desktop/SeleniumWorkFolder/ExcelFileForSelenium.xlsx"); 
        FileInputStream fi=new FileInputStream(f);
        XSSFWorkbook wb=new XSSFWorkbook(fi);
        XSSFSheet sh=wb.getSheet("Sheet6");
		click(By.xpath("//*[@id=\'tb2\']/table[1]/tbody/tr[14]/td/input[2]"), "clicking on Sign In button");
		send_keys(By.name("emailid"), "selenium.test.sirazh@gmail.com", "entering email address");
		send_keys(By.name("password"),"Aa123456$", "entering password");
		Thread.sleep(3000);
		click(By.name("loginbtn"),"clicking on Sign In button");
		click(By.linkText("Find test date"),"clicking on Find a test date link");
		dropdown_selection(By.id("c0"),"Certification/Professional Associations");
		dropdown_selection(By.id("c1"),"ACTION Certification");
		click(By.id("radio0"),"set ACTION Certified Personal Trainer Examination radio button ON");
		click(By.id("Continue"),"clicking on Continue button");
		dropdown_selection(By.id("testcentercountry")," CANADA");
		send_keys(By.id("autoSuggestField"),"Alberta","typing city name");
		click(By.xpath("//*[@id=\'zip_list\']/ul/li/b"), "selecting city from city name selecton listbox");
		click(By.id("Searchbtn"),"clicking on Search button");
		click(By.id("TestCenterCB_2"),"clicking on second test center checkbox");
		click(By.id("Submit4"),"clicking on continue button");
		WebElement sessionFromDate = driver.findElement(By.id("startDateInput"));
        ((JavascriptExecutor)driver).executeScript ("document.getElementById('startDateInput').removeAttribute('readonly',0);");
        sessionFromDate.clear();
        sessionFromDate.sendKeys("01/30/2021");
        WebElement sessionToDate = driver.findElement(By.id("endDateInput"));
        ((JavascriptExecutor)driver).executeScript ("document.getElementById('endDateInput').removeAttribute('readonly',0);");
        sessionToDate.clear();
        sessionToDate.sendKeys("02/03/2021");
        click(By.name("Submit3"),"clicking on  Find button");
        WebElement testDate_tbody=driver.findElement(By.xpath("//*[@id=\'TCSessionsTbl\']/tbody"));
        List<WebElement> table_rows=testDate_tbody.findElements(By.tagName("tr"));
        for(int i=0;i<=table_rows.size()-1;i++) {
        	List<WebElement> table_columns=table_rows.get(i).findElements(By.tagName("td"));
        	for(int j=0;j<=table_columns.size()-1;j++) {
        		String values=table_columns.get(j).getText();
        		System.out.println(values);
        		if(sh.getRow(i)!=null) {
        			sh.getRow(i).createCell(j).setCellValue(values);
        		}else {
        			sh.createRow(i).createCell(j).setCellValue(values);
        		}
        	}
        }
        FileOutputStream fos=new FileOutputStream(f);
        wb.write(fos);

        fos.close();
        wb.close();
        fi.close();
		
	}
}

