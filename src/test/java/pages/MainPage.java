package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {


    final WebDriver driver;


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }


    // Кнопка "Статус заказа"
    private static final By statusButton = By.className("Header_Link__1TAG7");
    public MainPage showStatus() {
        driver.findElement(statusButton).click();
        return this;
    }


    //Инпут для номера заказа
    private static final By orderInput = By.xpath(".//input[contains(@class, 'Input_Input_')]");
    public MainPage typeOrderNumber(String orderNumber) {
        driver.findElement(orderInput).sendKeys(orderNumber);
        return this;
    }

    // Кнопка «GO»
    private static final By goButton = By.xpath(".//button[contains(@class, 'Header_Button') and (text()='Go!')]");
    public TrackPage clickOnGo() {
        driver.findElement(goButton).click();
        return new TrackPage(driver);
    }

    // 2-ой пункт из блока "Сколько это стоит? И как оплатить?"
    private static final By blockQuestion = By.id("accordion__heading-1");
    public MainPage clickOnBlockQuestion() {
        driver.findElement(blockQuestion).click();
        return new MainPage(driver);
    }

    // получить заголовок 2-го пункта из блока "Сколько это стоит? И как оплатить?"

    public MainPage checkHeaderBlockQuestion() {
        String textHeaderQuestion = driver.findElement(blockQuestion).getText();
        assertEquals("Хочу сразу несколько самокатов! Так можно?", textHeaderQuestion);
        return new MainPage(driver);

    }

    // получить тело 2-го пункта из блока "Сколько это стоит? И как оплатить?"
    private static final By bodyQuestion = By.xpath(".//div[@id='accordion__panel-1']/p");
    public MainPage checkBodyBlockQuestion() {
        String textBodyQuestion = driver.findElement(bodyQuestion).getText();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", textBodyQuestion);
        return new MainPage(driver);
    }

    // прокрутка до акордиона
    public MainPage scrollToBlockQuestion() {
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return new MainPage(driver);
    }


    // кнопка заказать в онбординге
    private static final By orderOnboardingButton = By.xpath(".//button[contains(@class, 'Button_Middle') and (text()='Заказать')]");
    public MainPage clickOrderOnboardingButton() {
        driver.findElement(orderOnboardingButton).click();
        return this;
    }



    // кнопка заказать
    private static final By orderButton = By.className("Button_Button__ra12g");
    public OrderPage clickOnOrderButton() {
        driver.findElement(orderButton).click();
        return new OrderPage(driver);
    }
}
