import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.time.Duration;

public class QuestionsTests {
    WebDriver driver;

    @Before
    public void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void isEveryFaqAnswerCorrectTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage.closeCookiePopupIfPresent();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertTrue(mainPage.isEveryFaqAnswerCorrect());
    }

    @After
    public void killDriver() {
        driver.quit();
    }

}




