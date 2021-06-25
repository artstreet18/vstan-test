package ru.itis.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.data.User;

public class SignUpPage extends BasePage{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private By signUnButton = By.cssSelector("button");
    private By loginField;
    private By emailField;
    private By passwordField;
    private By repeatedPasswordField;

    @Step(value = "Регистрация")
    public SignUpPage signUn(User user, String repeatedPassword) {
        waitVisibility(signUnButton);
//        TODO:
//        insertLogin(user.login());
//        insertEmail(user.email());
//        insertPassword(user.password();
//        insertRepeatedPassword(repeatedPassword);
        click(signUnButton);
        return this;
    }

    @Step(value = "Ввод email {email}")
    public SignUpPage insertEmail(String email) {
        writeText(loginField, email);
        return this;
    }

    @Step(value = "Ввод логина {login}")
    public SignUpPage insertLogin(String login) {
        writeText(loginField, login);
        return this;
    }

    @Step(value = "Ввод пароль: {password}")
    public SignUpPage insertPassword(String password) {
        writeText(passwordField, password);
        return this;
    }

    @Step(value = "Ввод пароль повторно: {repeatedPassword}")
    public SignUpPage insertRepeatedPassword(String repeatedPassword) {
        writeText(passwordField, repeatedPassword);
        return this;
    }

    @Step(value = "Переход на страницу авторизации")
    @Override
    public SignUpPage goTo() {
        driver.get(SITE_URL);
        return this;
    }

}
