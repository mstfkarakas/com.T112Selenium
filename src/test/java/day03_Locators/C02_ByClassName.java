package day03_Locators;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.time.Duration;
        import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        List<WebElement> priceList = driver.findElements(By.className("a-price-whole"));

        // System.out.println("priceList = " + priceList);

        for (WebElement each : priceList) {
            System.out.print(each.getText() + " "); // 34 13 25 42 11 12 25 12 72 8 18 12  Nutella etiketli urunlerin fiyatlarinin tamsayi kisimlari
        }

        // en yuksek fiyati bulabilmek icin java bilgisini kullanmaliyiz.
        // 1- WebElement'lerden getText() ile fiyati alip
        // 2- integer'a cevirin.
        // 3- En yuksek fiyati bulup yazdirin.

        String priceSTR;
        Integer priceINT;
        Integer maxPrice=0;

        for (WebElement each : priceList) {
            priceSTR = each.getText();
            priceINT = Integer.parseInt(priceSTR);

            if (priceINT>maxPrice){
                maxPrice = priceINT;
            }
        }
        System.out.println("");
        System.out.println("maxPrice = " + maxPrice);


        Thread.sleep(3000);
        driver.close();
    }
}