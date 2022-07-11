import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TambahPonsel {

    WebDriver driver;

    @BeforeTest
    public void setBrowser () {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void tambahPonsel () throws InterruptedException {
        driver.get("https://www.demoblaze.com");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='prod.html?idp_=3']//img[@class='card-img-top img-fluid']")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg']")));
        el.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }
}
