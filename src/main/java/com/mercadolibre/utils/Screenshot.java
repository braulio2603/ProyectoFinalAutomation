package com.mercadolibre.utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class Screenshot {

    private static Screenshot screenshot;

    @Getter
    private static WebDriver driver;
    private static String directory = "";

    /**
     * Constructor privado que asigna un driver de inicio.
     * @param driver
     */
    private Screenshot(WebDriver driver){
        this.driver = driver;
        directory = String.format("src/test/resources/screenshot/%s", new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));
    }

    /**
     * Metodo que permite el uso del patron de diseño Singleto (Invetigar más)
     * @return retorna una instancia de Screenshot.class
     * @param driver recibe como parametro un Driver que se lo pasa al constructor de la clase
     */
    public static Screenshot getInstance(WebDriver driver){
        if(screenshot == null) screenshot = new Screenshot(driver);
        return screenshot;
    }

    /**
     * Método que permite crear una captura de imagen y la almacena en un directorio especifico dentro del proyecto
     */
    public static void screenshot() {
        String fileName = String.format("screenshot_%s.png", new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()));

        File dirScreenshot = new File(directory);
        if(!dirScreenshot.exists()){
            log.debug("Se crea el directorio para las capturas de imagenes");
            dirScreenshot.mkdirs();
        }

        File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(dirScreenshot, fileName);

        try {
            Files.copy(screenshotFile.toPath(), newScreenshotFile.toPath());
            log.info("Screenshot {}", newScreenshotFile.toURI().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
