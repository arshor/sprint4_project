import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import pageObjectRentScooter.MainPageRentScooter;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderFlowTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public OrderFlowTest(String name, String surname, String address, String metro, String phone, String date, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForOrder() {
        return new Object[][] {
                { "Иван", "Иванов", "Москва", "Сокольники", "+79998887766", "22.04.2023", "трое суток", "серая безысходность", "Без комментариев"},
                { "Сидор", "Сидоров", "Химки", "Митино", "+71112223344", "30.07.2023", "сутки", "чёрный жемчуг", ""},
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkOrderFlowHeaderButton_ShowOrderConfirmation() {

        MainPageRentScooter mainPage = new MainPageRentScooter(driver);
        mainPage.clickCookieButton();
        mainPage.clickHeaderOrderButton();
        mainPage.enterName(name);
        mainPage.enterSurname(surname);
        mainPage.enterAddress(address);
        mainPage.choiceMetro(metro);
        mainPage.enterPhone(phone);
        mainPage.clickNextButton();
        mainPage.enterDate(date);
        mainPage.enterPeriod(period);
        mainPage.enterComment(comment);
        mainPage.clickOrderButtonFinal();

//        assertEquals("Текст ответа не совпадает в вопросе: " + question, expectedAnswer, answer);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
