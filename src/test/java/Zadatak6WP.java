import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6WP {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");

        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();

        String username = "svetozar.spiric@yahoo.com";
        String password = "PitajuMe";

        Thread.sleep(1000);
        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.sendKeys(username);
        Thread.sleep(1000);
        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();
        Thread.sleep(1000);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        Thread.sleep(1000);
        WebElement loginButtonTwo = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButtonTwo.click();







    }
}
