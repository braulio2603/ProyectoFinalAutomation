package com.mercadolibre.test.pruebas;

import com.mercadolibre.pages.MercadoLibreHomePage;
import com.mercadolibre.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Screenshot;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TC02_AsserMenuOfertasTest extends BaseTest {//Nombre de la Clase y heredaciòn de la clase BaseTest

    @Test//Anotaciòn de TestNG para marcar que el metodo es un caso de prueba y lo pueda ejecutar como tal
    public void AssertMenuOfertas(){
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
        System.out.println(Screenshot.screenshot(getDriver()));
    }
}
