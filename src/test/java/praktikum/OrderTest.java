package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;
import pages.TrackPage;

import static junit.framework.TestCase.assertEquals;


// параметризованный сценарий по созданию заказа
@RunWith(Parameterized.class)
public class OrderTest {


    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phone;
    private final String comment;


        public OrderTest(String name, String surname, String address, String station, String phone, String comment) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.station = station;
            this.phone = phone;
            this.comment = comment;
        }

        // Тестовые данные
        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][] {
                    { "Алексей", "Желторотов", "г. Верхний Тор-Плюс, ул. Ленсовета, д. 91, кв. 12", "Кузьминки", "89992542934", ""},
                    { "Иван", "Петров", "г. Москва, ул. Дворцовая, д. 9, кв. 55", "ВДНХ", "+79992542934", "Позвоните за 15 минут до прибытия."},
            };
        }


    @Rule
    public DriverRule driverRule = new DriverRule();

    //  Заказ через кнопку в хедере
    @Test
    public void createOrderWithHeaderButton() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open()
                .clickOnOrderButton();

        OrderPage orderPage = new OrderPage(driverRule.getDriver());

        orderPage.typeName(name)
                .typeSurname(surname)
                .typeAddress(address)
                .typeStation(station)
                .typePhone(phone)
                .clickNextButton()
                .chooseDateOfShipping()
                .choosePeriodUsing()
                .clickColor()
                .typeComment(comment)
                .clickOrderButtonOnOrderPage()
                .clickYesButtonOnPopup()
                .checkConfirmPopup();
    }

    //  Заказ через кнопку в инструкции снизу
    @Test
    public void createOrderWithOnboardingButton() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open()
                .scrollToBlockQuestion()
                .clickOrderOnboardingButton();

        OrderPage orderPage = new OrderPage(driverRule.getDriver());

        orderPage.typeName(name)
                .typeSurname(surname)
                .typeAddress(address)
                .typeStation(station)
                .typePhone(phone)
                .clickNextButton()
                .chooseDateOfShipping()
                .choosePeriodUsing()
                .clickColor()
                .typeComment(comment)
                .clickOrderButtonOnOrderPage()
                .clickYesButtonOnPopup()
                .checkConfirmPopup();

    }



}
