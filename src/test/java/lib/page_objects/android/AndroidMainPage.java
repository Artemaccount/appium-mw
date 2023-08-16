package lib.page_objects.android;

import io.appium.java_client.android.AndroidDriver;
import lib.page_objects.interfaces.MainPageInt;
import lib.steps.AndroidBaseSteps;

public class AndroidMainPage extends AndroidBaseSteps implements MainPageInt {

    public AndroidMainPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void skipOnboarding() {
        waitAndClickTo("xpath://android.widget.Button[@resource-id='org.wikipedia:id/fragment_onboarding_skip_button']",
                10);
    }

    @Override
    public void openSavedList() {
        waitAndClickTo("id:org.wikipedia:id/nav_tab_reading_lists");
        waitAndClickTo("id:org.wikipedia:id/item_title_container");
    }

    @Override
    public void backToSearchPage(String searchWord) {
        waitAndClickTo("xpath://android.widget.ImageButton[@content-desc='Navigate up']");
    }
}
