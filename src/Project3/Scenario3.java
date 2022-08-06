package Project3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
    /*
    SCENARIO 3:
    -Navigate to "https://shopdemo.e-junkie.com/" website
    -Click on 'Add to Cart' for 'Demo eBook'
    -Click on 'Pay using Debit Card'
    -Click on 'Pay' button without filling any information
    -Validate "Invalid Email - Invalid Email - Invalid Billing Name" message is displayed!
     */
    public class Scenario3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://shopdemo.e-junkie.com/");

        driver.manage().window().maximize();

        List<WebElement> addToCarButtonList = driver.findElements(By.cssSelector("button[class='view_product']"));
        addToCarButtonList.get(1).click();

        WebElement iframe1 = driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);

        WebElement payCreditButton = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        payCreditButton.click();

        WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        payButton.click();

        WebElement invalidTexts = driver.findElement(By.xpath("//div[@id='SnackBar']//span"));
        String texts = invalidTexts.getText();

        if (texts.equals("Invalid Email"+"\n"+"Invalid Email"+"\n"+"Invalid Billing Name")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();
    }
}
