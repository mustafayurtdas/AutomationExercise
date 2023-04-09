package utilities;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class TestBase {
    protected static WebDriver driver;
    public static Actions action;

    @BeforeClass
    public static void beforeClass() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}
