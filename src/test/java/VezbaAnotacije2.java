import org.openqa.selenium.By;
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

public class VezbaAnotacije2 {

    WebDriver driver;
    WebDriverWait wait;

    String firstName;
    String lastName ;
    String email;
    String age;
    String salary;
    String department;

    @BeforeClass
    public void Object() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }

    @BeforeMethod
    public void testPath() {
        driver.navigate().to("https://demoqa.com/");

        WebElement elementCard = driver.findElement(By.className("card-up"));
        elementCard.click();

        WebElement webTablesField = driver.findElement(By.id("item-3"));
        webTablesField.click();

        WebElement webTableAddButton = driver.findElement(By.id("addNewRecordButton"));
        webTableAddButton.click();

        WebElement registrationFormText = driver.findElement(By.id("registration-form-modal"));
        Assert.assertTrue(registrationFormText.isDisplayed());


    }

    @Test
    public void addUser() {
        firstName = "Pera";
        lastName = "Peric";
        email = "peraperic@gmail.com";
        age = "33";
        salary = "1200";
        department = "Marketing";

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys(email);

        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys(age);

        WebElement salaryField = driver.findElement(By.id("salary"));
        salaryField.sendKeys(salary);

        WebElement departmentField = driver.findElement(By.id("department"));
        departmentField.sendKeys(department);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        List<WebElement> listOfUsers = driver.findElements(By.className("rt-td"));
        for (WebElement user : listOfUsers) {
            if (user.getText().equals(firstName))
                Assert.assertTrue(user.getText().contains(firstName));
        }
        }




    @Test
    public void addThreeUsers() {

    }

}

