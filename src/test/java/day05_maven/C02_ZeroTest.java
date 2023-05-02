package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

//        2. Signin buttonuna tiklayin
        driver.findElement(By.className("icon-signin")).click();

//        3. Login alanina “username” yazdirin
        WebElement loginName = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginName.sendKeys("username");

    // OR
    // driver.findElement(By.id("user_login")).sendKeys("username");

//        4. Password alanina “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

    //OR
    //  driver.findElement(By.id("user_password")).sendKeys("password");

//        5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

//        6. Navigate back yapin, Online Banking altinda Pay Bills sayfasina gidin
        driver.navigate().back(); // navigate yaptik cunku sayfa hata veriyor, geri gidince duzeliyor.
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

//        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("100");

//        8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

//        9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

//        10. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement appearingText = driver.findElement(By.id("alert_content"));

        if (appearingText.isDisplayed()) {
            System.out.println("Test has PASSED");
        }else {
            System.out.println("Test has FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
