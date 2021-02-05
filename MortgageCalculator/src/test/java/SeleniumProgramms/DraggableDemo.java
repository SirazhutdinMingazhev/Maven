package SeleniumProgramms;

import org.openqa.selenium.By;

public class DraggableDemo extends ReusableSeleniumScript{


    public static void main(String[] args) throws InterruptedException {

        launchBrowser("chrome"); // Inheritance from ReusableSeleniumScript class (reusable method/function)
        openURL("https://jqueryui.com/"); // Inheritance from ReusableSeleniumScript class (reusable method/function)

        //driver.switchTo().frame(0); // connecting to objects inside a frame on the screen
        //driver.switchTo().frame("frame"); // when 'name="frame"' is available when inspecting so use name
        //driver.switchTo().frame("demo-frame");  //

        //Actions action=new Actions(driver);  // using 'Actions' to perform any action like drag and drop / resize etc...

        // Dragging and dropping object on UI
        click(By.linkText("Draggable")); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.findElement(By.linkText("Draggable")).click();
        switchToFrame(0); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.switchTo().frame(0); // connecting to objects inside a frame on the screen
        dragDropXYcoordinates(By.id("draggable")); //WebElement + drag and drop action
        print("Drag and drop action is performed."); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // System.out.println("Drag and drop action is performed.");
        switchBackFromFrame(); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // driver.switchTo().defaultContent();

        // Dragging and dropping object to specified location.
        click(By.linkText("Droppable")); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.findElement(By.linkText("Droppable")).click();
        switchToFrame(0); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.switchTo().frame(0); // connecting to objects inside a frame on the screen
        dragDropToElement(By.id("draggable"),By.id("droppable"));
        print("Action Drag and drop object to specified location is done"); // Inheritance from ReusableSeleniumScript class (reusable method/function) // System.out.println("Action Drag and drop object to specified location is done");
        switchBackFromFrame(); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // driver.switchTo().defaultContent();

        // Resizing object
        click(By.linkText("Resizable")); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // driver.findElement(By.linkText("Resizable")).click();
        switchToFrame(0); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.switchTo().frame(0);
        resizeObject(By.xpath("//*[@id='resizable']/div[3]"));
        print("Action resize object is done"); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // System.out.println("Action resize object is done");
        switchBackFromFrame(); // Inheritance from ReusableSeleniumScript class (reusable method/function) // driver.switchTo().defaultContent();

        // Selecting objects on UI
        click(By.linkText("Selectable")); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // driver.findElement(By.linkText("Selectable")).click();
        switchToFrame(0);// Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.switchTo().frame(0);
        selectObjectOnUI(By.xpath("//*[@id='selectable']/li[1]"), By.xpath("//*[@id='selectable']/li[3]"));
        print("Action Selectible is done"); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // System.out.println("Action Selectible is done");
        switchBackFromFrame();// Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.switchTo().defaultContent();

        // Sortable objects
        click(By.linkText("Sortable")); // Inheritance from ReusableSeleniumScript class (reusable method/function)  // driver.findElement(By.linkText("Sortable")).click();
        switchToFrame(0); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.switchTo().frame(0);
        sortableObjects(By.xpath("//*[@id='sortable']/li[1]"));
        print("Action sortable is done"); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //System.out.println("Action sortable is done");
        switchBackFromFrame(); // Inheritance from ReusableSeleniumScript class (reusable method/function)  //driver.switchTo().defaultContent();

        // closing application
        closeApp(); // Inheritance from ReusableSeleniumScript class (reusable method/function)

    }  // main

}
