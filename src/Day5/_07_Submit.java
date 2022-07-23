package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _07_Submit {
    public static void main(String[] args) throws RuntimeException, InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        Thread.sleep(3000);

        WebElement closePopUpButton = driver.findElement(By.id("at-cv-lightbox-close"));
        closePopUpButton.click();

        Thread.sleep(3000);

        String value = "Hello World!";

        WebElement messageInput = driver.findElement(By.cssSelector("input[id='user-message']"));
        messageInput.sendKeys(value);

        Thread.sleep(3000);

        WebElement showMessageButton = driver.findElement(By.cssSelector("button[onclick='showInput();']"));


        // submit form and refresh the page
        showMessageButton.submit();


        Thread.sleep(3000);
        driver.quit();


    }}
