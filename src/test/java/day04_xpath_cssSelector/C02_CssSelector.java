package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//      1- bir class olusturun
//      2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/ ");

//      3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

//      4- Sayfayi “refresh” yapin
            WebElement homePageButton = driver.findElement(By.cssSelector("#nav-logo-sprites"));
            homePageButton.click();
        // Second and much easier way is:
        driver.navigate().refresh();

//      5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedText = "Spend Less";
        String actualTitle = driver.getTitle();

        if (actualTitle.toLowerCase().contains(expectedText.toLowerCase())) {
            System.out.println("Title test PASSED");
        }else System.out.println("Title test FAILED");

//      6- Gift Cards sekmesine basin
        driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")).click();
        // Second way using linkText();
        Thread.sleep(1000);  // let's wait 1 second not to miss the click
        driver.findElement(By.linkText("Gift Cards")).click();

//      7- Gift Cards'ta iken Birthday butonuna basin
        driver.findElement(By.cssSelector("a[aria-label='Birthday']")).click();

//      8- Best Seller bolumunden ilk urunu tiklayin (Ilk urun dediginde CLASS'dan xpath secmek mantiklidir)
        driver.findElement(By.xpath("(//li[@class='a-carousel-card acswidget-carousel__card'])[1]")).click();

//      9- Gift card details’den $25’i secin
        driver.findElement(By.xpath("//li[@class='a-spacing-mini gc-indexed gc-requires-js-inline-block gc-mini-amount gc-mini-amount1 gc-mini-amount-button']")).click();

//      10-Urun ucretinin 25$ oldugunu test edin
        WebElement priceFirstItem = driver.findElement(By.xpath("//span[text()='$25.00']"));
        System.out.println(priceFirstItem.getText()); // We can see if the price is really $25. Not necessary.

        String expectedPriceFirstItem = "$25.00";
        String actualPriceFirstItem = priceFirstItem.getText();

        if (expectedPriceFirstItem.equals(actualPriceFirstItem)) {
            System.out.println("First Item's Test PASSED!");
        }else {
            System.out.println("First Item's Test FAILED!!!");
        }

//      11-Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
