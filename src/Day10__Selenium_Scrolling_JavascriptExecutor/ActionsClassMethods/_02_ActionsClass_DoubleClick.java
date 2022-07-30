package Day10__Selenium_Scrolling_JavascriptExecutor.ActionsClassMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _02_ActionsClass_DoubleClick {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/buttons");

        WebElement clickMeButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(clickMeButton).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        System.out.println(doubleClickMessage.getText());

        driver.quit();
}}
