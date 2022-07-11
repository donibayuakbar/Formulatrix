import junit.framework.TestResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp {

    private final static String xpathUsername = "//input[@id='sign-username']";
    private final static String xpathPassword = "//input[@id='sign-password']";

    WebDriver driver;

    @BeforeTest
    public void setBrowser () {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void SignUp () throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@id='signin2']")).click();
        Thread.sleep(3000);
        this.inputSignup(driver, "Hermawan", "12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }

    private void inputSignup (WebDriver driver, String Username, String Password){
        driver.findElement(By.xpath(xpathUsername)).sendKeys(Username);
        driver.findElement(By.xpath(xpathPassword)).sendKeys(Password);
    }

}
