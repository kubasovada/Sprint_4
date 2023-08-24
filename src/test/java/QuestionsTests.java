import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

@RunWith(Parameterized.class)
public class QuestionsTests {
    static WebDriver driver;

    private final int index;

    public QuestionsTests(int index) {
        this.index = index;
    }

    static String[] Answers = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    @Before
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Parameterized.Parameters
    public static Object[][] getIndex() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7}

        };
    }

    @Test
    public void isEveryFaqAnswerCorrectTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage.closeCookiePopupIfPresent();
        mainPage.scrollTo(index);
        mainPage.clickQuestion(index);
        var act = mainPage.getAnswerText(index);
        Assert.assertEquals(Answers[index], act);
    }

    @After
    public void killDriver() {
        driver.quit();
    }

}




