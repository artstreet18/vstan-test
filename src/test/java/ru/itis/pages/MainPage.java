package ru.itis.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By welcomeTextDiv;
    private By signInButton = By.cssSelector(".sc-kEqXSa");
    private By signUpButton;

    public void signInButtonClick() {
        waitVisibility(signInButton);
        click(signInButton);
    }

    public void signUnButtonClick() {
        waitVisibility(signUpButton);
        click(signUpButton);
    }

    @Step(value = "Переход на страницу авторизации")
    @Override
    public MainPage goTo() {
        driver.get(SITE_URL);
        return this;
    }
}
