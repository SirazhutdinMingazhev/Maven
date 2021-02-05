package Homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.psiexams.reusableseleniumscripts.ReusableTestNGSelenium;

public class dataProvider extends ReusableTestNGSelenium{
	
//	@BeforeMethod
//	public void abcd() {
//		
//	}
	
//	@DataProvider(name="entries")
//	public String[][] dataSimple(){
//		String[][] myStr= {  {"love"},{"life"},{"freedom"}  };
//		return myStr;
//	}
//	
//	
//	@Test(groups= {"adhoc"},dataProvider="entries")
//	public void qwerty(String str) throws InterruptedException {
//		send_keys(By.name("emailid"),str,"entering different sets of text");
//		Thread.sleep(3000);
//	}
	
//	@BeforeClass(groups= {"adhoc"})
//	public void clickonCreateAnAccountLink() {
//		click(By.linkText("Create"),"clicking on Create an account link");
//	}
//	
//	@DataProvider(name="allScenarios")
//	public String[][] my2dimArray(){
//		String[][] myString= {
//				{"Matt@gmail.com","Matt","Travis"},{"john@gmail.com","John","Naym"},{"Peter@gmail.com","Peter","Gass"}
//		};
//		return myString;
//	}
//	
//	@Test(groups= {"adhoc"},dataProvider="allScenarios")
//	public void verifyingErrorMessageForMissingMandatoryFields(String emailID,String firstName, String lastName) throws InterruptedException {
//		send_keys(By.name("emailid"),emailID,"Entering create an account email ID");
//		send_keys(By.name("firstname"),firstName,"Entering create an account first name");
//		send_keys(By.name("lastname"),lastName,"Entering create an account last name");
//		click(By.name("Submit"),"Clicking on submit button");
//		String actualText=driver.switchTo().alert().getText();
//		Assert.assertEquals(actualText, "Password field cannot be left blank");
//		driver.switchTo().alert().accept();
//		Thread.sleep(3000);
//	}
	
	@DataProvider(name="someName")
	public String[][] twoDimArray(){
		String[][] qwerty= {
				{"aaa"},{"ccc"},{"ddd"}
		};
		return qwerty;
	}
	
	@Test(groups= {"adhoc"}, dataProvider="someName")
	public void abcdefg(String somestring) throws InterruptedException {
		send_keys(By.name("emailid"),somestring,"stepname here");
		Thread.sleep(3000);
	}

	

}
