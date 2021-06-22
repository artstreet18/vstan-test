package ru.itis.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.itis.Data.User;

import javax.annotation.concurrent.GuardedBy;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    By signInButton = By.cssSelector("button");
    By loginField;
    By passwordField;

    @Step(value = "Click to \"Войти\"")
    public SignInPage signIn(User user){
        waitVisibility(signInButton);
//        insertLogin(user);
//        insertPassword(user);
        click(signInButton);
        return this;
    }

    public SignInPage insertLogin(User user){
        writeText(loginField,user.login());
        return this;
    }

    public SignInPage insertPassword(User user){
        writeText(passwordField,user.password());
        return this;
    }

    @Step(value = "go to SignIp page")
    @Override
    public SignInPage goTo(){
        driver.get(SITE_URL);
        return this;
    }
}