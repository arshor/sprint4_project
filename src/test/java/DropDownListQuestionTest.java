import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import pageObjectRentScooter.MainPageRentScooter;

public class DropDownListQuestionTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void CheckDropDownListQuestionText() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageRentScooter objMainPageRentScooter = new MainPageRentScooter(driver);

        objMainPageRentScooter.clickCookieButton();
//        objMainPageRentScooter.scrollPageToEnd();
        objMainPageRentScooter.clickQuestion_0();
        objMainPageRentScooter.checkAnswer_0();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
