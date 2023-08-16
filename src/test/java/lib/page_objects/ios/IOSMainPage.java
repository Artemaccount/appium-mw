package lib.page_objects.ios;

import io.appium.java_client.ios.IOSDriver;
import lib.page_objects.interfaces.MainPageInt;
import lib.steps.IOSBaseSteps;

public class IOSMainPage extends IOSBaseSteps implements MainPageInt {
    public IOSMainPage(IOSDriver driver) {
        super(driver);
    }

    @Override
    public void skipOnboarding() {
        waitAndClickTo("xpath://XCUIElementTypeStaticText[@name='Skip']");
    }

    @Override
    public void openSavedList() {
        waitAndClickTo("id:Saved");
        waitAndClickTo("id:Close");
    }

    @Override
    public void backToSearchPage(String searchWord) {
        waitAndClickTo("id:Search");
    }
}
