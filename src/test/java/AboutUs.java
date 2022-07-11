import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AboutUs {

    WebDriver driver;

    @BeforeTest
    public void setBrowser () {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void AboutUs () throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'About us')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@class='vjs-poster']")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#videoModal > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)")).click();
        Thread.sleep(4000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }
}
