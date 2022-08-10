package com.example.solution.ui.model.pages;

import com.example.solution.ui.model.common.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class MainPage extends BasePage<MainPage> {
    public MainPage() {
        super(byId("loginstatus"));
    }

    @Step("Get user welcome name")
    public String getInfoText(){
        String name = $(byId("loginstatus")).getText();
        log.info("The Welcome text name is: {}", name);
        return name;
    }
}
