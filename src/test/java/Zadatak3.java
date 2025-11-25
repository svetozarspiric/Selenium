import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        //Zadatak 3
    //Otici na neki pretrazivac
    //Zatim ukucati "Wikipedia" u polje za pretragu
    //Odraditi pretragu i otvoriti stranicu
    //Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com/");

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea")).sendKeys("Wikipedia");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/h2/a")).click();

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/a/span[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div/div/form/div/div/div[1]/input")).sendKeys("Nikola Tesla");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div/div/form/div/div/div[1]/span/svg")).click();



    }
}
