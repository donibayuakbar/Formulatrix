import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PesanContact {

    private final static String xpathEmail = "//input[@id='recipient-email']";
    private final static String xpathName = "//input[@id='recipient-name']";
    private final static String xpathMessage = "//textarea[@id='message-text']";

    WebDriver driver;

    @BeforeTest
    public void setBrowser (){
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void KirimPesan () throws InterruptedException {
        driver.get("https://demoblaze.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
        Thread.sleep(3000);
        this.inputKirimPesan(driver, "donibayuakbar94@gmail.com", "Doni Bayu Akbar", "Testing Automation");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Send message')]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }

    private void inputKirimPesan (WebDriver driver, String ContEmail, String ContName, String Message){
        driver.findElement(By.xpath(xpathEmail)).sendKeys(ContEmail);
        driver.findElement(By.xpath(xpathName)).sendKeys(ContName);
        driver.findElement(By.xpath(xpathMessage)).sendKeys(Message);
    }
}
