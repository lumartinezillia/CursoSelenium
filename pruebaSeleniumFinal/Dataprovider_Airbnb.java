package pruebaSeleniumFinal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_Airbnb {

    WebDriver driver;

    @DataProvider(name = "Ubicacion")
    public Object[][] EmailsTest() {
        return new Object[][]{

                {"Montevideo"},
                {"Buenos Aires"},
                {"Madrid"}
        };
    }
}
