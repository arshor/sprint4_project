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
import static pageObjectRentScooter.constants.DropDownList.EXPECTED_ANSWERS;
import static pageObjectRentScooter.constants.DropDownList.QUESTIONS;

@RunWith(Parameterized.class)
public class DropDownListQuestionTest {

    private WebDriver driver;
    private final String question;
    private final String expectedAnswer;
    private final int num_item;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public DropDownListQuestionTest(String question, String expectedAnswer, int num_item) {
        this.question = question;
        this.expectedAnswer = expectedAnswer;
        this.num_item = num_item;
    }

    @Parameterized.Parameters
    public static Object[][] getDropDownListData() {
        return new Object[][] {
                { QUESTIONS[0], EXPECTED_ANSWERS[0], 0},
                { QUESTIONS[1], EXPECTED_ANSWERS[1], 1},
                { QUESTIONS[2], EXPECTED_ANSWERS[2], 2},
                { QUESTIONS[3], EXPECTED_ANSWERS[3], 3},
                { QUESTIONS[4], EXPECTED_ANSWERS[4], 4},
                { QUESTIONS[5], EXPECTED_ANSWERS[5], 5},
                { QUESTIONS[6], EXPECTED_ANSWERS[6], 6},
                { QUESTIONS[7], EXPECTED_ANSWERS[7], 7},
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkDropDownList_ShowCorrectAppearsText() {

        MainPageRentScooter objMainPageRentScooter = new MainPageRentScooter(driver);

        objMainPageRentScooter.clickCookieButton();
        objMainPageRentScooter.clickQuestion(num_item);
        String answer = objMainPageRentScooter.getAnswer(num_item);
        assertEquals("Текст ответа не совпадает в вопросе: " + question, expectedAnswer, answer);
    }

    @Test
    public void checkClickLogoSamokat_ShowHomePage() {

        MainPageRentScooter objMainPageRentScooter = new MainPageRentScooter(driver);

        objMainPageRentScooter.clickLogoSamokat();
        String homeSubHeader = objMainPageRentScooter.checkLoadHomePage();
        assertEquals("На главную страницу «Самоката» пе перешли", homeSubHeader, "Вопросы о важном");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
