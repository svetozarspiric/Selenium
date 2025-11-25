import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        //Ovako postaljamo drajver

        WebDriver driver = new ChromeDriver();
        //U ovoj komandi kreiram objekat sa koijm radim i kome dajem instrukcije.
        driver.manage().window().maximize();
        //Povecava prozor browsera
        driver.navigate().to("https://www.google.com/");
        //otvara odredjeni URL koji upisemo
        //Isto radi i .get
        //URL mora biti u URL formi !!
        //Najbolja praksa kopirati link sa stranice.

        System.out.println("Trenutni URL");
        System.out.println(driver.getCurrentUrl());
        //Ovom komandom hvatamo trenutni link stranice
        //Komanda nam sluzi kasnije za asertovanje stranice
        driver.navigate().to("https://www.youtube.com/");
        System.out.println("Trenutni URL");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        // Komanda koja vraca browser korak nazad

        System.out.println("Trenutni URL");
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        // Komanda koja ide korak napred
        driver.navigate().refresh();
        //Refresuje browser
        driver.quit();
        // Ovom komandom zatvaramo browser
        // Slicno tome imamo i driver.close() koji ce da zatvori trenutni tab







    }
}
