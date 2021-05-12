package clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFailureTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=eu");
    }

    @Test(priority = 3)
    public void logInFailureTest(){
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("123466");
        driver.findElement(By.id("Login")).click();
        String error = driver.findElement(By.id("error")).getText();
        System.out.println("El error que se obtiene es " + error);
    }

}
