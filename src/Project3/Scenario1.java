package Project3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
    /*
    SCENARIO 1:
    -Navigate to "https://shopdemo.e-junkie.com/”
    -Click on 'Add to Cart' for 'Demo eBook'
    -Validate cart item no is '1'
    -Click on 'Remove' button to remove item from your cart
    -Click on 'Continue Shopping'
    -Validate cart item no is '0'
    */
    public class Scenario1 {
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
        Thread.sleep(2000);

        WebElement number1 = driver.findElement(By.xpath("//div[@class='Fixed-Actions Desktop-Only']//span"));
        String cartIsOne = number1.getText();
        Thread.sleep(2000);

        if (cartIsOne.equals("1")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        Thread.sleep(2000);

        WebElement removeButton = driver.findElement(By.cssSelector("button[class='Product-Remove']"));
        removeButton.click();
        Thread.sleep(2000);

        WebElement continueShopping = driver.findElement(By.cssSelector("button[class='Continue-Button Close-Cart']"));
        continueShopping.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        WebElement number0 = driver.findElement(By.xpath("(//span[@id='cart_item_nos'])[2]"));
        String cartIsZero = number0.getText();
        Thread.sleep(2000);

        if (cartIsZero.equals("0")){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        Thread.sleep(2000);

        driver.quit();
    }
}
