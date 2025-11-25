import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomaciUtorak1811 {
    public static void main(String[] args) throws InterruptedException {
        // Domaci:
    // Otvoriti youtube i pustiti pesmu po zelji
    // (prvo otvoriti pretrazivac, zatim search youtube, pa pustiti pesmu)


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/div[1]/form/input")).sendKeys("Grupa JNA - Fudbalski to je hram");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/button/span/span/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a/yt-formatted-string")).click();
        //iz nekog razloga (mozda jer sam zabranio svo pracenje i kolacice) snimak prekida vrlo brzo.
        //svakako sve geldam i pustam preko Brave-a, google sam zbog vas opet pravio :)



    }

}
