import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.table.TableCellRenderer;

public class KategoriLaptops {

    WebDriver driver;

    @BeforeTest
    public void setBrowser () {
        System.setProperty("webdriver.chrome.driver", "D:\\Software\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void piihKategori () throws InterruptedException {
        driver.get("https://www.demoblaze.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
        Thread.sleep(4000);
    }

    @AfterTest
    public void close () {
        driver.close();
    }
}
