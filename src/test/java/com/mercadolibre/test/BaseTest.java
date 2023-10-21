package com.mercadolibre.test;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@Slf4j
@Getter
public class BaseTest {

    private WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest(){getDriver().quit();}

    public void navigateTo(String _url){

        String url = String.format("http://%s", _url);
        getDriver().get(url); //se comenta esta linea para que muestre log de errores

        if(!getDriver().getCurrentUrl().contains(_url)){
            log.error("El navegador no pudo navegar a la pagina solicitada");
            throw new RuntimeException("No se encontro " + url);
        }

    }
}
