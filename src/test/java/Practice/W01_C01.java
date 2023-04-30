package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class W01_C01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.marksandspencer.com/");
        WebElement kidsButton = driver.findElement(By.xpath("//a[text()='Kids']"));
 // OR  WebElement kidsButton = driver.findElement(By.linkText("Kids"));
        kidsButton.click();  // Kid menusunu tikladik.

 //     Sonra da Dress'e tiklayalim:

        WebElement dressMenu = driver.findElement(By.xpath("//h2[text()='Dresses']"));
        dressMenu.click();

        List<WebElement> priceListDresses = driver.findElements(By.xpath("//span[@class='css-v38gg3 et8tcrz0']"));

        String priceSTR;
        Integer priceINT;
        Integer maxPrice=0;

        for (int i = 0; i < priceListDresses.size(); i++) {
          priceSTR = priceListDresses.get(i).getText().substring(1,3);
          priceINT = Integer.parseInt(priceSTR);
      //  System.out.print(priceListDresses.get(i).getText() + " ");
          if (priceINT>maxPrice){
              maxPrice = priceINT;
          }
        }
        System.out.println("max Price = " + maxPrice);

        Thread.sleep(3000);
        driver.close();

            /*
    USER STORY : Filter page should be created regarding the acceptance criteria
    ( there should be 4 options, price, size, colour, brand )
    Test Cases :
    TC01 : Price option should work
    Test Steps
    1.step navigate url
    2.step main page should be visible
    3.step Click on the Filter page in button in the main page
    4.step Write price text box ......
    5.step Click on Filter button in the Filter page
    6.step The filtered price should be visible on the main page
    TC02 : Size option should work
    TC03 : colour option should work
    TC04 : brand option should work
    TC05 : The filter web elements should be functional
     */
    }
}
