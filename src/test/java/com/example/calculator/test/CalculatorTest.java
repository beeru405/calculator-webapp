package com.example.calculator.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/calculator-webapp");
        
        WebElement num1Input = driver.findElement(By.name("num1"));
        num1Input.sendKeys("5");
        
        WebElement operationSelect = driver.findElement(By.name("operation"));
        operationSelect.sendKeys("add");
        
        WebElement num2Input = driver.findElement(By.name("num2"));
        num2Input.sendKeys("3");
        
        WebElement calculateButton = driver.findElement(By.cssSelector("input[type='submit']"));
        calculateButton.click();
        
        WebElement result = driver.findElement(By.tagName("h2"));
        assertEquals("8", result.getText());
        
        driver.quit();
    }
}
