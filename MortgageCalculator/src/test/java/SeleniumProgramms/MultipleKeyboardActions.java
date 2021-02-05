package SeleniumProgramms;

import java.awt.AWTException;

public class MultipleKeyboardActions extends ReusableSeleniumScript {
    public static void main(String[] args) throws InterruptedException, AWTException, AWTException {
       launchBrowser("chrome");
        openURL("https://www.flipkart.com/");
        refreshWebPage(); // Robot class practice
    }
}
