import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cart {

    private final static String xpathName = "//input[@id='name']";
    private final static String xpathCountry = "//input[@id='country']";
    private final static String xpathCity = "//input[@id='city']";
    private final static String xpathCredit = "//input[@id='card']";
    private final static String xpathMonth = "//input[@id='month']";
    private final static String xpathYear = "//input[@id='year']";

    WebDriver driver;

    @BeforeTest
    public void setBrowser () {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Cart () throws InterruptedException {
        driver.get("https://demoblaze.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
        Thread.sleep(3000);

        this.inputCart(driver,"Doni", "Indonesia", "Garut", "82847945794", "February", "2022");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }

    private void inputCart (WebDriver driver, String Name, String Country, String City, String Credit, String Month, String Year){
        driver.findElement(By.xpath(xpathName)).sendKeys(Name);
        driver.findElement(By.xpath(xpathCountry)).sendKeys(Country);
        driver.findElement(By.xpath(xpathCity)).sendKeys(City);
        driver.findElement(By.xpath(xpathCredit)).sendKeys(Credit);
        driver.findElement(By.xpath(xpathMonth)).sendKeys(Month);
        driver.findElement(By.xpath(xpathYear)).sendKeys(Year);
    }
}
