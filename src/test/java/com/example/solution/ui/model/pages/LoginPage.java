package com.example.solution.ui.model.pages;

import com.codeborne.selenide.Condition;
import com.example.solution.ui.model.common.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class LoginPage extends BasePage<LoginPage> {
    MainPage mainPage = new MainPage();

    public LoginPage() {
        super("http://uitestingplayground.com/sampleapp", byId("login"));
    }

    @Step("Set value for username")
    public LoginPage setValueForUsername(String username){
        $(byAttribute("name", "UserName")).shouldBe(Condition.visible).setValue(username);
        log.debug("Username has been set: {}", username);
        return this;
    }

    @Step("Set value for password")
    public LoginPage setValueForPassword(String password){
        $(byAttribute("name", "Password")).shouldBe(Condition.visible).setValue(password);
        log.debug("Password has been set: {}", password);
        return this;
    }

    @Step("Click on Login")
    public MainPage clickLoginButton() {
        $(byId("login")).click();
        log.debug("Clicked on Login button");
        return mainPage;
    }
}
