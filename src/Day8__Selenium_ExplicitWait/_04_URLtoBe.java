package Day8__Selenium_ExplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_URLtoBe {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.seleniumeasy.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement testNGTutorials = driver.findElement(By.cssSelector("a[href='/testng-tutorials']"));
        testNGTutorials.click();

        wait.until(ExpectedConditions.urlToBe("https://www.seleniumeasy.com/testng-tutorials"));
    }
}
