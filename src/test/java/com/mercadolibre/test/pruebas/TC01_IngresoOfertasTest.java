package com.mercadolibre.test.pruebas;

import com.mercadolibre.pages.MercadoLibreHomePage;
import com.mercadolibre.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import utils.Screenshot;

@Slf4j//Libreria para poder generar logs
public class TC01_IngresoOfertasTest extends BaseTest {//Nombre de la Clase y heredaciòn de la clase BaseTest

    @Test//Anotaciòn de TestNG para marcar que el metodo es un caso de prueba y lo pueda ejecutar como tal
    public void ingresoOfertas(){
        log.info("Step 1: Navigate to mercadolibre.com.mx");//Metodo que permite generar log
        navigateTo("mercadolibre.com.mx");//Metodo para ingresar al sitio

        log.info("Step 2 : Dar click en opciòn Ofertas del menù");//Metodo que permite generar log
        MercadoLibreHomePage ofertas = new MercadoLibreHomePage(getDriver());//Intancia de la clase MercadoLibreHomePage
        ofertas.clickOfertas();//Invocacion del metodo click
        System.out.println(Screenshot.screenshot(getDriver()));//Generaciòn de screenshot
         }

}
