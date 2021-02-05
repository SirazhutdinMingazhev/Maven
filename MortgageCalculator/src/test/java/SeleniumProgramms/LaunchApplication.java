package SeleniumProgramms;

import org.openqa.selenium.By;

public class LaunchApplication extends ReusableSeleniumScript {
    public static void main(String[] args) throws InterruptedException {

/*        LaunchChromeMethod();
        LaunchApp1("https://www.mortgagecalculator.org/");*/
        launchBrowser("chrome");
        openURL("https://www.mortgagecalculator.org/");

        print(driver.getTitle());
        send_keys(By.id("homeval"),"500000"); //driver.findElement(By.id("homeval")).sendKeys("500000");
        send_keys(By.id("downpayment"),"20000"); //driver.findElement(By.id("downpayment")).sendKeys("20000");
        send_keys(By.id("intrstsrate"),"3.1");
        send_keys(By.id("loanterm"),"39");
        send_keys(By.id("pptytax"),"5700");
        send_keys(By.id("pmi"),"0.2");
        send_keys(By.id("hoi"),"1999");
        send_keys(By.id("hoa"),"400");
        click(By.name("cal"));
        closeApp();
    }
}
