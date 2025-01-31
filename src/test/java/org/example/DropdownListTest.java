package org.example;

import PageObjectSamokat.MainPageSamokat;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DropdownListTest{
    private WebDriver driver;

    private final String expectedText;
    private final By locatorList;
    private final By locatorListButton;

    public DropdownListTest(String expectedText, By locatorList, By locatorListButton){
        this.expectedText = expectedText;
        this.locatorList = locatorList;
        this.locatorListButton = locatorListButton;
    }

    @Parameterized.Parameters
    public static Object[][] equalsText(){
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", By.xpath(".//p[text() = 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.']"), By.xpath(".//div[@id = 'accordion__heading-0']")},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", By.xpath(".//p[text() = 'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']"),By.xpath(".//div[@id = 'accordion__heading-1']")},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", By.xpath(".//p[text() = 'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']"), By.xpath(".//div[@id = 'accordion__heading-2']")},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", By.xpath(".//p[text() = 'Только начиная с завтрашнего дня. Но скоро станем расторопнее.']"), By.xpath(".//div[@id = 'accordion__heading-3']")},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", By.xpath(".//p[text() = 'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']"), By.xpath(".//div[@id = 'accordion__heading-4']")},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", By.xpath(".//p[text() = 'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']"), By.xpath(".//div[@id = 'accordion__heading-5']")},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", By.xpath(".//p[text() = 'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']"), By.xpath(".//div[@id = 'accordion__heading-6']")},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", By.xpath(".//p[text() = 'Да, обязательно. Всем самокатов! И Москве, и Московской области.']"), By.xpath(".//div[@id = 'accordion__heading-7']")},
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
    public void checkDropdownList() {
        WebElement element = driver.findElement(locatorListButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(locatorListButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(locatorList)));
        assertEquals("Текст не совпадает", expectedText, driver.findElement(locatorList).getText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}


