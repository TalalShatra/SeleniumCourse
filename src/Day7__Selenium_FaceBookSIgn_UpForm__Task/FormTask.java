package Day7__Selenium_FaceBookSIgn_UpForm__Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

// ---    TASK    ---
// Navigate https://www.facebook.com/
// Click on Create New Account button
// Fill the form
// Get text for Sign Up button
public class FormTask {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();

        WebElement locateCreateAccount = driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']"));

        locateCreateAccount.click();

        WebElement locateFirstName = driver.findElement(By.name("firstname"));

        locateFirstName.sendKeys("Steve");

        WebElement locateLastName = driver.findElement(By.name("lastname"));

        locateLastName.sendKeys("Russo");

        WebElement locateEMail = driver.findElement(By.name("reg_email__"));

        locateEMail.sendKeys("steverusso@yahoo.com");

        WebElement locateReenterEMail = driver.findElement(By.name("reg_email_confirmation__"));

        locateReenterEMail.sendKeys("steverusso@yahoo.com");

        WebElement locatePassword = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));

        locatePassword.sendKeys("123456");

        WebElement monthDropdown = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("May");

        WebElement dayDropdown = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByValue("3");

        WebElement yearDropdown = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("1980");

        WebElement maleOptionRadioButton = driver.findElement(By.cssSelector("input[value='2']"));
        maleOptionRadioButton.click();

        WebElement signUpButton = driver.findElement(By.cssSelector("button[name='websubmit']"));
        String signUpButtonText = signUpButton.getText();
        System.out.println(signUpButtonText);

        driver.quit();




    }}
