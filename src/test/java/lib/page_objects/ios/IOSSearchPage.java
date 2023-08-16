package lib.page_objects.ios;

import io.appium.java_client.ios.IOSDriver;
import lib.page_objects.interfaces.SearchPageInt;
import lib.steps.IOSBaseSteps;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IOSSearchPage extends IOSBaseSteps implements SearchPageInt {
    public IOSSearchPage(IOSDriver driver) {
        super(driver);
    }

    @Override
    public void searchInWiki(String value) {
        String locator = "id:Search Wikipedia";
        waitAndClickTo(locator);
        waitAndSendKeysTo(locator,
                value);
    }

    @Override
    public List<WebElement> getSearchResults() {
        return waitForList("xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/" +
                "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/" +
                "XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther[2]");
    }

    @Override
    public void goToMainMenu() {
        waitAndClickTo("id:Search");
        waitAndClickTo("xpath://XCUIElementTypeStaticText[@name='Cancel']");
    }
}
