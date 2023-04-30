package day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {

        //1- create a test class and enter the required (4) settings

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://automationexercise.com/ sayfasina gidin

        driver.get("https://automationexercise.com/");

        //3- find out that there are 147 links on the main page there

        List<WebElement> linkList = driver.findElements(By.tagName("a"));

        if (linkList.size() == 147){
            System.out.println("Link listesi testi PASSED");
        }else {
            System.out.println("Sayfada " + linkList.size() + " adet link var, test FAILED");
        }

        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText(" Products")).click();

        // 5- Products'a tiklayinca Special Offer yazisinin gorundugunu test edin.
        WebElement specialOfferElement = driver.findElement(By.id("sale_image"));
        if (specialOfferElement.isDisplayed()) {
            System.out.println("Special Offer Testi PASSED");
        }else {
            System.out.println("FAILED");
        }

        //6- close the webpage.

        Thread.sleep(3000);
        driver.close();

    }
}
