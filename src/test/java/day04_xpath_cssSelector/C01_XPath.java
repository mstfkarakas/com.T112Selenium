package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//                                  Relative Xpath Soru
//
//        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
//        3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButton.isDisplayed()) {
            System.out.println("Delete button is displayed! Test PASSED");
        }else {
            System.out.println("Delete button isn't displayed! Test FAILED");
        }

//        4- Delete tusuna basin
        deleteButton.click();

//        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveText = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (addRemoveText.isDisplayed()) {
            System.out.println("Add/Remove is displayed. Test PASSED");
        }else {
            System.out.println("Add/Remove isn't displayed. Test FAILED");

        }

        Thread.sleep(3000);
        driver.close();
    }
}
