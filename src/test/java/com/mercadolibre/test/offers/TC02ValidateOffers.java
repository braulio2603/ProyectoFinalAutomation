package com.mercadolibre.test.offers;

import com.mercadolibre.pages.MercadoLibreHomePage;
import com.mercadolibre.pages.OfertasPage;
import com.mercadolibre.pages.OfertasRelampagoPage;
import com.mercadolibre.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Clase que integra los casos de pruebas para validar la pagina de ofertas en mercado libre.
 */
@Slf4j
public class TC02ValidateOffers extends BaseTest {

    @Test(testName = "Nombre del caso de prueba", description = "Descripción de lo que valida")
    public void AssertMenuOfertas() {
        String[] menuList = {"Todas las ofertas", "Ofertas relámpago", "Santa se adelanta", "Farmacia",
                "Liquidación", "Envío Gratis solo meli+"};

        log.info("Step 1: Navigate to mercadolibre.com.mx");//Metodo que permite generar log
        navigateTo("mercadolibre.com.mx");//Metodo para ingresar al sitio

        log.info("Step 2 : Dar click en opciòn Ofertas del menù");//Metodo que permite generar log
        MercadoLibreHomePage ofertas = new MercadoLibreHomePage(getDriver());//Intancia de la clase MercadoLibreHomePage
        ofertas.clickOfertas();//Invocacion del metodo click

        log.info("Step 3 : Validar elementos iniciales del menu");
        WebElement menuElement = getDriver().findElement(By.cssSelector("#root-app > div.filters_header_container.full-carousel > section > div > section > div.andes-carousel-snapped__controls-wrapper > div"));
        List<String> mylist = menuElement.findElements(By.tagName("p")).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        assertThat(mylist).contains(menuList);
    }

    @Test(testName = "Nombre del caso de prueba", description = "Descripción de lo que valida")
    public void validacionBarraProgreso() {
        log.info("Step 1: Navigate to mercadolibre.com.mx");
        navigateTo("mercadolibre.com.mx");

        log.info("Step 2 : Dar click en opciòn Ofertas del menù");
        MercadoLibreHomePage ofertas = new MercadoLibreHomePage(getDriver());
        ofertas.clickOfertas();

        log.info("Step 3 : Dar click en opciòn Ofertas relampago");
        OfertasPage ofertasRel = new OfertasPage(getDriver());
        ofertasRel.clickOfertasRelampago();

        log.info("Step 4 : Validar precensia de la Barra de progreso del producto");
        OfertasRelampagoPage orp = new OfertasRelampagoPage(getDriver());
        assertThat(orp.isDisplayedWebElementProgressBar(getDriver())).isTrue();
    }
}
