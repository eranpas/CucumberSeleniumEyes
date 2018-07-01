/**
 * Created by eran on 27/06/2018.
 */

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSite {

    public static void main(String[] args) {

        // Open a Chrome browser.
        WebDriver driver = new ChromeDriver();

        // Initialize the eyes SDK and set your private API key.
        Eyes eyes = new Eyes();
        eyes.setApiKey("t98tbweCgqwaeeSKeJsf65jE085035RJwlVLBxDO5tzg110");

        String address = "http://testing-ground.scraping.pro/login";



        try{

            // Start the test and set the browser's viewport size to 800x600.
            eyes.open(driver, "TestLogin!", "Web Login",
                    new RectangleSize(1024, 768));

            driver.get(address);
            driver.findElement(By.id("usr")).click();
            driver.findElement(By.id("usr")).clear();
            driver.findElement(By.id("usr")).sendKeys("admin");
            driver.findElement(By.id("pwd")).click();
            driver.findElement(By.id("pwd")).clear();
            driver.findElement(By.id("pwd")).sendKeys("12345");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            driver.findElement(By.xpath("//body")).click();
            // Visual checkpoint #1.
            eyes.checkWindow("Welcome");


            driver.get(address);
            driver.findElement(By.id("usr")).click();
            driver.findElement(By.id("usr")).clear();
            driver.findElement(By.id("usr")).sendKeys("admin");
            driver.findElement(By.id("pwd")).click();
            driver.findElement(By.id("pwd")).clear();
            driver.findElement(By.id("pwd")).sendKeys("1234");
            driver.findElement(By.xpath("//input[@value='Login']")).click();
            driver.findElement(By.xpath("//body")).click();
            // Visual checkpoint #2.
            eyes.checkWindow("Denied");

            // End the test.
            //eyes.close();

            // Close Eyes
            Boolean throwtTestCompleteException = false;
            TestResults result = eyes.close(throwtTestCompleteException);
            String url = result.getUrl();
            if (result.isNew()) {
                System.out.println("New Baseline Created: URL=" + url);
            } else if (result.isPassed()) {
                System.out.println("All steps passed:     URL=" + url);
            } else {
                System.out.println("Test Failed:          URL=" + url);
            }

        } finally {

            // Close the browser.
            driver.quit();

                        // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();
        }

    }

}
