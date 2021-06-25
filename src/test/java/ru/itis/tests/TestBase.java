package ru.itis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import ru.itis.pages.MainPage;
import ru.itis.pages.SetSettingsPage;
import ru.itis.pages.SignInPage;
import ru.itis.pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    public MainPage main;
    public SetSettingsPage setSettings;
    public SignInPage signIn;
    public SignUpPage signUp;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        main = new MainPage(driver);
        setSettings = new SetSettingsPage(driver);
        signIn = new SignInPage(driver);
        signUp = new SignUpPage(driver);
    }

    @SneakyThrows
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
