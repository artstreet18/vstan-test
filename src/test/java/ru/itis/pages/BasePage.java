package ru.itis.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final String SITE_URL = "https://thenewschool.dev/login";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @Step(value = "go to homePage")
    protected BasePage goTo(){
        driver.get(SITE_URL);
        return this;
    }

    protected void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    protected boolean isElementDisplayed(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).isDisplayed();

    }

    protected   void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    protected   void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    protected String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

}
