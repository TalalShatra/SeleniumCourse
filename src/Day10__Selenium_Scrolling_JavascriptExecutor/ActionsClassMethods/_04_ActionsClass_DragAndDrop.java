package Day10__Selenium_Scrolling_JavascriptExecutor.ActionsClassMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _04_ActionsClass_DragAndDrop {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        WebElement fiveThousandButton = driver.findElement(By.xpath("(//li[@id='fourth'])[2]"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(fiveThousandButton, debitAmount).perform();

    }
}
