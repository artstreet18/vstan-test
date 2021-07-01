package ru.itis.pages;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.data.User;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private By signInButton = By.cssSelector(".sc-jrsJWt");
    private By loginField = By.name("email");
    private By passwordField = By.name("password");
    private By loginText = By.cssSelector(".sc-gKAaRy.diEskx");

    @SneakyThrows
    @Step(value = "Авторизация")
    public SignInPage signIn(User user) {
        waitVisibility(signInButton);
        insertLogin(user.login());
        insertPassword(user.password());
        click(signInButton);
        return this;
    }

    @Step(value = "Ввод логина {login}")
    public SignInPage insertLogin(String login) {
        writeText(loginField, login);
        return this;
    }

    @Step(value = "Ввод пароля: {password}")
    public SignInPage insertPassword(String password) {
        writeText(passwordField, password);
        return this;
    }

    public String authorizedLogin(){
        return readText(loginText);
    }

    @Step(value = "Переход на страницу авторизации")
    @Override
    public SignInPage goTo() {
        driver.get(SITE_URL);
        return this;
    }


}
