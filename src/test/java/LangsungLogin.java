import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LangsungLogin {

    private final static String xpathUsername = "//input[@id='loginusername']";
    private final static String xpathPassword = "//input[@id='loginpassword']";
    private final static String xpathLogin = "//button[contains(text(),'Log in')]";

    WebDriver driver;

    @BeforeTest
    public void setBrowser () {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void LangsungLogin () throws InterruptedException {
        driver.get("https://demoblaze.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@id='login2']")).click();
        Thread.sleep(2000);
        this.inputLogin(driver, "Doni Bayu Akbar", "12345");
        Thread.sleep(5000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }

    private void inputLogin (WebDriver driver, String Username, String Password){
        driver.findElement(By.xpath(xpathUsername)).sendKeys(Username);
        driver.findElement(By.xpath(xpathPassword)).sendKeys(Password);
        driver.findElement(By.xpath(xpathLogin)).click();
    }
}
