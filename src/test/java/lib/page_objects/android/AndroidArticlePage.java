package lib.page_objects.android;


import io.appium.java_client.android.AndroidDriver;
import lib.page_objects.interfaces.ArticlePageInt;
import lib.steps.AndroidBaseSteps;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AndroidArticlePage extends AndroidBaseSteps implements ArticlePageInt {
    public AndroidArticlePage(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void saveArticle(WebElement element) {
        waitAndClickTo(element);
        waitAndClickTo("id:org.wikipedia:id/page_save");
    }

    @Override
    public void deleteArticleFromSaved(WebElement element) {
        swipeElementToLeft(element);
    }

    @Override
    public List<WebElement> getSavedList() {
        return waitForList("xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']");
    }
}
