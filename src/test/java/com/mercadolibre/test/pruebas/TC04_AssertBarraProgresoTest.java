package com.mercadolibre.test.pruebas;

import com.mercadolibre.pages.MercadoLibreHomePage;
import com.mercadolibre.pages.OfertasPage;
import com.mercadolibre.pages.OfertasRelampagoPage;
import com.mercadolibre.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import utils.Screenshot;

@Slf4j
public class TC04_AssertBarraProgresoTest extends BaseTest {

    @Test
    public void validacionBarraProgreso(){
        log.info("Step 1: Navigate to mercadolibre.com.mx");
        navigateTo("mercadolibre.com.mx");

        log.info("Step 2 : Dar click en opciòn Ofertas del menù");
        MercadoLibreHomePage ofertas = new MercadoLibreHomePage(getDriver());
        ofertas.clickOfertas();

        log.info("Step 3 : Dar click en opciòn Ofertas relampago");
        OfertasPage ofertasRel = new OfertasPage(getDriver());
        ofertasRel.clickOfertasRelampago();
        System.out.println(Screenshot.screenshot(getDriver()));

        log.info("Step 4 : Validar precensia de la Barra de progreso del producto");
        OfertasRelampagoPage barra = new OfertasRelampagoPage(getDriver());
        barra.validarBarraProgreso();

    }

}
