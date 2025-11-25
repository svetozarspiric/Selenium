import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DomaciPonedeljak2411 {


    //Testirati prijavu na sajt https://demoqa.com/login pomocu kolacica
    //Test postavlja potrebne kolacice i otvara stranicu za prijavu kako bi simulirao ulogovanog korisnika, zatim brise kolacice i proverava da li je korisnik izlogovan
    //Koristiit anotacije


    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void Object() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeMethod
    public void logIn() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/login");

        WebElement userNameField = driver.findElement(By.id("userName"));
        userNameField.sendKeys("testUser");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password@123");

        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(3000);

        List<WebElement> listOfButtonsAfterLogedIn = driver.findElements(By.id("submit"));
        for (WebElement button : listOfButtonsAfterLogedIn) {
            if (button.getText().equals("Log in"))
                Assert.assertTrue(button.getText().contains("Log in"));
        }

    }

    @Test
    public void logedInUser() {

    }
}
