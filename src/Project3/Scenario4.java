package Project3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
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
        Thread.sleep(2000);


        List<WebElement> addToCarButtonList = driver.findElements(By.xpath("//button[@class='view_product']"));
        addToCarButtonList.get(1).click();

        Thread.sleep(2000);

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);
        Thread.sleep(2000);

        WebElement payDebit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        payDebit.click();

        WebElement eMailInput = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        eMailInput.sendKeys("qwerty@asdfgh.com");

        WebElement confirmEmailInput = driver.findElement(By.cssSelector("input[placeholder='Confirm Email']"));
        confirmEmailInput.sendKeys("qwerty@asdfgh.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        nameOnCard.sendKeys("Frank McPherson");

        WebElement phoneNumber = driver.findElement(By.cssSelector("input[placeholder='Optional']"));
        phoneNumber.sendKeys("5553334444");

        WebElement companyName = driver.findElement(By.cssSelector("p[class='Billing-Company']>input"));
        companyName.sendKeys("Techno Study");

        WebElement iframe2 = driver.findElement(By.xpath("//div[@class='__PrivateStripeElement']//iframe"));
        driver.switchTo().frame(iframe2);

        WebElement cardNumber = driver.findElement(By.cssSelector("input[name='cardnumber']"));
        cardNumber.sendKeys("1111 1111 1111 1111");

        driver.switchTo().parentFrame();

        WebElement errorMsg = driver.findElement(By.cssSelector("div[id='SnackBar']>span"));
        Thread.sleep(1500);
        String invalidMsg = errorMsg.getText();
        System.out.println(invalidMsg);
        Thread.sleep(1000);

        if (invalidMsg.equals("Your card number is invalid.")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();
    }
}
