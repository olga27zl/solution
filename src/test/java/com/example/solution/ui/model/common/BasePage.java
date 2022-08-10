package com.example.solution.ui.model.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.function.BiConsumer;

@Log4j2
public abstract class BasePage<PAGE extends BasePage<PAGE>> {
    private SelenideElement waitOpenPageElement;
    private String pageURL;
    private BiConsumer<SelenideElement, Duration> defaultWaitOpenPageLogic;

    protected BasePage(By waitOpenPageLocator) {
        this.defaultWaitOpenPageLogic = (waitOpenPageElement, duration) -> {
            waitOpenPageElement.shouldBe(Condition.visible, duration);
        };
        this.waitOpenPageElement = Selenide.$(waitOpenPageLocator);
    }

    protected BasePage(String pageURL, By waitOpenPageLocator) {
        this(waitOpenPageLocator);
        this.pageURL = pageURL;
    }

    @Step("Open page")
    public BasePage<PAGE> openPage() {
        if (StringUtils.isNotEmpty(this.pageURL)) {
            log.debug("Trying to open '{}' page", this.getClass().getSimpleName());
            Selenide.open(this.pageURL);
            log.debug("Opening '{}' page URL", this.pageURL);
            return this;
        } else {
            log.error("Page URL is empty, probably not establish");
            throw new UnsupportedOperationException("Page URL not establish");
        }
    }

    @Step("Wait for page to be open")
    public PAGE  waitUntilPageWillOpen(Duration duration) {
        String pageName = this.getClass().getSimpleName();
        log.debug("Waiting until '{}' page will open", pageName);
        this.defaultWaitOpenPageLogic.accept(this.waitOpenPageElement, duration);
        log.info("'{}' page was opened", pageName);
        return (PAGE) this;
    }

    public PAGE waitUntilPageWillOpen() {
       return waitUntilPageWillOpen(Duration.ofSeconds(60));
    }
}
