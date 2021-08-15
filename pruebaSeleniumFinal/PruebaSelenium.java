package pruebaSeleniumFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*1. Crear una clase llamada PruebaSelenium
 */
public class PruebaSelenium {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        /*2. Ingresar a https://airbnb.com/
         */
        driver.get("https://airbnb.com/");
        /*3. Maximizar la pagina al iniciar cada test
         */
        driver.manage().window().maximize();
        /*4. Agregar una espera implícita al iniciar cada test
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

/*5. Crear un test que realice la búsqueda de un alojamiento para dos adultos: Se deben
    hacer el test con 3 lugares diferentes*/

    @Test(dataProvider = "Ubicacion", dataProviderClass = Dataprovider_Airbnb.class)
    public void alojamientoParaDos(String lugar) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='bigsearch-query-detached-query-input']")).sendKeys(lugar);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']")).click();
        driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-08-17']")).click();
        driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-08-25']")).click();
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']")).click();
        driver.findElement(By.xpath("//*[@aria-label='increase value']")).click();
        driver.findElement(By.xpath("//*[@aria-label='increase value']")).click();
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']")).click();
    }

/*6. En segundo escenario se debe realizar una búsqueda de experiencias. Se debe elegir
una fecha y un lugar: Madrid.
Validar que en la URL del sitio luego de la búsqueda, se encuentre la palabra Madrid y
la palabra experiences*/

    @Test
    public void experienciasMadrid() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='search-block-tab-false-EXPERIENCES']")).click();

        driver.findElement(By.xpath("//*[@id='bigsearch-query-detached-query-input']")).sendKeys("Madrid");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-dates-button']")).click();
        driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-08-17']")).click();
        driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-08-25']")).click();
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("Madrid") && URL.contains("experiences"), "contains words");
        System.out.println(URL);
    }

    /* 7. Se pide mostrar la lista de lugares cercanos. Se debe mostrar el lugar y horas en auto a
     ese lugar
     */
    @Test
    public void lugaresCercanos() throws InterruptedException {
        Thread.sleep(2000);

        List<WebElement> exploreNearValues = driver.findElements(By.xpath("//*[@class='_1slbw8s']"));

        boolean estaErrorDeContraseñaPresente = false;

        for (WebElement place : exploreNearValues) {
            System.out.println(place.getText());
        }
    }

    @AfterMethod
    public void closePage(){
        driver.close();
    }
}

