package com.example.solution.ui;

import com.example.solution.ui.configuration.BaseTest;
import com.example.solution.ui.model.pages.LoginPage;
import com.example.solution.ui.model.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void userLoginSuccessfully() {
        loginPage.openPage()
                .waitUntilPageWillOpen()
                .setValueForUsername("Name")
                .setValueForPassword("pwd")
                .clickLoginButton()
                .waitUntilPageWillOpen();

        Assert.assertTrue(mainPage.getInfoText().contains("Welcome"), "User is successfully logged in");
    }

    @Test
    public void userTriesToLoginWithIncorrectPassword() {
        loginPage.openPage()
                .waitUntilPageWillOpen()
                .setValueForUsername("Olga")
                .setValueForPassword("psd")
                .clickLoginButton();

        Assert.assertEquals(mainPage.getInfoText(), "Invalid username/password", "User is successfully logged in");
    }


    @Test
    public void userTriesToLoginWithEmptyPassword() {
        loginPage.openPage()
                .waitUntilPageWillOpen()
                .setValueForUsername("Olga")
                .setValueForPassword(" ")
                .clickLoginButton();

        Assert.assertEquals(mainPage.getInfoText(), "Invalid username/password", "User is successfully logged in");
    }

    @Test
    public void userTriesToLoginWithEmptyUsername() {
        loginPage.openPage()
                .waitUntilPageWillOpen()
                .setValueForUsername("")
                .setValueForPassword("pwd")
                .clickLoginButton();

        Assert.assertEquals(mainPage.getInfoText(), "Invalid username/password", "User is successfully logged in");
    }


}
