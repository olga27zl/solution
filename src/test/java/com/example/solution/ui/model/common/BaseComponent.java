package com.example.solution.ui.model.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.time.Duration;

@Log4j2
public abstract class BaseComponent<COMPONENT extends BaseComponent<COMPONENT>> {
    private SelenideElement waitOpenComponentElement;
    protected BaseComponent(By waitOpenComponentElement) {
        this.waitOpenComponentElement = Selenide.$(waitOpenComponentElement);
    }

    @Step("Wait for component to be open")
    public COMPONENT waitUntilComponentWillOpen(Duration duration) {
        String componentName = this.getClass().getSimpleName();
        log.debug("Waiting until '{}' page component will open", componentName);
        this.waitOpenComponentElement.shouldBe(Condition.visible, duration);
        log.info("'{}' page component was opened", componentName);
        return (COMPONENT) this;
    }

    public COMPONENT waitUntilComponentWillOpen() {
        return this.waitUntilComponentWillOpen(Duration.ofSeconds(60));
    }

    @Step("Check component status")
    public Boolean isDisplayed(Duration duration) {
        boolean result;
        try {
            waitOpenComponentElement.shouldBe(Condition.visible, duration);
            result = true;
        } catch (UIAssertionError e) {
            /*ignore e*/
            result = false;
        }
        log.info("Is component displayed: {}", result);
        return result;
    }

    public Boolean isDisplayed() {
        boolean status = waitOpenComponentElement.isDisplayed();
        log.info("Is component displayed: {}", status);
        return status;
    }
}
