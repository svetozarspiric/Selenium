import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciPetak2111 {
    public static void main(String[] args) {


        //Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement continueShoppingButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueShoppingButton.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement addedToCartMessage = driver.findElement(By.cssSelector("h1[tabindex='-1']"));
        Assert.assertTrue(addedToCartMessage.isDisplayed());

        WebElement checkOutButton = driver.findElement(By.cssSelector("input[type='submit']"));
        Assert.assertTrue(checkOutButton.isDisplayed());

        WebElement chartIconCount = driver.findElement(By.linkText("1"));
        Assert.assertTrue(chartIconCount.isDisplayed());

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement emptyChartMessage = driver.findElement(By.cssSelector(".a-size-large.a-spacing-top-base.sc-your-amazon-cart-is-empty"));
        Assert.assertTrue(emptyChartMessage.isDisplayed());

        WebElement signInButton = driver.findElement(By.id("a-autoid-0-announce"));
        Assert.assertTrue(signInButton.isDisplayed());

        WebElement signUpButton = driver.findElement(By.id("a-autoid-1-announce"));
        Assert.assertTrue(signUpButton.isDisplayed());

        //brise se knjiga






    }
}
