package ru.itis.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Pattern;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By welcomeTextDiv;
    private By signInButton = By.cssSelector(".sc-hBMUJo.dwClCW");
    private By signUpButton;
    private By signOutButton = By.cssSelector(".sc-hBMUJo.dwClCW");
    private By obscureElement = By.cssSelector(".sc-eCApnc.ftKSen.shadow-exit.shadow-exit-active");

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

    public MainPage signOut(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(obscureElement));
        click(signInButton);
        return this;
    }


}
