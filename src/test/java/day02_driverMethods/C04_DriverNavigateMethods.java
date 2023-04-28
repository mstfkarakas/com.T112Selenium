package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // once amazon'a gidelim
        driver.navigate().to("https://www.amazon.com"); // get() ile ayni isi yapar
        // sonra wisequarter'a gecelim
        driver.get("https://www.wisequarter.com");
        // tekrar amazon'a donelim
        driver.navigate().back();
        // tekrar wisequarter'a gidelim
        driver.navigate().forward();


        Thread.sleep(3000);
        driver.close();
    }
}
