package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_SwitchingToIFrame {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame("frame1");
        // The <iframe> HTML element represents a nested browsing context, embedding another HTML page into the current one.


        WebElement topicField = driver.findElement(By.tagName("input"));
        topicField.sendKeys("Project");


    }
}
