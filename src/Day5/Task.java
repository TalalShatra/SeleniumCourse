package Day5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task {
    public static void main(String[] args) throws RuntimeException, InterruptedException {

        // Test data : 2 Strings
        String num1 = "25";
        String num2 = "12";
        // find the sum
        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
        String expectedResult = Integer.toString(sum);

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        Thread.sleep(3000);

        WebElement closePopUpButton = driver.findElement(By.id("at-cv-lightbox-close"));
        closePopUpButton.click();

        Thread.sleep(3000);

        // locate 2 button
        WebElement numberInput1 = driver.findElement(By.id("sum1"));
        WebElement numberInput2 = driver.findElement(By.id("sum2"));

        // input values
        numberInput1.sendKeys(num1);
        numberInput2.sendKeys(num2);

        // locate total button
        WebElement getTotalButton = driver.findElement(By.cssSelector("button[onclick='return total()']"));

        // click
        getTotalButton.click();

        // locate result message
        WebElement resultMessage = driver.findElement(By.id("displayvalue"));

        // get the result message and store it as actual result
        String actualResult = resultMessage.getText();

        // validation
        if ( actualResult.equals(expectedResult)) {
            System.out.println("Success");
        } else {
            throw new RuntimeException();
        }

        driver.quit();

    }

}
