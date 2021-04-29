package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {
    private WebDriver getSpotifyDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        return driver;
    }

    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {
        WebDriver driver = getSpotifyDriver();
        WebElement correo = driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']"));
        WebElement confirmarCorreo = driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']"));
        WebElement crearContraseña = driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']"));
        WebElement nombrePerfil = driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']"));
        WebElement diaNacimiento = driver.findElement(By.cssSelector("input[placeholder='DD']"));
        WebElement mesNacimiento = driver.findElement(By.cssSelector("option[value='08']"));
        WebElement añoNacimiento = driver.findElement(By.cssSelector("input[placeholder='AAAA']"));
        WebElement sexo = driver.findElement(By.cssSelector("label[for='gender_option_female']"));

        correo.sendKeys("test@test.com");
        confirmarCorreo.sendKeys("test@test.com");
        crearContraseña.sendKeys("test1234");
        nombrePerfil.sendKeys("TestName");
        diaNacimiento.sendKeys("11");
        mesNacimiento.click();
        añoNacimiento.sendKeys("1989");
        sexo.click();

        Thread.sleep(6000);
        driver.close();
    }
}
