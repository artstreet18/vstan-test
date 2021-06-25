package ru.itis.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.data.User;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private By signInButton = By.cssSelector("button");
    private By loginField;
    private By passwordField;

    @Step(value = "Нажать на кнопку \"Войти\"")
    public SignInPage signIn(User user) {
        waitVisibility(signInButton);
//        TODO:
//        insertLogin(user.login());
//        insertPassword(user.password();
        click(signInButton);
        return this;
    }

    @Step(value = "Ввести login {login}")
    public SignInPage insertLogin(String login) {
        writeText(loginField, login);
        return this;
    }

    @Step(value = "Ввести пароль: {password}")
    public SignInPage insertPassword(String password) {
        writeText(passwordField, password);
        return this;
    }

    @Step(value = "Перейти на страницу авторизации")
    @Override
    public SignInPage goTo() {
        driver.get(SITE_URL);
        return this;
    }
}
