package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexMainPage {

    @FindBy(css = "#text")
    private WebElement searchLine;

    @FindBy(css = ".search2__button")
    private WebElement searchButton;

    private WebDriver driver;

    public YandexMainPage(WebDriver driver) {this.driver = driver;}

    public void searchForGIS(String gisName) {
        searchLine.sendKeys(gisName);
    }

    public void clickSearch(){
        searchButton.click();
    }

    public void open(String url) {
        driver.get(url);
    }
}

