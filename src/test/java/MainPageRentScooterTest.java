import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import pageObjectRentScooter.MainPageRentScooter;

import static org.junit.Assert.assertEquals;

public class MainPageRentScooterTest {
    private WebDriver driver;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkClickLogoSamokat_ShowHomePage() {

        MainPageRentScooter objMainPageRentScooter = new MainPageRentScooter(driver);
        objMainPageRentScooter.clickCookieButton();
        objMainPageRentScooter.clickLogoSamokat();
        String homeSubHeader = objMainPageRentScooter.checkLoadHomePage();
        assertEquals("На главную страницу «Самоката» пе перешли", homeSubHeader, "Вопросы о важном");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
