package Project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");

        driver.manage().window().maximize();

        Thread.sleep(5000);

        WebElement addToCartButton = driver.findElement(By.cssSelector("button[class='view_product']"));
        addToCartButton.click();

        Thread.sleep(5000);

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);

        WebElement number1 = driver.findElement(By.xpath("//div[@class='Fixed-Actions Desktop-Only']//span"));
        String validation1 = number1.getText();
        System.out.println(validation1);

        WebElement removeButton = driver.findElement(By.cssSelector("button[class='Product-Remove']"));
        removeButton.click();
        Thread.sleep(5000);

        WebElement continueShopping = driver.findElement(By.xpath("//button[@class='Continue-Button Close-Cart']"));
        continueShopping.click();
        Thread.sleep(5000);

        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        WebElement number0 = driver.findElement(By.xpath("(//span[@id='cart_item_nos'])[2]"));
        String cartIsZero = number0.getText();
        System.out.println(cartIsZero);




    }
}
