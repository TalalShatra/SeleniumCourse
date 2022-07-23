package Day7.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        WebElement messageInput = driver.findElement(By.cssSelector("input[placeholder='Full Name']"));
        String value = "Automation";
        messageInput.sendKeys(value);

        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        emailInput.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Testing Current Address");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Testing Permanent Address");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement name = driver.findElement(By.id("name"));
        String fullName = name.getText();
        System.out.println(fullName);

        WebElement email = driver.findElement(By.id("email"));
        String text = email.getText();
        System.out.println(text);

        WebElement Address1 = driver.findElement(By.cssSelector(".border.col-md-12.col-sm-12>#currentAddress"));
        String currentAddress1= Address1.getText();
        System.out.println(currentAddress1);

        WebElement Address2 = driver.findElement(By.id(".border.col-md-12.col-sm-12>#permanentAddress"));
        String permanentAddress1= Address2.getText();
        System.out.println(permanentAddress1);

        driver.quit();





    }
}
