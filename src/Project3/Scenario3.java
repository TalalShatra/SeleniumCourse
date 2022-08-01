package Project3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Scenario3 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://shopdemo.e-junkie.com/");

        driver.manage().window().maximize();

        WebElement addToCartButton = driver.findElement(By.cssSelector("button[class='view_product']"));
        addToCartButton.click();

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);

        WebElement creditPayingButton = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        creditPayingButton.click();

        WebElement countryDrapdown = driver.findElement(By.cssSelector("select[class='Shipping-Section-Country']"));
        Select selectCountry = new Select(countryDrapdown);
        selectCountry.selectByVisibleText("United States");

        WebElement postalCodeInput = driver.findElement(By.cssSelector("input[placeholder='ZIP/Postal Code']"));
        postalCodeInput.sendKeys("07506");

        WebElement calculateButton = driver.findElement(By.cssSelector("button[class='Calculate-Button']"));
        calculateButton.click();

        WebElement payCreditButton = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        payCreditButton.click();

        WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        payButton.click();

        WebElement invalidTexts = driver.findElement(By.xpath("//div[@id='SnackBar']//span"));
        String texts = invalidTexts.getText();
        System.out.println(texts);


    }
}
