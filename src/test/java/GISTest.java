import Data.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.GISMainPage;
import pages.YandexMainPage;
import pages.YandexSearchPage;

import static Data.Constants.*;

public class GISTest {

    private WebDriver driver;
    private YandexMainPage yandexMainPage;
    private YandexSearchPage yandexSearchPage;
    private GISMainPage gisMainPage;


    @Before
    public void initTest(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        yandexMainPage = PageFactory.initElements(driver, YandexMainPage.class);
        yandexSearchPage = PageFactory.initElements(driver, YandexSearchPage.class);
        gisMainPage = PageFactory.initElements(driver, GISMainPage.class);
    }

    @After
    public void close(){
        driver.quit();
    }

    @Test
    public void GazInformServiceTest(){
        //1. Зайти на сайт Яндекса ( https://www.yandex.ru/ )
        yandexMainPage.open(INDEX_HTML_URL.toString());

        //2. В поисковую строку ввести «Газинформсервис»
        yandexMainPage.searchForGIS(GIS_NAME.toString());
        yandexMainPage.clickSearch();

        //3. Среди результатов поиска найти тот, который соответствует сайту https://www.gaz-is.ru/
        //4. Перейти по ссылке с найденного результата
        yandexSearchPage.clickLink();

        //5. Убедиться, что сайт загрузился.
        gisMainPage.assertThatPageLoad();
    }
}
