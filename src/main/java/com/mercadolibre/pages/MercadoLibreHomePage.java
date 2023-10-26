package com.mercadolibre.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import utils.WaitsHelpers;

import java.time.Duration;

public class MercadoLibreHomePage {
      private WaitsHelpers wait; //Inicializaciòn del atributo del WaitsHelpers

    public MercadoLibreHomePage(WebDriver driver) { //Constructor de la pagina MercadoLibreHomePage
        PageFactory.initElements(driver, this);
        wait = new WaitsHelpers(driver);
    }
    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[2]/a")//Uso de Page Factory para la busqueda de WebElement
    WebElement ofertas;
    public void clickOfertas() {//Metodo para hacer click en el WebElement ofertas
        wait.waitForElementByWebElement(ofertas, Duration.ofSeconds(10), Duration.ofSeconds(10));
        ofertas.click();
    }

}