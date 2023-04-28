package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //15 saniye boyunca bekle sonra testini yap demek,
        // bilgisayar veya internet yavas calisirsa, bu sekilde yanlis ere hata vermeyi engelliyoruz.






        Thread.sleep(2000);
        driver.close();

    }



}
