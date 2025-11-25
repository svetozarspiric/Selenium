import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {


        //Zadatak 5
        // Na linku https://practicetestautomation.com/ otici do login stranice,
        // uradite log in i dodajte asertacije

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        Thread.sleep(2000);
        WebElement praticeButton = driver.findElement(By.id("menu-item-20"));
        praticeButton.click();
        Thread.sleep(2000);
        WebElement testLoginPageButton = driver.findElement(By.cssSelector("a[href='https://practicetestautomation.com/practice-test-login/']"));
        testLoginPageButton.click();
        Thread.sleep(2000);
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(2000);






    }
}
