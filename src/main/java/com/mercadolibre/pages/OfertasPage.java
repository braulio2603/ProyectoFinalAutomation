package com.mercadolibre.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OfertasPage {
    private WebDriver driver; //Inicializaciòn del atributo del WebDriver
    private WebDriverWait wait; //Inicializaciòn del atributo del WebDriverWait

    public OfertasPage(WebDriver driver){ //Constructor de la pagina OfertasPage
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Uso de Page Factory para la busqueda de WebElement
    @FindBy(css = "#root-app > div.filters_header_container.full-carousel > section > div > section > div.andes-carousel-snapped__controls-wrapper > div > div > div.andes-carousel-snapped__slide.andes-carousel-snapped__slide--next > div")
    WebElement ofRelampago;

    //Metodo para hacer click en el WebElement clickOfertasRelampago
    public void clickOfertasRelampago(){
        ofRelampago.click();
    }

}
