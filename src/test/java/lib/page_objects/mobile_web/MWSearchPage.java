package lib.page_objects.mobile_web;

import lib.page_objects.interfaces.SearchPageInt;
import lib.steps.MWBaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MWSearchPage extends MWBaseSteps implements SearchPageInt {
    public MWSearchPage(ChromeDriver driver) {
        super(driver);
    }

    @Override
    public void searchInWiki(String value) {
        waitAndClickTo("xpath://button[@id='searchIcon']");
        waitAndSendKeysTo("xpath://form/input[@placeholder='Search Wikipedia']", value);
    }

    @Override
    public List<WebElement> getSearchResults() {
        return waitForList("xpath://ul[contains(@class, 'page-list')]/li/a[@type='button']");
    }

    @Override
    public void goToMainMenu() {
        waitAndClickTo("xpath://div/button[contains(@class,'cancel')]");
    }
}
