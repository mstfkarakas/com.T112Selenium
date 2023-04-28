package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        String expectedTitle = "amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
        }
        System.out.println("actualURL = " + actualTitle); // actualURL = Amazon.com. Spend less. Smile more.

        // TEST #2.  See if the website url is https://www.amazon.com/"

        String expectedURL = "https://www.amazon.com/";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(expectedURL)) {
            System.out.println("URL test PASSED");
        }else {
            System.out.println("URL test FAILED");
        }
        System.out.println("CurrentUrl() = " + driver.getCurrentUrl());  // CurrentUrl() = https://www.amazon.com/

        Thread.sleep(5000);
        driver.close();


    }
}
