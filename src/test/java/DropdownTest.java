import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 1");
        select.selectByVisibleText("Option 2");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 2");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
// Взять все элементы дроп-дауна и проверить их наличие.
// Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран