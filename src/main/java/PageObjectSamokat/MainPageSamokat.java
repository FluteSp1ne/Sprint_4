package PageObjectSamokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageSamokat {

    private WebDriver driver;
    private By headerOrderButton = By.cssSelector(".Button_Button__ra12g");//Кнопка заказа в шапке сайта
    private By buttomOrderButton = By.xpath(".//*/div[5]/button");//Кнопка заказа внизу сайта
    private By dropdownList = By.id("accordion__heading-0");//Раскрывающийся список из раздела "Вопросы о важном"
    private By cookieButton = By.cssSelector(".App_CookieButton__3cvqF");// Кнопка "да все привыкли"
    private By textFirstDropDownElement = By.xpath(".//p[text() = 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    private String textFirstDropDown = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    public MainPageSamokat(WebDriver driver){
        this.driver = driver;
    }

    public void clickHeaderOrderButton(){
        driver.findElement(headerOrderButton).click();
    }
    public void clickButtomOrderButton(){
        WebElement element = driver.findElement(buttomOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttomOrderButton).click();
    }
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }
    public void clickDropdownList(){
        WebElement element = driver.findElement(dropdownList);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(dropdownList).click();
    }
    public void checkDropdownList() {
        assertTrue(driver.findElement(textFirstDropDownElement).isEnabled());
        assertEquals("Текст не совпадает", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", textFirstDropDown);
    }
}

