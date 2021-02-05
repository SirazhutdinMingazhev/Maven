package com.psiexams.reusableseleniumscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableTestNGSelenium {
		public static WebDriver driver;
	    public static JavascriptExecutor js;
	    public static Actions action;
	    	
	    public static void launchBrowser(String browsername){
	        try{if(browsername.equalsIgnoreCase("chrome")){
	        	WebDriverManager.chromedriver().setup();
	           // System.setProperty("webdriver.chrome.driver","/Users/sirazhutdinmingazhev/Desktop/chromedriverFile/chromedriver");
	            driver=new ChromeDriver();
	       //     driver.manage().deleteAllCookies();
	        }
	        else if(browsername.equalsIgnoreCase("firefox")){
	        	WebDriverManager.firefoxdriver().setup();
	       	// System.setProperty("webdriver.gecko.driver","/Users/sirazhutdinmingazhev/Desktop/FireFoxDriverFile/geckodriver"); // change path
	            driver= new FirefoxDriver();
	       //     driver.manage().deleteAllCookies();
	        }
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }

	        driver.manage().window().maximize(); // maximizing the browser/window
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait (wait until object loaded)
	    }

	    public static void waitTime(int mlsnds) throws InterruptedException {
	        Thread.sleep(mlsnds);
	    }

	    public static void openURL(String url){
	        try{
	        	driver.get(url);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void click(By locatorname,String stepname){
	        try{
	        	driver.findElement(locatorname).click();
	        	Reporter.log(stepname);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void find_element(By locatorname, String stepname){
	        try{
	        	driver.findElement(locatorname);
	        	Reporter.log(stepname);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void send_keys(By locatorname, String text, String stepname){
	        try{
	        	driver.findElement(locatorname).clear();
	        	driver.findElement(locatorname).sendKeys(text);
	        	Reporter.log(stepname + " : "+ text);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void selectSponsorName(By locatorname, String stepname){
	        try{
	        	Select sponsorname=new Select(driver.findElement(locatorname));
	        	sponsorname.selectByIndex(4); // option 1
	        	Reporter.log(stepname);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	        //sponsorname.selectByValue("736^-99"); // option 2
	        //sponsorname.selectByVisibleText("ATI TEAS"); // option 3
	    }

	    public static void mouseHover(By locatorname, String stepname){
	        try{WebElement electronics=driver.findElement(locatorname);
	        	action=new Actions(driver);
	        	action.moveToElement(electronics).perform(); // this step is for mouse hovering
	        	Reporter.log(stepname);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void get_text(By locatorname, String stepname){
	       try { String text=driver.findElement(locatorname).getText();
	       		print(text,"some stepname here");
	       		Reporter.log(stepname);
	       }catch(Exception e) {
	    	   System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void refreshWebPage(String stepname) throws AWTException {
	        // refresh web page
	       try { Robot r=new Robot();
	       		r.keyPress(KeyEvent.VK_CONTROL);
	       		r.keyPress(KeyEvent.VK_R);
	       		r.keyRelease(KeyEvent.VK_CONTROL);
	       		r.keyRelease(KeyEvent.VK_R);
	       		Reporter.log(stepname);
	       }catch(Exception e) {
	    	   System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void navigate_back(String stepname){
	        try{
	        	driver.navigate().back(); // clicking on back button
	        	Reporter.log(stepname);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void navigate_forward(String stepname){
	        try{
	        	driver.navigate().forward();
	        	Reporter.log(stepname);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void navigate_refresh(String stepname){
	        try{
	        	driver.navigate().refresh(); // Refresh 1st method/way
	        	Reporter.log(stepname);
	        }catch(Exception e) {
	        	System.out.println(e.fillInStackTrace());
	        }
	    }

	    public static void refresh_webPage_2(String stepname) throws InterruptedException {
	        try {
				String curl = driver.getCurrentUrl();
				waitTime(1200);
				driver.get(curl); // Refresh 2nd method/way
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void refresh_webPage_3(String stepname) throws InterruptedException {
	        try {
				String curl = driver.getCurrentUrl();
				waitTime(1200);
				driver.navigate().to(curl); // Refresh 3rd method/way
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void refresh_webPage_4(By locatorname, String stepname){
	        try {
				driver.findElement(locatorname).sendKeys(Keys.F5); // Refresh 4th method/way
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	  /*  public static void sikuliUpload(String cancelBtnScrnShtPath) throws FindFailed {
	        Screen sc=new Screen();
	        Pattern cancel=new Pattern(cancelBtnScrnShtPath);
	        sc.click(cancel);
	    }*/

	    public static void isLogoDisplayed(By locatorname, String stepname){
	        try {
				boolean  status=driver.findElement(locatorname).isDisplayed();
				if(status==true){
				    print("Logo present","some stepname here");
				}
				else{
				    print("Logo not present","some stepname here");
				}
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void isSearchboxEnabled(By locatorname, String stepname){
	        try {
				boolean searchboxEnabled=driver.findElement(locatorname).isEnabled();
				if(searchboxEnabled==true){
				    print("The Search-box is enabled","some stepname here");
				    send_keys(By.id("sb_form_q"),"best wishes to grandma","typing in searchbox");
				}
				else{
				    print("The Search-box is disabled","some stepname here");
				}
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void isRadiobuttonSelected(By locatorname,String stepname){
	        try {
				boolean radioButton1=driver.findElement(locatorname).isSelected();
				if(radioButton1==true){
				    print("The radio-button is selected","some stepname here");
				}
				else{
				    click(By.id("adlt_set_strict"),"setting the radion button ON");
				    print("I just set 1st radio-button ON","some stepname here");
				}
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    static void dragDropXYcoordinates(By locatorname, String stepname){
	        try {
				WebElement draggable=driver.findElement(locatorname); // webElement("draggable", By.id("draggable"));  //
				action=new Actions(driver);
				action.dragAndDropBy(draggable,400, 13).perform();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    protected static void dragDropToElement(By locatorname1, By locatorname2, String stepname){
	        try {
				WebElement droppable1=driver.findElement(locatorname1); //By.id("draggable")
				WebElement droppable2=driver.findElement(locatorname2); //By.id("droppable")
				action=new Actions(driver);
				action.dragAndDrop(droppable1,droppable2).perform();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void resizeObject(By locatorname, String stepname){
	        try {
				WebElement resizible=driver.findElement(locatorname); //By.xpath("//*[@id='resizable']/div[3]")
				action=new Actions(driver);
				action.dragAndDropBy(resizible,400,13).perform();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void selectObjectOnUI(By locatorname1, By locatorname2, String stepname){
	        try {
				WebElement selectible1=driver.findElement(locatorname1); //By.xpath("//*[@id='selectable']/li[1]")
				action=new Actions(driver);
				action.clickAndHold(selectible1).perform();
				WebElement selectible2=driver.findElement(locatorname2); //By.xpath("//*[@id='selectable']/li[3]")
				action.clickAndHold(selectible2).perform();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void sortableObjects(By locatorname, String stepname){
	        try {
				WebElement sortable=driver.findElement(locatorname); //By.xpath("//*[@id='sortable']/li[1]")
				action=new Actions(driver);
				action.dragAndDropBy(sortable,9,92).perform();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void switchToFrame(int frameIndex, String stepname){
	        try {
				driver.switchTo().frame(frameIndex); // connecting to objects inside a frame on the screen
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void switchToActiveElement(String stepname){
	        try {
				driver.switchTo().activeElement();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void switchBackFromFrame(String stepname){
	        try {
				driver.switchTo().defaultContent();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void print(String text, String stepname){
	        try {
				System.out.println(text);
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }

	    public static void closeApp(String stepname){
	        try {
				driver.close();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }
	    
	    public static void quitApp(String stepname){
	        try {
				driver.quit();
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }
	    
	    public static void javascriptExecutor(By locatorname,  String arg0_action, String stepname){
	        try {
				WebElement el=driver.findElement(locatorname);
				js= (JavascriptExecutor) driver;
				js.executeScript(arg0_action,el);
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }
	    
	    public static void readDirectoryFolderPath(String stepname) {
	    	try {
				System.out.println(System.getProperty("user.dir"));
				Reporter.log(stepname);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.fillInStackTrace());
			}
	    }
	    
	    public static void dropdown_selection(By locatorname,String text) {
	    	try {
	    		Select objname=new Select(driver.findElement(locatorname));
	    		objname.selectByVisibleText(text);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    @Parameters({"browser","appurl"})
		@BeforeTest(groups= {"regression","sanity","smoke","adhoc"})
		public void launchApp(String browsername, String applicationURL) {
	    	launchBrowser(browsername);
	    	openURL(applicationURL);
	    	
		/*	try {
				
		//	Property prop;
		//	prop=new Property("/Users/sirazhutdinmingazhev/eclipse-workspace/MortgageCalculator/configuration.properties");
		//	launchBrowser(prop.getProperty("browsername"));
			launchBrowser("chrome");
			openURL("https://candidate.psiexams.com/");
			}catch(Exception e) {
				e.printStackTrace();
			}*/
		}
		
		@AfterTest(groups= {"regression","sanity","smoke","adhoc"})
		public void quitapp() {
			try {
			quitApp("closing app/browser");
			}catch(Exception e) {
				e.printStackTrace();
		}

	}
}
