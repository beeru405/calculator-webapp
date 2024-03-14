package mypackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CalculatorSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testCalculatorAddition() {
        // Navigate to the webpage
        driver.get("http://192.168.138.114:8081/webapp-0.2/");

        // Enter inputs and click on addition
        WebElement n1Field = driver.findElement(By.name("n1"));
        WebElement n2Field = driver.findElement(By.name("n2"));
        WebElement addButton = driver.findElement(By.name("r1"));

        n1Field.sendKeys("5");
        n2Field.sendKeys("3");
        addButton.click();

        // Get the result element and verify the result
        WebElement resultElement = driver.findElement(By.tagName("h1"));
        String resultText = resultElement.getText();

        assertEquals("Addition", resultText);
    }

    @After
    public void tearDown() {
        // Close the WebDriver
        driver.quit();
    }
}
