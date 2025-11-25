import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VezbaAnotacije {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void Object() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void homePage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        WebElement pratcticeButton = driver.findElement(By.id("menu-item-20"));
        pratcticeButton.click();

        WebElement testLoginPage = driver.findElement(By.cssSelector("a[href='https://practicetestautomation.com/practice-test-login/']"));
        testLoginPage.click();
    }

    @Test
    public void userLogInValidCredentials() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement loguoyButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(loguoyButton.isDisplayed());


    }

    @Test
    public void userLoginInvalidUsername() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();
        usernameField.sendKeys("etery");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        Thread.sleep(2000);
    }

    @Test
    public void userLoginUsernameFeildEmpty() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.clear();


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        Thread.sleep(2000);
    }

    @AfterClass
    public void shutDown() {
        driver.quit();
    }

}



