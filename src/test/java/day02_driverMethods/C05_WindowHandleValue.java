package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleValue {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle()); // driver.getWindowHandle() = 3D11714DF0254E0A1A96B9A3455B2363

        Thread.sleep(3000);
        driver.close();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle()); // driver.getWindowHandle() =


        Thread.sleep(3000);
        driver.close();


    }
}
