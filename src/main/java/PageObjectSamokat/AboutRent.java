package PageObjectSamokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRent {

    private WebDriver driver;
    private By whenToBringField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']"); //Поле "Когда привезти самокат"
    private By rentalPeriodField = By.xpath(".//div[text() = '* Срок аренды']");//Поле "Срок аренды"
    private By colorScooterBlackBox = By.id("black");//Чек-бокс "Чёрный жемчуг
    private By commentForCourierField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");//Поле "Комментарий"
    private By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g']");//Кнопка "Заказать"
    private By confirmButton = By.xpath(".//button[text() = 'Да']");//Кнопка "Да"
    private By orderText = By.cssSelector(".Order_Text__2broi");//Текст заказа
    private By calendar = By.xpath(".//div[text() = '5']");//Календарь
    private By renta = By.xpath(".//div[text() = 'сутки']");//Выбор срока аренды

    public AboutRent(WebDriver driver){
        this.driver = driver;
    }

    public void setWhenToBring(){
        driver.findElement(whenToBringField).click();
        driver.findElement(calendar).click();
    }
    public void setRentalPeriod(){
        driver.findElement(rentalPeriodField).click();
        driver.findElement(renta).click();
    }
    public void setColorScooterBlackBox(){
        driver.findElement(colorScooterBlackBox).click();
    }
    public void setCommentForCourierField(String comment){
        driver.findElement(commentForCourierField).sendKeys(comment);
    }
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(confirmButton)));
    }
    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }
    public void checkOrderText(){
        driver.findElement(orderText);
    }
}
