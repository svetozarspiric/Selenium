import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciCetvrtak2011 {
    public static void main(String[] args) {

        // Na sajtu https://www.saucedemo.com/ otvoriti login stranicu i izvrsiti logovanje koristeci:
        //1) validne kredencijale

        //- Koristiti asertacije (edited)

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String validUsername = "standard_user";
        String validPassword = "secret_sauce";

        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys(validUsername);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //posto ovaj pop-up window nakon logovanja ne moze da se inspektuje,
        // asertacije radim nakon rucnog klika na OK dugme.

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        WebElement productText = driver.findElement(By.className("product_sort_container"));
        Assert.assertTrue(productText.isDisplayed());





    }
}
