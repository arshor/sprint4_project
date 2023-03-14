package pageObjectRentScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageRentScooter {

    // Локаторы
    // Кнопка принятия куки "да все привыкли"
    private By cookieButton = By.id("rcc-confirm-button");
    // Кнопка "Заказать" в хедере
    private By headerOrderButton = By.className("Button_Button__ra12g");
    // Ссылка "Статус заказа" в хедере
    private By statusOrderButton = By.className("Header_Link__1TAG7");
    // Кнопка "Заказать" в середине страницы
    private By middleOrderButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");
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

    private WebDriver driver;

    public MainPageRentScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

    public void clickQuestion(int num_item) {
        driver.findElement(DROP_DOWN_LIST_QUESTIONS[num_item]).click();
    }

    public String getAnswer(int num_item) {
        WebElement dropDownItem = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(DROP_DOWN_LIST_ANSWERS[num_item]));
        String answerText = dropDownItem.getText();
        return answerText;
    }

}
