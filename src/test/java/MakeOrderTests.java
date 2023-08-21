import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import pages.OrderPage;

import java.io.File;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

public class MakeOrderTests {
    WebDriver driver;

    @Before
    public void initDriver() {
          if ("firefox".equals(System.getProperty("browser")))
              setUpFirefox();
          else
              driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

          public void setUpFirefox() {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            var service = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File("C:\\tools\\geckodriver.exe"))
                    .build();
            var options = new FirefoxOptions()
                    .setBinary("C:\\Program Files\\Firefox 102.7\\firefox.exe");
            driver = new FirefoxDriver(service, options);
        }

        @Test
        public void checkMakeOrderTestWithButtonInHeader () {

            String name = "Вася";
            String surname = "Пупкин";
            String address = "Иваново";
            String phoneNumber = "+79876543211";
            String date = "20.08.2023";
            String comment = "be careful";

            OrderPage orderPage = new OrderPage(driver);
            orderPage.open();
            orderPage.closeCookiePopupIfPresent();
            orderPage.clickOrderButtonInHeader();
            orderPage.fillFirstPartOfFormOrder(name, surname, address, phoneNumber);
            orderPage.clickButtonNext();
            orderPage.fillSecondFormOrderWithBlackColor(date, comment);
            orderPage.clickOrderButton();
            orderPage.clickConfirmOrderButton();
            String expectedTextOrder = "Заказ оформлен";
            MatcherAssert.assertThat("Элемент 'Заказ оформлен' не найден", orderPage.getOrderText(), containsString(expectedTextOrder));
        }

    @Test
    public void checkMakeOrderTestWithButtonInCenter()    {
        String name = "Вася";
        String surname = "Пупкин";
        String address = "Москва";
        String phoneNumber = "+71234567892";
        String date = "20.09.2023";
        String comment = "good luck";

        OrderPage orderPage = new OrderPage(driver);
        orderPage.open();
        orderPage.closeCookiePopupIfPresent();
        orderPage.clickOrderButtonInCenter();
        orderPage.fillFirstPartOfFormOrder(name, surname, address, phoneNumber);
        orderPage.clickButtonNext();
        orderPage.fillSecondFormOrderWithGreyColor(date, comment);
        orderPage.clickOrderButton();
        orderPage.clickConfirmOrderButton();
    }


    @After
   public void killDriver() {
        driver.quit();
    }
    }

