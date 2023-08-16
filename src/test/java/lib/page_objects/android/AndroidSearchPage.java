package lib.page_objects.android;

import io.appium.java_client.android.AndroidDriver;
import lib.page_objects.interfaces.SearchPageInt;
import lib.steps.AndroidBaseSteps;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AndroidSearchPage extends AndroidBaseSteps implements SearchPageInt {

//    static {
//        SEARCH_CONTAINER_ID = "id:org.wikipedia:id/search_container";
//        SEARCH_LINE_XPATH = "xpath://android.widget.AutoCompleteTextView[@resource-id='org.wikipedia:id/search_src_text']";
//        SEARCH_LIST_XPATH = "";
//        PAGE_LIST_ITEM_XPATH = "xpath://android.widget.TextView[contains(@resource-id,'org.wikipedia:id/page_list_item_title')]";
//        CLOSE_BUTTON_XPATH = "xpath://*[contains(@resource-id, 'search_close_btn')]";
//        SAVED_LIST_MAIN_ID = "id:org.wikipedia:id/nav_tab_reading_lists";
//        SAVED_LIST_CONTAINER_ID = "id:org.wikipedia:id/item_title_container";
//        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text()='{SUBSTRING}']";
//        SEARCH_RESULT_BY_TITLE_AND_DESC_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title' and @text = '{TITLE}']/following-sibling::*[contains(@text,'{DESC}')]/..";
//    }

    public AndroidSearchPage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void searchInWiki(String value) {
        waitAndClickTo("id:org.wikipedia:id/search_container");
        waitAndSendKeysTo("xpath://android.widget.AutoCompleteTextView[@resource-id='org.wikipedia:id/search_src_text']",
                value);
    }

    @Override
    public List<WebElement> getSearchResults() {
        return waitForList("xpath://*[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup");
    }

    @Override
    public void goToMainMenu() {
        waitAndClickTo("xpath://android.widget.ImageButton[@content-desc='Navigate up']");
        waitAndClickTo("xpath://android.widget.ImageButton[@content-desc='Navigate up']");
    }
}
