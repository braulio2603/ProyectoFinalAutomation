package com.mercadolibre.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mercadolibre.utils.WaitsHelpers;

import java.time.Duration;

/**
 * Clase que representa la pagina del home de MercadoLibre
 */
public class MercadoLibreHomePage {

    private WaitsHelpers wait; //Variable de tipo WaitsHelpers para la manipulación de los waits

    /**
     * Contructor que inicializa la pagina para ser maniupalada por el driver
     * @param driver
     */
    public MercadoLibreHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WaitsHelpers(driver);
    }

    // WebElements

    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[2]/a")
    WebElement ofertas;

    @FindBy(css = "div > h1.header_title")
    private WebElement labelTitleOffers;

    // Méthods

    /**
     * Metodo para hacer click en el WebElement ofertas
     */
    public void clickOfertas() {
        wait.waitForElementByWebElement(ofertas, Duration.ofSeconds(10), Duration.ofSeconds(2)).click();
    }

    /**
     * Método que valida si un elemento esta disponible o no.
     *
     * @return true si el elementos se encuentra visible en la pagina.
     */
    public boolean existLabelOffers(){
        return wait.waitForElementByWebElement(labelTitleOffers, Duration.ofSeconds(10), Duration.ofSeconds(2)).isDisplayed();
    }
}