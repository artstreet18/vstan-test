package ru.itis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By welcomeTextDiv;
    private By signInButton;
    private By signUpButton;

    public void signInButtonClick() {
        waitVisibility(signInButton);
        click(signInButton);
    }

    public void signUnButtonClick() {
        waitVisibility(signUpButton);
        click(signUpButton);
    }
}
