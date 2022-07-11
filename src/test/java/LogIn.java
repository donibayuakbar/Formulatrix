import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogIn {

    private final static String xpathUsername = "//input[@id='loginusername']";
    private final static String xpathPassword = "//input[@id='loginpassword']";

    WebDriver driver;

    @BeforeTest
    public void setBrowser () {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void LogIn () throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@id='login2']")).click();
        Thread.sleep(3000);
        this.inputLogin(driver, "Hermawan", "12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }

    private void inputLogin (WebDriver driver, String Username, String Password){
        driver.findElement(By.xpath(xpathUsername)).sendKeys(Username);
        driver.findElement(By.xpath(xpathPassword)).sendKeys(Password);
    }
}
