import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import pageObjectRentScooter.MainPageRentScooter;
import pageObjectRentScooter.OrderPageRentScooter;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderFlowTest {
    private WebDriver driver;
    private final String orderButton;
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

    public OrderFlowTest(String orderButton, String name, String surname, String address, String metro, String phone, String date, String period, String color, String comment) {
        this.orderButton = orderButton;
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
                {"headerButton", "Иван", "Иванов", "Москва", "Сокольники", "+79998887766", "22.04.2023", "трое суток", "серая безысходность", "Без комментариев"},
                {"middleButton", "Сидор", "Сидоров", "Химки", "Митино", "+71112223344", "30.07.2023", "сутки", "чёрный жемчуг", ""},
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();

//        WebDriverManager.operadriver().setup();
//        driver = new OperaDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkOrderFlowHeaderButton_ShowOrderConfirmation() {

        MainPageRentScooter mainPage = new MainPageRentScooter(driver);
        mainPage.clickCookieButton();
        mainPage.clickOrderButton(orderButton);
        OrderPageRentScooter orderPage = new OrderPageRentScooter(driver);
        orderPage.enterName(name);
        orderPage.enterSurname(surname);
        orderPage.enterAddress(address);
        orderPage.choiceMetro(metro);
        orderPage.enterPhone(phone);
        orderPage.clickNextButton();
        orderPage.enterDate(date);
        orderPage.enterPeriod(period);
        orderPage.choiceColor(color);
        orderPage.enterComment(comment);
        orderPage.clickOrderButtonFinal();
        orderPage.clickYesButton();
        orderPage.isModalWindowOrderPlacedDisplayed();
        boolean modalWindowOrderPlacedDisplayed = orderPage.isModalWindowOrderPlacedDisplayed();
        assertTrue(modalWindowOrderPlacedDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
