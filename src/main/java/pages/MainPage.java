package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
//import src.main.test.java.DataTest;



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

    public void scrollTo(WebElement elementToScroll) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    public boolean isEveryFaqAnswerCorrect() {
        //DataTest dataTest = new DataTest;
        for (int i = 0; i < getQuestions().size(); i++) {
            scrollTo(getQuestions().get(i));
            getQuestions().get(i).isDisplayed();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            getQuestions().get(i).click();
            getAnswers().get(i).isDisplayed();
            if (!(getAnswers().get(i).isDisplayed())) {
                return false;
            }

        }
        return true;

    }

}
