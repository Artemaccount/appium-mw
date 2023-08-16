package lib.page_objects.mobile_web;

import lib.page_objects.interfaces.MainPageInt;
import lib.steps.MWBaseSteps;
import org.openqa.selenium.chrome.ChromeDriver;

public class MWMainPage extends MWBaseSteps implements MainPageInt {

    private static final String MOBILE_URL = "https://en.m.wikipedia.org";
    public MWMainPage(ChromeDriver driver) {
        super(driver);
        driver.get(MOBILE_URL);
    }

    @Override
    public void skipOnboarding() {
        login("UserForAppium", "user111!");
    }

    private void login(String login, String password) {
        waitForClickableAndClick("xpath://label[@for='main-menu-input']");
        waitForClickableAndClick("xpath://a[@data-event-name='menu.login']");
//        waitForClickableAndClick("xpath://span[text()='Log in']/ancestor::a[@type='button']", "cant click to login button");
        waitAndSendKeysTo("xpath://input[@id='wpName1']", login);
        waitAndSendKeysTo("xpath://input[@id='wpPassword1']", password);
        waitForClickableAndClick("xpath://button[@value='Log in']");
    }

    @Override
    public void openSavedList() {
        waitAndClickTo("xpath://label[@for='main-menu-input']");
        waitForClickableAndClick("xpath://a[@data-mw='interface' and @href='/wiki/Special:Watchlist']");
    }

    @Override
    public void backToSearchPage(String searchWord) {
//        waitAndClickTo("xpath://button[@id='searchIcon']");
//        waitAndSendKeysTo("xpath://form/input[@placeholder='Search Wikipedia']", searchWord);
    }


}
