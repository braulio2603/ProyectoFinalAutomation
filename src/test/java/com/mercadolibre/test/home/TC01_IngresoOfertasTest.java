package com.mercadolibre.test.home;

import com.mercadolibre.pages.MercadoLibreHomePage;
import com.mercadolibre.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Clase de prueba para validar la sección de oferas de mercado libre
 */
@Slf4j//Libreria para poder generar logs
public class TC01_IngresoOfertasTest extends BaseTest {

    @Test(description = "Caso de prueba para validar la navegacion a la sección de ofertas")
    public void ingresoOfertas(){
        log.info("Step 1: Navigate to mercadolibre.com.mx");
        navigateTo("mercadolibre.com.mx");

        log.info("Step 2 : Dar click en opciòn Ofertas del menù");//Metodo que permite generar log
        MercadoLibreHomePage ofertas = new MercadoLibreHomePage(getDriver());//Intancia de la clase MercadoLibreHomePage
        ofertas.clickOfertas();//Invocacion del metodo click

        log.info("Step validation: Validamos si se pudo abrir la pagina de ofertas");
        assertThat(ofertas.existLabelOffers()).as("No se encontro el elemento en la pagina").isTrue();
    }

}
