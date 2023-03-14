package pageObjectRentScooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

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
    private By listQuestion_0 = By.id("accordion__heading-0");
    private By listQuestion_1 = By.id("accordion__heading-1");
    private By listQuestion_2 = By.id("accordion__heading-2");
    private By listQuestion_3 = By.id("accordion__heading-3");
    private By listQuestion_4 = By.id("accordion__heading-4");
    private By listQuestion_5 = By.id("accordion__heading-5");
    private By listQuestion_6 = By.id("accordion__heading-6");
    private By listQuestion_7 = By.id("accordion__heading-7");
    // Массив ответов в разделе "Вопросы о важном"
    private By listAnswer_0 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By listAnswer_1 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private By listAnswer_2 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private By listAnswer_3 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private By listAnswer_4 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private By listAnswer_5 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private By listAnswer_6 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private By listAnswer_7 = By.xpath(".//div[@id='accordion__panel-7']/p");
    private WebDriver driver;

    public MainPageRentScooter(WebDriver driver){
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

    public void scrollPageToEnd() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(listQuestion_7));
    }

    public void clickQuestion_0() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(listQuestion_0));
        driver.findElement(listQuestion_0).click();
    }

    public void checkAnswer_0() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(listAnswer_0));
        String answerText = driver.findElement(listAnswer_0).getText();
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals(expectedText, answerText);
    }

}
