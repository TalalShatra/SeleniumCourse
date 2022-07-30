package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _03_Task {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame("frame2");

        WebElement animals = driver.findElement(By.id("animals"));

        Select select = new Select(animals);

        select.selectByVisibleText("Avatar");

    }
}
