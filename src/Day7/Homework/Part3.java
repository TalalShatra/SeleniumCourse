package Day7.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Talal\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.snapdeal.com/");

        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search products & brands']"));
        searchBox.sendKeys("teddy bear");

        WebElement searchButton = driver.findElement(By.className("searchTextSpan"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement results = driver.findElement(By.className("nnn"));
        String resultsNumber = results.getText();
        System.out.println(resultsNumber);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("First URL: " + currentUrl);

        Thread.sleep(1000);


        WebElement snapDealLogo = driver.findElement(By.cssSelector("[title^='Snapdeal']"));
        snapDealLogo.click();

        Thread.sleep(1000);

        String currentUrl2 = driver.getCurrentUrl();
        System.out.println("Second URL: " + currentUrl2);

        Thread.sleep(1000);

        driver.navigate().back();

        WebElement searchBoxSecond = driver.findElement(By.id("inputValEnter"));
        String actualResult = searchBoxSecond.getAttribute("value");

        System.out.println(actualResult);

        driver.quit();
    }
}
