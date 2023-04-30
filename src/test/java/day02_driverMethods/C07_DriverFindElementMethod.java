package day02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_DriverFindElementMethod {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nutella");  // arama kutusuna text'i yazar
        searchBox.submit(); // arama kutusunda enter'a basar

        Thread.sleep(3000);
        driver.close();
    }
}
