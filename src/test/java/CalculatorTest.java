import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        //driver.get("http://192.168.138.114:8080/calculator");
        driver.get("http://192.168.138.114:8081/webapp-0.2/");
    }

    @Test
    public void testAddition() {
        WebElement num1 = driver.findElement(By.name("num1"));
        num1.sendKeys("5");

        WebElement num2 = driver.findElement(By.name("num2"));
        num2.sendKeys("3");

        WebElement operator = driver.findElement(By.name("operator"));
        operator.sendKeys("+");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();

        WebElement result = driver.findElement(By.xpath("//h3[contains(text(), '8')]"));
        assertTrue(result.isDisplayed());
    }

    // More test cases for subtraction, multiplication, and division

    @After
    public void tearDown() {
        driver.quit();
    }
}
