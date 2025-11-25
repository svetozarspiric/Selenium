


        import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

        public class Selenium7 {
            public static void main(String[] args) {

                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.navigate().to("https://wordpress.com/");

                Cookie cookie = new Cookie("", "");
                driver.manage().addCookie(cookie);
                driver.navigate().refresh();

                // Dodavanje cookie-ja
                Cookie testCookie = new Cookie("ime za log in", "vrednost");
                driver.manage().addCookie(testCookie);
                // Refresh da cookie bude aktivan
                driver.navigate().refresh();
                // Brisanje jednog cookie-ja
                driver.manage().deleteCookie(testCookie);
                // Brisanje cookie-ja po imenu
                driver.manage().deleteCookieNamed("wordpress_logged_in");
                // Brisanje svih cookie-ja
                driver.manage().deleteAllCookies();



            }
        }

