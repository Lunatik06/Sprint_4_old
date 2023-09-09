package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;
import pages.TrackPage;



// Проверка вопроса в блоке "Вопросы о важном"
public class QuestionTest {

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    public void checkQuestionBlock() {
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open()
                .scrollToBlockQuestion()
                .clickOnBlockQuestion()
                .checkHeaderBlockQuestion()
                .checkBodyBlockQuestion();
    }

}
