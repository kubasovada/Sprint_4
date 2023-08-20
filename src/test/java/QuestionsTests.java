import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;


import static com.codeborne.selenide.Selenide.open;

public class QuestionsTests {

    @Before
    public void beforeSettings() {
        //Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test // проверка всех вопросов в одном тесте
    public void clickAllElements() {
        MainPage mainPage = open("https://qa-scooter.praktikum-services.ru/", MainPage.class);
        mainPage.closeCookiePopupIfPresent();
        Assert.assertTrue(mainPage.isEveryFaqAnswerCorrect());
    }
}


