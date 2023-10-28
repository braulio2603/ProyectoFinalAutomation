package com.mercadolibre.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.mercadolibre.utils.Screenshot;
import com.mercadolibre.utils.reports.ReportTestListener;

import java.lang.reflect.Method;

/**
 * Clase que funciona como base para realizar configuraciones de arranque de los test
 */
@Slf4j
@Getter
@Listeners(ReportTestListener.class)
public class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod(Method method) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Screenshot.getInstance(driver);
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().quit();
    }

    /**
     * Metodo para ingresar la URL
     *
     * @param _url La URL es http
     */
    public void navigateTo(String _url) {
        String url = String.format("http://%s", _url);
        getDriver().get(url); //se comenta esta linea para que muestre log de errores

        if (!getDriver().getCurrentUrl().contains(_url)) {
            log.error("El navegador no pudo navegar a la pagina solicitada");
            throw new RuntimeException("No se encontro " + url);
        }

    }
}
