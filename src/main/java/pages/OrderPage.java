package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    WebDriver driver;

    //Конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод open
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //локатор кнопки "Заказать" в хедере
    private final By orderButtonInHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    //локатор кнопки "Заказать" в центре
    private final By orderButtonInCenter = By.className("Home_FinishButton__1_cWm");
    //локатор поля ввода "Имя"
    private final By orderName = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля ввода "Фамилия"
    private final By orderSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля ввода "Адрес"
    private final By orderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля "Станция метро"
    private final By orderMetroField = By.cssSelector(".select-search__value>input.select-search__input");
    //локатор поля выбора станции метро
    private final By chooseMetroStation = By.xpath(".//div[@class='select-search__select']//button[@value='4']");
    //локатор поля ввода телефона
    private final By orderPhoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки Далее
    private final By nextButton = By.cssSelector(".Order_NextButton__1_rCA>button");
    //локатор поля "Когда привезти самокат"
    private final By date = By.cssSelector(".Order_Form__17u6u .react-datepicker__input-container>input");
    //локатор поля "Срок аренды"
    private final By chooseRentPeriod = By.className("Dropdown-arrow");
    //локатор для поля выбора срока аренды 3 дня
    private final By rentPeriodFor3Days = By.cssSelector("div[class='Dropdown-menu'] div:nth-child(3)");
    //локатор для поля выбора срока аренды 5 дней
    private final By rentPeriodFor5Days = By.xpath(".//div[@class='Dropdown-menu']/div[text()='пятеро суток']");
    //локатор чекбокса Цвет самоката "черный жемчуг"
    private final By colorBlack = By.cssSelector(".Order_Checkboxes__3lWSI #black");
    //локатор чекбокса Цвет самоката "серая безысходность"
    private final By colorGray = By.id("grey");
    //локатор поля "Комментарий для курьера"
    private final By commentForCourier = By.cssSelector("div.Input_InputContainer__3NykH input.Input_Responsible__1jDKN");
    //локатор кнопки "Заказать"
    private final By orderButtonInform = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    //локатор кнопки "Да" формы "Хотите оформить заказ?"
    private final By confirmMakeOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Да']");

    public By getOrderSuccess() {
        return orderSuccess;
    }

    //локатор окна "Заказ оформлен"
    private final By orderSuccess = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //локатор куки
    private final By cookieButton = By.id("rcc-confirm-button");

    //метод закрытия куки
    public void closeCookiePopupIfPresent() {
        if (driver.findElement(cookieButton).isDisplayed()) {
            driver.findElement(cookieButton).click();
        }
    }


    // метод клика по кнопке "Заказать" в хедере
    public void clickOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();
    }

    // метод клика по кнопке "Заказать" в центре
    public void clickOrderButtonInCenter() {
        scrollToOrderButtonInCenter();
        driver.findElement(orderButtonInCenter).click();

    }

    // скролл до кнопки "Заказать" в центре
    private void scrollToOrderButtonInCenter() {
        WebElement elementToScroll = driver.findElement(orderButtonInCenter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    // метод заполнения поля "Имя"
    public void fillOrderInputName(String name) {
        driver.findElement(orderName).sendKeys(name);

    }

    // метод заполнения поля "Фамилия"
    public void fillOrderInputSurname(String surname) {
        driver.findElement(orderSurname).sendKeys(surname);
    }

    // метод заполнения поля "Адрес"
    public void fillOrderInputAddress(String address) {
        driver.findElement(orderAddress).sendKeys(address);

    }

    // метод заполнения поля станция метро
    public void setValueInputMetroStation() {
        driver.findElement(orderMetroField).click();
        driver.findElement(chooseMetroStation).click();
    }

    // метод заполнения поля ввода телефона
    public void fillOrderPhoneNumber(String phoneNumber) {
        driver.findElement(orderPhoneField).sendKeys(phoneNumber);
    }

    // метод заполнения первой части формы заказа
    public void fillFirstPartOfFormOrder(String name, String surname, String address, String phoneNumber) {
        fillOrderInputName(name);
        fillOrderInputSurname(surname);
        fillOrderInputAddress(address);
        setValueInputMetroStation();
        fillOrderPhoneNumber(phoneNumber);

    }

    // метод нажатия на кнопку "Далее"
    public void clickButtonNext() {
        driver.findElement(nextButton).click();
    }

    // метод выбора даты заказа
    public void setRentDay(String printDate) {
        driver.findElement(date).click();
        driver.findElement(date).sendKeys(printDate);
    }

    // метод выбора срока аренды 3 суток
    public void setRentPeriodFor3Days() {
        driver.findElement(chooseRentPeriod).click();
        driver.findElement(rentPeriodFor3Days).click();
    }

    // метод выбора срока аренды 5 суток
    public void setRentPeriodFor5Days() {
        driver.findElement(chooseRentPeriod).click();
        driver.findElement(rentPeriodFor5Days).click();
    }

    // метод выбора цвета самоката Черный
    public void setScooterColorBlack() {
        driver.findElement(colorBlack).click();
    }

    // метод выбора цвета самоката Черный
    public void setScooterColorGrey() {
        driver.findElement(colorGray).click();
    }

    // метод ввода комментария для курьера
    public void enterCommentForCourier(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }

    // метод нажатия на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']")).click();
    }

    // метод подтверждения Заказа
    public void clickConfirmOrderButton() {
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Да']")).click();
    }

    // метод заполнения второй части формы заказа с чёрным цветом на 3 дня
    public void fillSecondFormOrderWithBlackColor(String printDate, String comment) {
        setRentDay(printDate);
        setRentPeriodFor3Days();
        setScooterColorBlack();
        enterCommentForCourier(comment);
    }

    // метод заполнения второй части формы заказа с серым цветом на 5 дней
    public void fillSecondFormOrderWithGreyColor(String printDate, String comment) {
        setRentDay(printDate);
        setRentPeriodFor5Days();
        setScooterColorGrey();
        enterCommentForCourier(comment);
    }

    // метод получения текста "Заказ оформлен"
    public String getOrderText() {
        return driver.findElement(orderSuccess).getText();

    }

}
