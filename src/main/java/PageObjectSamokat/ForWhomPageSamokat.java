package PageObjectSamokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForWhomPageSamokat {

    private WebDriver driver;
    public By headLineForWhom = By.cssSelector(".Order_Header__BZXOb");//Заголовок страницы "Для кого"
    private By nameField = By.xpath(".//input[@placeholder = '* Имя']");//Поле "Имя"
    private By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");//Поле "Фамилия"
    private By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");//Поле "Адрес"
    private By metroStationField = By.xpath(".//input[@placeholder = '* Станция метро']");//Поле "Станция метро"
    private By numberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");//Поле "Телефон"
    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");//Кнопка "Далее"

    public ForWhomPageSamokat(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void setSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void setMetroStation(){
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//button[@value = '2']")).click();

    }
    public void setNumber(String number){
        driver.findElement(numberField).sendKeys(number);
    }
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
}
