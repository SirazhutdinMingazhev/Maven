package com.psiexams.businessscriptsORtestcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.AssertJUnit;
import org.testng.Assert;
import java.util.List;

import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.psiexams.reusableseleniumscripts.ReusableTestNGSelenium;

/*
all test cases for create an account page will be created here. Reason is for better readability 
for all this test cases pre-requisite is lunch browser, load create an account page etc... 
for this reason we use annotations.
*/

public class CreateAnAccount extends ReusableTestNGSelenium {
	
	String emailID="selenium.test.sirazh@gmail.com";
	String firstName="Sirazh";
	String lastName="Ming";
	String password1="Aa123456$";
	String password2="wrongPassword123$";
	String secQuestion="Pet's Name";
	String secAnswer="Jack";
	
//	@BeforeTest and @AfterTest are relocated to ReusableTestNGSelenium Class

//	@BeforeClass(groups= {"regression","sanity","smoke"})
//	public void clicki_on_CreateAnAccount_link() {
//		click(By.linkText("Create"), "clicking on Create an Account link");
//	}
	
	@Test(priority=0, groups={"regression"})
	public void emailAddressErrorMessage(){
		send_keys(By.name("emailid"),"test","Entrering wrong email ID");
		driver.findElement(By.name("emailid")).sendKeys(Keys.TAB);
		String expectedEmailErrorMessage=driver.findElement(By.className("errorInline")).getText();
		Assert.assertEquals(expectedEmailErrorMessage, "Please provide valid email address.");
	}
	
	@Test(priority=1,groups= {"sanity"})
	public void verifyingErrorMessageForMissingMandatoryFields() {
		send_keys(By.name("emailid"),emailID,"Entering create an account email ID");
		send_keys(By.name("firstname"),firstName,"Entering create an account first name");
		send_keys(By.name("lastname"),lastName,"Entering create an account last name");
		click(By.name("Submit"),"Clicking on submit button");
		String actualText=driver.switchTo().alert().getText();
		Assert.assertEquals(actualText, "Password field cannot be left blank");
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=2,groups= {"regression","sanity"})
	public void verifyingPasswordNotMatchedErrorMessage() throws InterruptedException{
		send_keys(By.name("emailid"),emailID,"Entering create an account email ID");
		send_keys(By.name("firstname"),firstName,"Entering create an account first name");
		send_keys(By.name("lastname"),lastName,"Entering create an account last name");
		send_keys(By.name("password"),password1,"Entering create an account password");
		send_keys(By.name("confirmpassword"),password2,"Retyping create an account password");
		click(By.name("Submit"),"Clicking on submit button");
		Thread.sleep(2000);
		String passwordNotMatched=driver.switchTo().alert().getText();
		Assert.assertEquals(passwordNotMatched, "The Password and Re-entered Password do not match");
		driver.switchTo().alert().accept();
	}
	
	
	
	@DataProvider(name="accountCreation")
	public String[][] readData(){
		String[][] str= {
				{"aaa@gmail.com","Siraj","Ming","Test@1234","Test@1234"},
				{"bbb@gmail.com","Zamir","Daytbegov","Zam@1234","Zam@1234"},
				{"ccc@gmail.com","Renat","Naym","Naym@1234","Naym@1234"}
		};
		return str;
	}
	
	
	@Test(priority=3, groups= {"smoke"},dataProvider="accountCreation")
	public void createAnAccountHappyPath(String emailid, String firstname, String lastname, String password, String retypepassword) throws InterruptedException {
		send_keys(By.name("emailid"),emailid,"Entering create an account email ID");
		waitTime(2000);
		send_keys(By.name("firstname"),firstname,"Entering create an account first name");
		send_keys(By.name("lastname"),lastname,"Entering create an account last name");
		send_keys(By.name("password"),password,"Entering create an account password");
		send_keys(By.name("confirmpassword"),retypepassword,"retyping create an account correct password");
		Select securityQuestion=new Select(driver.findElement(By.name("hintquestion")));
		securityQuestion.selectByVisibleText(secQuestion);
		send_keys(By.name("hintanswer"),secAnswer,"Entering create an account security question");
		//click(By.name("Submit"),"Clicking on submit button");
	}
	
//	@Test(priority=3, groups= {"regression"})
//	public void createAnAccountHappyPath() throws InterruptedException {
//		send_keys(By.name("emailid"),emailID,"Entering create an account email ID");
//		waitTime(2000);
//		send_keys(By.name("firstname"),firstName,"Entering create an account first name");
//		send_keys(By.name("lastname"),lastName,"Entering create an account last name");
//		send_keys(By.name("password"),password1,"Entering create an account password");
//		send_keys(By.name("confirmpassword"),password1,"retyping create an account correct password");
//		Select securityQuestion=new Select(driver.findElement(By.name("hintquestion")));
//		securityQuestion.selectByVisibleText(secQuestion);
//		send_keys(By.name("hintanswer"),secAnswer,"Entering create an account security question");
//		click(By.name("Submit"),"Clicking on submit button");
//	}

	@Test(priority=4,groups= {"sanity"})
	public void verifyingEmailAlreadyExistsErrorMessage() throws InterruptedException {
		send_keys(By.name("emailid"),emailID,"Entering create an account email ID");
		send_keys(By.name("firstname"),firstName,"Entering create an account first name");
		send_keys(By.name("lastname"),lastName,"Entering create an account first name");
		send_keys(By.name("password"),password1,"Entering create an account password");
		send_keys(By.name("confirmpassword"),password1,"retyping create an account correct password");
		Select securityQuestion=new Select(driver.findElement(By.name("hintquestion")));
		securityQuestion.selectByVisibleText(secQuestion);
		send_keys(By.name("hintanswer"),secAnswer,"Entering create an account security question");
		click(By.name("Submit"),"Clicking on submit button");
		String errorMessage=driver.findElement(By.xpath("//*[@id=\'instruction\']/table/tbody/tr/td/ul/li")).getText();
		Assert.assertEquals(errorMessage, "Email already exists. Please enter another Email ID");
		click(By.linkText("Home"),"clicking on Home link to navigate to homepage");
	}
}
