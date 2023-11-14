package com.mercadolibre.pages;

import com.mercadolibre.bussines.Validations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mercadolibre.utils.WaitsHelpers;

import java.time.Duration;

public class OfertasRelampagoPage {

    public OfertasRelampagoPage(WebDriver driver){//Constructor de la pagina OfertasRelampagoPage
        PageFactory.initElements(driver, this);
    }

    // WebElements

    @FindBy(css = "#root-app > div.section_promotions_web > div.promotions_boxed-width > div > ol > li:nth-child(1) > div > a > div > div.promotion-item__description > div.promotion-item__lightning-deal-container > div.promotion-item__lightning-deal-progress-bar")
    WebElement progressBar; //Uso de Page Factory para la busqueda de WebElement

    // Methods

    /**
     * Metodo que valida si esta disponible el elemento web en la pagina.
     *
     * @return true Sí el elemento web esta visible en la pagina.
     * @param driver Recibe el driver del cual se verifica si el elemento esta disponible
     */
    public boolean isDisplayedWebElementProgressBar(WebDriver driver){
        return Validations.isDisplayedWebElement(progressBar, driver);
    }






}
