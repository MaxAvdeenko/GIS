package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static Data.Constants.TITLE;

public class GISMainPage {
    @FindBy(css = ".page-header__logo")
    private WebElement gazLogo;

    private WebDriver driver;
    public GISMainPage(WebDriver driver) {this.driver = driver;}

    public void assertThatPageLoad() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(TITLE.toString(), driver.getTitle());
        Assert.assertTrue(gazLogo.isDisplayed());
    }
}
