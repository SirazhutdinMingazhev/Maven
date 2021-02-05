package SeleniumProgramms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//import com.sun.jna.platform.unix.X11.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableSeleniumScript {


    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions action;

    public static void launchBrowser(String browsername){
        if(browsername.equalsIgnoreCase("chrome")){
        	WebDriverManager.chromedriver().setup();
           // System.setProperty("webdriver.chrome.driver","/Users/sirazhutdinmingazhev/Desktop/chromedriverFile/chromedriver");
            driver=new ChromeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox")){
        	WebDriverManager.firefoxdriver().setup();
       	// System.setProperty("webdriver.gecko.driver","/Users/sirazhutdinmingazhev/Desktop/FireFoxDriverFile/geckodriver"); // change path
            driver= new FirefoxDriver();
        }

        driver.manage().window().maximize(); // maximizing the browser/window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait (wait until object loaded)
    }

    public static void waitTime(int mlsnds) throws InterruptedException {
        Thread.sleep(mlsnds);
    }

    public static void openURL(String url){
        driver.get(url);
    }

    public static void click(By locatorname){
        driver.findElement(locatorname).click();
    }

    public static void find_element(By locatorname){
        driver.findElement(locatorname);
    }

    public static void send_keys(By locatorname, String text){
        driver.findElement(locatorname).sendKeys(text);
    }

    public static void selectSponsorName(By locatorname){
        Select sponsorname=new Select(driver.findElement(locatorname));
        sponsorname.selectByIndex(4); // option 1
        //sponsorname.selectByValue("736^-99"); // option 2
        //sponsorname.selectByVisibleText("ATI TEAS"); // option 3
    }

    public static void mouseHover(By locatorname){
        WebElement electronics=driver.findElement(locatorname);
        action=new Actions(driver);
        action.moveToElement(electronics).perform(); // this step is for mouse hovering
    }

    public static void get_text(By locatorname){
        String text=driver.findElement(locatorname).getText();
        print(text);
    }

    public static void refreshWebPage() throws AWTException {
        // refresh web page
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_R);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_R);
    }

    public static void navigate_back(){
        driver.navigate().back(); // clicking on back button
    }

    public static void navigate_forward(){
        driver.navigate().forward();
    }

    public static void navigate_refresh(){
        driver.navigate().refresh(); // Refresh 1st method/way
    }

    public static void refresh_webPage_2() throws InterruptedException {
        String curl = driver.getCurrentUrl();
        waitTime(1200);
        driver.get(curl); // Refresh 2nd method/way
    }

    public static void refresh_webPage_3() throws InterruptedException {
        String curl = driver.getCurrentUrl();
        waitTime(1200);
        driver.navigate().to(curl); // Refresh 3rd method/way
    }

    public static void refresh_webPage_4(By locatorname){
        driver.findElement(locatorname).sendKeys(Keys.F5); // Refresh 4th method/way
    }

  /*  public static void sikuliUpload(String cancelBtnScrnShtPath) throws FindFailed {
        Screen sc=new Screen();
        Pattern cancel=new Pattern(cancelBtnScrnShtPath);
        sc.click(cancel);
    }*/

    public static void isLogoDisplayed(By locatorname){
        boolean  status=driver.findElement(locatorname).isDisplayed();
        if(status==true){
            print("Logo present");
        }
        else{
            print("Logo not present");
        }
    }

    public static void isSearchboxEnabled(By locatorname){
        boolean searchboxEnabled=driver.findElement(locatorname).isEnabled();
        if(searchboxEnabled==true){
            print("The Search-box is enabled");
            send_keys(By.id("sb_form_q"),"best wishes to grandma");
        }
        else{
            print("The Search-box is disabled");
        }
    }

    public static void isRadiobuttonSelected(By locatorname){
        boolean radioButton1=driver.findElement(locatorname).isSelected();
        if(radioButton1==true){
            print("The radio-button is selected");
        }
        else{
            click(By.id("adlt_set_strict"));
            print("I just set 1st radio-button ON");
        }
    }

    static void dragDropXYcoordinates(By locatorname){
        WebElement draggable=driver.findElement(locatorname); // webElement("draggable", By.id("draggable"));  //
        action=new Actions(driver);
        action.dragAndDropBy(draggable,400, 13).perform();
    }

    protected static void dragDropToElement(By locatorname1, By locatorname2){
        WebElement droppable1=driver.findElement(locatorname1); //By.id("draggable")
        WebElement droppable2=driver.findElement(locatorname2); //By.id("droppable")
        action=new Actions(driver);
        action.dragAndDrop(droppable1,droppable2).perform();
    }

    public static void resizeObject(By locatorname){
        WebElement resizible=driver.findElement(locatorname); //By.xpath("//*[@id='resizable']/div[3]")
        action=new Actions(driver);
        action.dragAndDropBy(resizible,400,13).perform();
    }

    public static void selectObjectOnUI(By locatorname1, By locatorname2){
        WebElement selectible1=driver.findElement(locatorname1); //By.xpath("//*[@id='selectable']/li[1]")
        action=new Actions(driver);
        action.clickAndHold(selectible1).perform();
        WebElement selectible2=driver.findElement(locatorname2); //By.xpath("//*[@id='selectable']/li[3]")
        action.clickAndHold(selectible2).perform();
    }

    public static void sortableObjects(By locatorname){
        WebElement sortable=driver.findElement(locatorname); //By.xpath("//*[@id='sortable']/li[1]")
        action=new Actions(driver);
        action.dragAndDropBy(sortable,9,92).perform();
    }

    public static void switchToFrame(int frameIndex){
        driver.switchTo().frame(frameIndex); // connecting to objects inside a frame on the screen
    }

    public static void switchToActiveElement(){
        driver.switchTo().activeElement();
    }

    public static void switchBackFromFrame(){
        driver.switchTo().defaultContent();
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static void closeApp(){
        driver.close();
    }
    public static void javascriptExecutor(By locatorname,  String arg0_action){
        WebElement el=driver.findElement(locatorname);
        js= (JavascriptExecutor) driver;
        js.executeScript(arg0_action,el);
    }

}
