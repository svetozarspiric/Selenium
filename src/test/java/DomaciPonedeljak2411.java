import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class DomaciPonedeljak2411 {


    //Testirati prijavu na sajt https://demoqa.com/login pomocu kolacica
    //Test postavlja potrebne kolacice i otvara stranicu za prijavu kako bi simulirao ulogovanog korisnika,
    //zatim brise kolacice i proverava da li je korisnik izlogovan
    //Koristiit anotacije


    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeMethod
    public void openlogInPage() {
        driver.navigate().to("https://demoqa.com/login");
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }

    @Test
    public void logedInUser() throws InterruptedException {
        Cookie userID = new Cookie("userID", "c10e212c-6928-4f60-ac54-2b2e42fc3723");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InRlc3R1c2VyIiwicGFzc3dvcmQiOiJQYXNzd29yZEAxMjMiLCJpYXQiOjE3NjQxMTM4MTl9.Sa_VJ3gfeUO-KLZzMy3Y1WloXl48vq_DcwFRTUAlcBI");
        Cookie expires = new Cookie("expires", "2025-12-02T23%3A36%3A59.920Z");

        driver.manage().addCookie(userID);
        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement logInButton = driver.findElement(By.id("login"));
        Assert.assertTrue(logInButton.isDisplayed());

    }

}
