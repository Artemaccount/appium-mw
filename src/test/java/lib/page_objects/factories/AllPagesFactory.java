package lib.page_objects.factories;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lib.Platform;
import lib.page_objects.android.AndroidArticlePage;
import lib.page_objects.android.AndroidMainPage;
import lib.page_objects.android.AndroidSearchPage;
import lib.page_objects.ios.IOSArticlePage;
import lib.page_objects.ios.IOSMainPage;
import lib.page_objects.ios.IOSSearchPage;
import lib.page_objects.mobile_web.MWArticlePage;
import lib.page_objects.mobile_web.MWMainPage;
import lib.page_objects.mobile_web.MWSearchPage;
import lib.page_objects.interfaces.ArticlePageInt;
import lib.page_objects.interfaces.MainPageInt;
import lib.page_objects.interfaces.SearchPageInt;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AllPagesFactory {
    private final RemoteWebDriver driver;

    public AllPagesFactory(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public ArticlePageInt getArticlePage() {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticlePage((AndroidDriver) driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSArticlePage((IOSDriver) driver);
        } else if (Platform.getInstance().isMW()) {
            return new MWArticlePage((ChromeDriver) driver);
        } else {
            throw new RuntimeException("unknown type of driver");
        }
    }

    public MainPageInt getMainPage() {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMainPage((AndroidDriver) driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSMainPage((IOSDriver) driver);
        } else if (Platform.getInstance().isMW()) {
            return new MWMainPage((ChromeDriver) driver);
        } else {
            throw new RuntimeException("unknown type of driver");
        }
    }

    public SearchPageInt getSearchPage() {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPage((AndroidDriver) driver);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSSearchPage((IOSDriver) driver);
        } else if (Platform.getInstance().isMW()) {
            return new MWSearchPage((ChromeDriver) driver);
        } else {
            throw new RuntimeException("unknown type of driver");
        }
    }
}
