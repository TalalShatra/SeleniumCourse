package Day8__Selenium_ExplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Homework {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");

        driver.manage().window().maximize();

        WebElement firstNameInput = driver.findElement(By.cssSelector("input[data-bv-field='first_name']"));
        firstNameInput.sendKeys("talal");

        WebElement lastNameInput = driver.findElement(By.cssSelector("input[name='last_name']"));
        lastNameInput.sendKeys("shatra");

        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        emailInput.sendKeys("talalshatra@yahoo.com");


        WebElement phoneInput = driver.findElement(By.cssSelector("input[data-bv-field='phone']"));
        phoneInput.sendKeys("9731234567");

        WebElement adressInput = driver.findElement(By.cssSelector("input[name='address']"));
        adressInput.sendKeys("122 South Maple Avenue");

        WebElement cityInput = driver.findElement(By.cssSelector("input[name='city']"));
        cityInput.sendKeys("Ridgewood");

        WebElement stateInput = driver.findElement(By.cssSelector("select[name='state']"));
        Select selectcity = new Select(stateInput);
        selectcity.selectByVisibleText("New Jersey");

        WebElement zipCodeInput = driver.findElement(By.cssSelector("input[name='zip']"));
        zipCodeInput.sendKeys("07450");

        WebElement websiteInput = driver.findElement(By.cssSelector("input[name='website']"));
        websiteInput.sendKeys("https://github.com/TalalShatra");

        WebElement hostingCheckbox = driver.findElement(By.cssSelector("input[value='yes']"));
        hostingCheckbox.click();

        WebElement projectDescription = driver.findElement(By.cssSelector("textarea[name='comment']"));
        projectDescription.sendKeys("This is my Project");

        WebElement submitButton = driver.findElement(By.cssSelector("button[class='btn btn-default']"));
        hostingCheckbox.submit();

        driver.quit();












    }
}
