package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com/");

        driver.manage().window().maximize();

        WebElement userInput = driver.findElement(By.id("username"));
        userInput.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("techno123.");

        WebElement submitButton = driver.findElement(By.id("log-in"));
        submitButton.click();

        WebElement header = driver.findElement(By.id("time"));
        String str = header.getText();
        System.out.println(str);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        driver.quit();
}}
