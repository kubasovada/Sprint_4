package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;


public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // локатор вопросов
    private final By faqQuestions = By.className("accordion__button");

    // локатор ответов
    private final By faqAnswers = By.xpath(".//div[@data-accordion-component='AccordionItemPanel']/p");


    public List<WebElement> getQuestions() {
        var allFaqQuestions = driver.findElements(faqQuestions);
        return allFaqQuestions;
    }

    public List<WebElement> getAnswers() {
        var allFaqQuestions = driver.findElements(faqAnswers);
        return allFaqQuestions;
    }

    //локатор куки
    private final By cookieButton = By.id("rcc-confirm-button");

    //метод закрытия куки
    public void closeCookiePopupIfPresent() {
        if (driver.findElement(cookieButton).isDisplayed()) {
            driver.findElement(cookieButton).click();
        }
    }

    String[] Answers = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};


    public void scrollTo(WebElement elementToScroll) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    public boolean isEveryFaqAnswerCorrect() {
        for (int i = 0; i < getQuestions().size(); i++) {
            scrollTo(getQuestions().get(i));
            getQuestions().get(i).isDisplayed();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            getQuestions().get(i).click();
            getAnswers().get(i).isDisplayed();
            String answerItemFromWebElements = getAnswers().get(i).getText();
            String answerFromArray = Answers[i];
            if (!(answerItemFromWebElements.equals(answerFromArray))) {
                return false;
            }

        }
        return true;

    }

}
