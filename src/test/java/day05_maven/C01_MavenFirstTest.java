package day05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenFirstTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//                      Class Work Amazon Search Test
//
//        1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

//        2- arama kutusunu locate edelim
        WebElement searcBox = driver.findElement(By.id("twotabsearchtextbox"));

//        3- “Samsung headphones” ile arama yapalim
        searcBox.sendKeys("Samsung headphones" + Keys.ENTER);

//        4- Bulunan sonuc sayisini yazdiralim
        WebElement resultCount = driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        System.out.println(resultCount.getText()); // 1-16 of 222 results for "Samsung headphones"

//        5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();


//        6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back(); // soldaki menu basliklarini gormek icin geri gidiyoruz

        List<WebElement> leftMenuTitles = driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));

        for (WebElement each : leftMenuTitles) {
            System.out.println(each.getText());
        }


        driver.close();
    }
}
