package Day11__Selenium_close_vs_quit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class _04_SwitchToWindow {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://techno.study/");

        // Get the main window handle (parent window handle) so we can switch back easily!
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        WebElement getFreeConsultationButton = driver.findElement(By.xpath("//div[@class='t228__right_buttons_but']//a"));
        getFreeConsultationButton.click();

        // Get all window handles(id) and using for each loop switch to other window
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='Name']"));
        nameInput.sendKeys("Hello");

        // switch back to main window
        driver.switchTo().window(mainWindow);
    }
}
