package Day9;
// https://github.com/mozilla/geckodriver/releases
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _03_firefoxTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Talal\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");
    }
}
