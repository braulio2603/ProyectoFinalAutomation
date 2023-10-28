package com.mercadolibre.utils.reports;

import com.mercadolibre.utils.Screenshot;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

/**
 * Clase que permite extender la implementación de TestListener y poder manipular los mensajes de error.
 */
@Slf4j
public class ReportTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("---------- Start Test: {} ----------", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("---------- Success Test: {} ----------", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("---------- Fail Test: {} ----------", result.getName());
        Screenshot.screenshot();
    }

    @Override
    public void onFinish(ITestContext context) {
        Arrays.stream(context.getAllTestMethods()).forEach(iTestNGMethod -> {
            log.info("---------- Fail Test: {} ----------", iTestNGMethod.getMethodName());
        });
    }
}
