package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("Maximize screen size: " + driver.manage().window().getSize());
        System.out.println("Maximize window position: " + driver.manage().window().getPosition());


        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        System.out.println("Fullscreen screen size: " + driver.manage().window().getSize());
        System.out.println("Fullscreen window position: " + driver.manage().window().getPosition());

    //  browser'i istedigimiz boyuta ve konuma getirelim:

        driver.manage().window().setPosition(new Point(300,300));
        driver.manage().window().setSize(new Dimension(400,400));


        Thread.sleep(3000);
        driver.close();
    }
}
