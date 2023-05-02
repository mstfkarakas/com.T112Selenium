package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//                          Class Work: Relative Locators
//
//    1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
//        adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

//    2 ) Berlin’i 3 farkli relative locator ile locate edin

//    2A) Sailor'in ustundeki diyelim. Tarif etmeye calistigimiz Berlin'in bir ozelligini kullanmak zorundayiz. Mesala tagName:img
        WebElement sailorElement = driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElement));
//    2B) Boston'in sagindaki diyelim. Tarif etmeye calistigimiz Berlin'in bir ozelligini kullanmak zorundayiz. Mesala tagName:img
        WebElement bostonElement = driver.findElement(By.xpath("//p[text()='Boston']"));
        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElement));

//    2C) NYC'nin altindaki diyelim. Tarif etmeye calistigimiz Berlin'in bir ozelligini kullanmak zorundayiz. Mesala tagName:img
        WebElement NYCElement = driver.findElement(By.xpath("//p[text()='NYC']"));
        WebElement berlin3 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(NYCElement));


//    2D) Birden baska tarifi ayni satirda yazabiliriz;
        WebElement berlin4 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(NYCElement).toRightOf(bostonElement).above(sailorElement));

//    3 ) Relative locator’larin dogru calistigini test edin.
        // id'si: pid7_thumb
        // Bu id'nin actual olup olmadigini test edecegiz;

        String expectedID = "pid7_thumb";
        String actualID = berlin4.getAttribute("id");  //berlin2 yapip 2B)'yi, berlin3 yapip 2C'yi, berlin4 yapip 2D'yi test edebiliriz.

        if (expectedID.equals(actualID)) {
            System.out.println("Relative Locator test is PASSED");
        }else {
            System.out.println("Relative Locator test is FAILED");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
