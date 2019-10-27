package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static Data.Constants.*;

public class YandexSearchPage {

    @FindBy(xpath = ".//b[text() = 'gaz-is.ru']")
    private List<WebElement> gazLinks;

    @FindBy(xpath = ".//a[text() = 'дальше']")
    private WebElement nextButton;

    private WebDriver driver;

    public YandexSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink() {
        if (gazLinks.size() != 0) gazLinks.get(0).click();
        else {
            do {
                nextButton.click();
            } while (gazLinks.size() == 0);
        gazLinks.get(0).click();
        }
    }
}
