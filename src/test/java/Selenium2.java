import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Selenium2 {
    public static void main(String[] args) {


        // 0
        // 0 - 1
        // 0 - 1 - 2 -- rucno otvaranje tabova

        // 0 - 1
        // 0 - 2 - 1
        // 0 - 3 - 2 - 1 -- selenium otvara na ovaj nacin tabove jer dok saljemo skriptu za otvaranje
        // driver to radi sa taba 0 i novi tab otvara odmah do sebe

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        // JavascriptExecutor nam pomaze da posaljemo skriptu koja ce uraditi neku akciju
        // koju ne mozemo uraditi 'jednostavnijim' koracima, kao sto je otvaranje tabova
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Obratite paznju kako pisete skripte jer ne postoji provera da li ste dobro ukucali skriptu
        // Ako pogresno napisete program ce izvrsiti tu skriptu i nece prijaviti gresku
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        // Da bih radio sa ostalim tabovima moram da prebacim fokus drivera na ostale tabove
        // To radim tako sto napravim listu koju ce driver da napuni sa TRENUTNO otvorenim tabovima
        // Napomena da ce ova lista krenuti od indexa 0
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        System.out.println(listaTabova);

        // Ako hocu da promenim fokus drivera potrebno je da to uradim na sledeci nacin
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com/");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com/");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.joberty.com/");

        // close() akcija ce zatvoriti trenutni tab
        driver.close();

        // Ako zelim da zatvorim jos neki tab moram prvo da prebacim fokus na taj tab pa onda da ga zatvorim
        driver.switchTo().window(listaTabova.get(2));
        driver.close();

        driver.switchTo().window(listaTabova.get(1));
        driver.close();

    }
}
