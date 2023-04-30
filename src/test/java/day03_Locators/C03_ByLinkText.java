package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        WebElement giftCardLink = driver.findElement(By.linkText("Gift Cards"));
        giftCardLink.click(); // Gift Card'i tikladim. Sayfanin title'o Gift Card'i iceriyorsa diye test edebiliriz.

        String expectedWord = "Gift Card";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedWord)){
            System.out.println("Gift Card testi PASSED");
        }else {
            System.out.println("Gift Card testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
