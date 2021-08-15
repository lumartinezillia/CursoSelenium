package pruebaSeleniumFinal;

import PRUEBASELENIUM.TEST.prueba_mailchimp;
import org.testng.annotations.Factory;

public class testsFactory {
    @Factory
    public Object[] FactoryTest() {
        return new Object[]{
                new PruebaSelenium(),
                new PruebaSelenium(),
        };
    }
}

