package org.example;

import PageObjectSamokat.MainPageSamokat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class DropdownListTest {
    private WebDriver driver;

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
    public void checkDropdownList() {
        MainPageSamokat objMainPage = new MainPageSamokat(driver);
        objMainPage.clickDropdownList();
        objMainPage.checkDropdownList();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}


