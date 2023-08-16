package lib.page_objects.ios;

import io.appium.java_client.ios.IOSDriver;
import lib.page_objects.interfaces.ArticlePageInt;
import lib.steps.IOSBaseSteps;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IOSArticlePage extends IOSBaseSteps implements ArticlePageInt {
    public IOSArticlePage(IOSDriver driver) {
        super(driver);
    }

    @Override
    public void saveArticle(WebElement element) {
        waitAndClickTo(element);
        waitAndClickTo("id:Save for later");
    }

    @Override
    public void deleteArticleFromSaved(WebElement element) {
        swipeElementToLeft(element);
        waitAndClickTo("id:swipe action delete");
    }

    @Override
    public List<WebElement> getSavedList() {
        return waitForList("xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/" +
                "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/" +
                "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/" +
                "XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]");
    }
}
