package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void scrollTo(int index) {
        WebElement elementToScroll = getQuestions().get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    public void clickQuestion(int index) {
        getQuestions().get(index).isDisplayed();
        getQuestions().get(index).click();
    }

    public String getAnswerText(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(getAnswers().get(index)));
        return getAnswers().get(index).getText();
    }

}
