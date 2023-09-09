package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    final WebDriver driver;
    public static final By noImage = By.cssSelector("[alt='Not found']");
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }


    public OrderPage waitForNoStatus() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(noImage));
        return this;
    }


    // Поле "Имя"
    private static final By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    public OrderPage typeName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    // Поле "Фамилия"
    private static final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    public OrderPage typeSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
        return this;
    }


    // Поле "Адрес"
    private static final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public OrderPage typeAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return this;
    }


    // Список "Станция метро"
    private static final By stationInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private static final By selectStationInput = By.className("select-search__select");
    public OrderPage typeStation(String station) {
        driver.findElement(stationInput).click();
        driver.findElement(stationInput).sendKeys(station);
        driver.findElement(selectStationInput).click();
        return this;
    }

    // Поле "телефон"
    private static final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public OrderPage typePhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
        return this;
    }

    // Кнопка "далее"

    private static final By nextButton = By.xpath(".//button[contains(@class, 'Button_Middle') and (text()='Далее')]");
    public OrderPage clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    // Календарь "когда привезти самокат"
    private static final By dateDropdown = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By dayFromDateDropdown = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");

    public OrderPage chooseDateOfShipping() {
        driver.findElement(dateDropdown).click();
        driver.findElement(dayFromDateDropdown).click();
        return this;
    }
    // Список "срок аренды"
    private static final By periodUsingDropdown = By.className("Dropdown-control");
    private static final By secondPeriodUsingDropdown = By.xpath(".//div[(@class='Dropdown-menu')]/div[last()]");
    public OrderPage choosePeriodUsing() {
        driver.findElement(periodUsingDropdown).click();
        driver.findElement(secondPeriodUsingDropdown).click();
        return this;
    }
    // Чекбокс "цвет самоката
    private static final By colorCheckBox = By.id("grey");
    public OrderPage clickColor() {
        driver.findElement(colorCheckBox).click();
        return this;
    }


    // Поле "комментарий"
    private static final By commentInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public OrderPage typeComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }


    // Кнопка "заказать"

    private static final By orderButtonOnOrderPage = By.xpath(".//button[contains(@class, 'Button_Middle') and (text()='Заказать')]");
    public OrderPage clickOrderButtonOnOrderPage() {
        driver.findElement(orderButtonOnOrderPage).click();
        return this;
    }

    // Кнопка "да" в поп-апе подтверждения

    private static final By yesButtonOnPopup = By.xpath(".//button[contains(@class, 'Button_Middle') and (text()='Да')]");
    public OrderPage clickYesButtonOnPopup() {
        driver.findElement(yesButtonOnPopup).click();
        return this;
    }

    // Поп-ап об оформлении заказа
    public static final By confirmPopup = By.xpath(".//div[text()='Заказ оформлен']");
    public OrderPage checkConfirmPopup() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmPopup));
        return this;
    }
}


