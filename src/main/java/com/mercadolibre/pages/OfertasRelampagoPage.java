package com.mercadolibre.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitsHelpers;

import java.time.Duration;

public class OfertasRelampagoPage {
    private WebDriver driver; //Inicializaciòn del atributo del WebDriver
    private WaitsHelpers wait; //Inicializaciòn del atributo del WaitsHelpers

    public OfertasRelampagoPage(WebDriver driver){//Constructor de la pagina OfertasRelampagoPage
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WaitsHelpers(driver);
    }

    //Uso de Page Factory para la busqueda de WebElement
    @FindBy(css = "#root-app > div.section_promotions_web > div.promotions_boxed-width > div > ol > li:nth-child(1) > div > a > div > div.promotion-item__description > div.promotion-item__lightning-deal-container > div.promotion-item__lightning-deal-progress-bar")
    WebElement progressBar;

    //Metodo para hacer click en el WebElement clickOfertasRelampago
    public void validarBarraProgreso(){
        wait.waitForElementByWebElement(progressBar, Duration.ofSeconds(10), Duration.ofSeconds(10));
        if (progressBar.isDisplayed()){
            System.out.println("La barra de progreso del producto se muestra correctamente");
        }else{
            System.out.println("La barra de progreso del producto NO se muestra correctamente!!!");
        }
    }






}
