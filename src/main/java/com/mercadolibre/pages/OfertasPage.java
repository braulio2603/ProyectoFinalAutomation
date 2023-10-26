package com.mercadolibre.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitsHelpers;

import java.time.Duration;

public class OfertasPage {
     private WaitsHelpers wait; //Inicializaciòn del atributo del WaitsHelpers

    public OfertasPage(WebDriver driver){ //Constructor de la pagina OfertasPage
        PageFactory.initElements(driver, this);
        wait = new WaitsHelpers(driver);
    }

    //Uso de Page Factory para la busqueda de WebElement
    @FindBy(css = "#root-app > div.filters_header_container.full-carousel > section > div > section > div.andes-carousel-snapped__controls-wrapper > div > div > div.andes-carousel-snapped__slide.andes-carousel-snapped__slide--next > div")
    WebElement ofRelampago;

    //Metodo para hacer click en el WebElement clickOfertasRelampago
    public void clickOfertasRelampago(){
        wait.waitForElementByWebElement(ofRelampago, Duration.ofSeconds(10), Duration.ofSeconds(10));
        ofRelampago.click();
    }

}
