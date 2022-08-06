package Project3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
    /*
    SCENARIO 2:
    -Navigate to "https://shopdemo.e-junkie.com/" website
    -Click on 'Add to Cart' for 'Demo eBook'
    -Click on 'Add Promo Code' button and enter "123456789"
    -Click on 'Apply'
    -Validate "Invalid promo code" message is displayed!
     */
    public class Scenario2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        List<WebElement> addToCarButtonList = driver.findElements(By.cssSelector("button[class='view_product']"));
        addToCarButtonList.get(1).click();

        Thread.sleep(2000);

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);

        WebElement addPromoCodeButton = driver.findElement(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']"));
        addPromoCodeButton.click();
        Thread.sleep(2000);

        WebElement promoCodeButton = driver.findElement(By.cssSelector("input[class='Promo-Code-Value']"));
        promoCodeButton.sendKeys("123456789");

        WebElement applyPromoButton = driver.findElement(By.cssSelector("button[class='Promo-Apply']"));
        applyPromoButton.click();
        Thread.sleep(2000);

        WebElement invalidPromo = driver.findElement(By.cssSelector("div[id='SnackBar']>span"));

        Thread.sleep(2000);

        String invalidPromoText = invalidPromo.getText();
        Thread.sleep(2000);

        if (invalidPromoText.equals("Invalid promo code")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();
    }
}
