package Project3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
SCENARIO 4:
-Navigate to "https://shopdemo.e-junkie.com/" website
-Click on 'Add to Cart' for 'Demo eBook'
-Click on 'Pay using Debit Card'
-Fill the Billing Details Form (use fake data)
-Enter Card number as "1111 1111 1111 1111"
-Validate "Invalid Card Number" message is displayed!
 */
    public class Scenario4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shopdemo.e-junkie.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> addToCarButtonList = driver.findElements(By.cssSelector("button[class='view_product']"));
        addToCarButtonList.get(1).click();

        WebElement iframe1 = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);

        WebElement payDebit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        payDebit.click();

        WebElement eMailInput = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        eMailInput.sendKeys("cooljack@gmail.com");

        WebElement confirmEmailInput = driver.findElement(By.cssSelector("input[placeholder='Confirm Email']"));
        confirmEmailInput.sendKeys("cooljack@gmail.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        nameOnCard.sendKeys("Jack Lenon");

        WebElement phoneNumber = driver.findElement(By.cssSelector("input[placeholder='Optional']"));
        phoneNumber.sendKeys("8623458989");

        WebElement companyName = driver.findElement(By.cssSelector("p[class='Billing-Company']>input"));
        companyName.sendKeys("Cool");

        WebElement iframe2 = driver.findElement(By.xpath("//div[@class='__PrivateStripeElement']//iframe"));
        driver.switchTo().frame(iframe2);

        WebElement cardNumber = driver.findElement(By.cssSelector("input[name='cardnumber']"));
        cardNumber.sendKeys("1111 1111 1111 1111");

        driver.switchTo().parentFrame();

        WebElement errorMsg = driver.findElement(By.cssSelector("div[id='SnackBar']>span"));
        String invalidMsg = errorMsg.getText();

        if (invalidMsg.equals("Your card number is invalid.")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();
    }
}
