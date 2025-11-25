import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;

public class ForPetljaZadatak {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        //WebElement elementsButton = driver.findElement(By.className("card-body"));
        //elementsButton.click();

        ArrayList<WebElement> listOfButtons = new ArrayList<>(driver.findElements(By.className("card-body")));

        for (int i = 0; i < listOfButtons.size(); i++) {
            if (listOfButtons.get(i).getText().equals("Forms")) {
                listOfButtons.get(i).click();
                break;
            }
        }




    }
}
