package pageObjectRentScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageRentScooter {

    // Локаторы
    // Кнопка принятия куки "да все привыкли"
    private static final By COOKIE_BUTTON = By.id("rcc-confirm-button");
    // Кнопка "Заказать" в хедере
    private static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
    // Ссылка "Статус заказа" в хедере
    private static final By STATUS_ORDER_BUTTON = By.className("Header_Link__1TAG7");
    // Кнопка "Заказать" в середине страницы
    private static final By MIDDLE_PAGE_ORDER_BUTTON = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    // Лого Самокат
    private static final By LOGO_SAMOKAT = By.className("Header_LogoScooter__3lsAR");
    // Заголовок Вопросы о важном
    private static final By HEADER_QUESTIONS_ABOUT = By.xpath(".//div[@class='Home_FourPart__1uthg']/div['Home_SubHeader__zwi_E']");
    // Кнопка "Статус заказа"
    private static final By CHECK_STATUS_ORDER_BUTTON = By.xpath("//button[@class='Header_Link__1TAG7']");
    // Поле ввода номера заказа
    private static final By ORDER_NUMBER_INPUT_FIELD = By.xpath(".//input[@placeholder=\"Введите номер заказа\"]");
    // Кнопка Go
    private static final By GO_BUTTON = By.xpath(".//button[@class=\"Button_Button__ra12g Header_Button__28dPO\"]");
    // Картинка Заказа не найден
    private static final By NOT_FOUND_IMAGE = By.cssSelector("div.Track_NotFound__6oaoY > img");
    // Массив вопросов в разделе "Вопросы о важном"
    private static final By[] DROP_DOWN_LIST_QUESTIONS = new By[]{
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")};
    // Массив ответов в разделе "Вопросы о важном"
    private static final By[] DROP_DOWN_LIST_ANSWERS = new By[]{
            By.xpath(".//div[@id='accordion__panel-0']/p"),
            By.xpath(".//div[@id='accordion__panel-1']/p"),
            By.xpath(".//div[@id='accordion__panel-2']/p"),
            By.xpath(".//div[@id='accordion__panel-3']/p"),
            By.xpath(".//div[@id='accordion__panel-4']/p"),
            By.xpath(".//div[@id='accordion__panel-5']/p"),
            By.xpath(".//div[@id='accordion__panel-6']/p"),
            By.xpath(".//div[@id='accordion__panel-7']/p")};
    //Поле Имя
    private static final By NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    // Поле фамилия
    private static final By SURNAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле адрес
    private static final By ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Станция метро
    private static final By METRO_FIELD = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле Телефон
    private static final By PHONE_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private static final By NEXT_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Поле Когда привезти самокат?
    private static final By DATE_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле Срок аренды
    private static final By PERIOD_FIELD = By.xpath(".//div[text()='* Срок аренды']");
    // Поле Цвет самоката

    // Поле Комментарий для курьера
    private static final By COMMENT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать итоговая
    private static final By ORDER_BUTTON_FINAL = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private WebDriver driver;

    public MainPageRentScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoSamokat() {
        driver.findElement(LOGO_SAMOKAT).click();
    }

    public String checkLoadHomePage() {
        WebElement homeSubHeader = new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(HEADER_QUESTIONS_ABOUT));
        return homeSubHeader.getText();
    }

    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void clickQuestion(int num_item) {
        driver.findElement(DROP_DOWN_LIST_QUESTIONS[num_item]).click();
    }

    public String getAnswer(int num_item) {
        WebElement dropDownItem = new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(DROP_DOWN_LIST_ANSWERS[num_item]));
        String answerText = dropDownItem.getText();
        return answerText;
    }

    public void clickCheckOrderButton() {
        driver.findElement(CHECK_STATUS_ORDER_BUTTON).click();
    }

    public void enterOrderNumber(String orderNumber) {
        WebElement inputFieldViaLambda = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER_INPUT_FIELD));
        inputFieldViaLambda.sendKeys(orderNumber);
    }

    public void clickGoButton() {
        driver.findElement(GO_BUTTON).click();
    }

    public boolean isImageNotFoundDisplayed() {
        WebElement notFoundImage = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMAGE));
        return notFoundImage.isDisplayed();
    }

    //Order flow
    public void clickHeaderOrderButton() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    public void clickMiddleOrderButton() {
        driver.findElement(MIDDLE_PAGE_ORDER_BUTTON).click();
    }

    public void enterName(String name) {
        WebElement inputFieldName = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(NAME_FIELD));
        inputFieldName.sendKeys(name);
    }

    public void enterSurname(String surname) {
        WebElement inputFieldSurname = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(SURNAME_FIELD));
        inputFieldSurname.sendKeys(surname);
    }

    public void enterAddress(String address) {
        WebElement inputFieldAddress = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(ADDRESS_FIELD));
        inputFieldAddress.sendKeys(address);
    }

    public void choiceMetro(String metro) {
        WebElement inputFieldMetro = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(METRO_FIELD));
        inputFieldMetro.click();
        inputFieldMetro.sendKeys(metro);
        inputFieldMetro.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void enterPhone(String phone) {
        WebElement inputFieldPhone = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(PHONE_FIELD));
        inputFieldPhone.sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }

    public void enterDate(String date) {
        WebElement inputFieldDate = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(DATE_FIELD));
        inputFieldDate.sendKeys(date);
        inputFieldDate.sendKeys(Keys.ENTER);
    }

    public void enterPeriod(String period) {
        WebElement inputFieldPeriod = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(PERIOD_FIELD));
        inputFieldPeriod.click();
        String locatorSelectListPeriod = String.format(".//div[@class='Dropdown-root is-open']//div[text()='%s']", period);
        WebElement selectListPeriod = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorSelectListPeriod)));
    }

    public void enterComment(String comment) {
        WebElement inputFieldComment = new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(COMMENT_FIELD));
        inputFieldComment.sendKeys(comment);
    }

    public void clickOrderButtonFinal() {
        driver.findElement(ORDER_BUTTON_FINAL).click();
    }
}
