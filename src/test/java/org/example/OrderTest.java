package org.example;

import PageObjectSamokat.AboutRent;
import PageObjectSamokat.ForWhomPageSamokat;
import PageObjectSamokat.MainPageSamokat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;

    private final String name;
    private final String surName;
    private final String address;
    private final String number;
    private final String comment;

    public OrderTest(String name, String surName, String address, String number, String date, String comment){
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.number = number;
        this.comment = comment;
    }


    @Parameterized.Parameters
    public static Object[][] ForWhomFields(){
        return new Object[][]{
                {"Леонид", "Блюмгарт", "Тверская, 55", "89030221221", "09.09.2025", "Очень жду, спасибо!"},
                {"Алан", "Вейк", "Оушен Вью, 665", "88005553535","08.04.2026",""},
        };
    }
    @Before
    public void startUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        objMainPage.clickCookieButton();
    }
    @Test
    public void orderHeader(){
        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        ForWhomPageSamokat objForWhom = new ForWhomPageSamokat(driver);
        objMainPage.clickHeaderOrderButton();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(objForWhom.headLineForWhom));
        objForWhom.setName(name);
        objForWhom.setSurname(surName);
        objForWhom.setAddress(address);
        objForWhom.setMetroStation();
        objForWhom.setNumber(number);
        objForWhom.clickNextButton();

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.setWhenToBring();
        objAboutRent.setRentalPeriod();
        objAboutRent.setColorScooterBlackBox();
        objAboutRent.setCommentForCourierField(comment);
        objAboutRent.clickOrderButton();
        objAboutRent.clickConfirmButton();
        objAboutRent.checkOrderText();
    }
    @Test
    public void orderButtom(){
        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        objMainPage.clickButtomOrderButton();
        ForWhomPageSamokat objForWhom = new ForWhomPageSamokat(driver);
        objForWhom.setName(name);
        objForWhom.setSurname(surName);
        objForWhom.setAddress(address);
        objForWhom.setMetroStation();
        objForWhom.setNumber(number);
        objForWhom.clickNextButton();

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.setWhenToBring();
        objAboutRent.setRentalPeriod();
        objAboutRent.clickOrderButton();
        objAboutRent.clickConfirmButton();
        objAboutRent.checkOrderText();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
