import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");

        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.id("searchbox_input"));
        searchBox.sendKeys("Wikipedia");
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement wikipediaButton = driver.findElement(By.cssSelector("a[data-testid='result-title-a']"));
        wikipediaButton.click();

        WebElement wikipediaSearchBox = driver.findElement(By.id("searchInput"));
        wikipediaSearchBox.sendKeys("Nikola Tesla");

        // Prvi nacin pretrage preko klase
        /*WebElement searchButtonByClass = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        searchButtonByClass.click();*/

        // Drugi nacin pretrage preko custom css
        WebElement searchButtonByCustomCSS = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButtonByCustomCSS.click();



    }
}
