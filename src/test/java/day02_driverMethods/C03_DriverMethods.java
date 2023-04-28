package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.get("https://wwww.amazon.com");

    //  TEST if page source contains MEOW on amazon.com homepage.
        String pageSource = driver.getPageSource();
        String expectedWord = "MEOW";

        if (pageSource.contains(expectedWord)){
            System.out.println("Page source contains: " + expectedWord);
        }else {
            System.out.println("Page source DOES not contain: " + expectedWord);  // Page source DOES not contain: MEOW

        }



        Thread.sleep(3000);
        driver.close();

    }
}
