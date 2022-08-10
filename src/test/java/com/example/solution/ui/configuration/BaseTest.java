package com.example.solution.ui.configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

@Log4j2
public abstract class BaseTest {
    @BeforeMethod
    public void beforeTest(ITestResult result) {
        log.info("Running test: " + result.getMethod().getMethodName());
    }

    @BeforeClass
    public static void setUpAll() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.driverManagerEnabled = false;
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
