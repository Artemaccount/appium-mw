package lib.page_objects.mobile_web;

import lib.page_objects.interfaces.ArticlePageInt;
import lib.steps.MWBaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MWArticlePage extends MWBaseSteps implements ArticlePageInt {
    public MWArticlePage(ChromeDriver driver) {
        super(driver);
    }

    @Override
    public void saveArticle(WebElement element) {
        waitAndClickTo(element);
    }

    @Override
    public void deleteArticleFromSaved(WebElement element) {
//        WebElement deleteButton = element.findElements(By.xpath("//a[@type='button']")).get(0);
//        WebElement deleteButton = element.findElement(By.xpath("//../following-sibling::a"));
        waitAndClickTo(element);
        waitForClickableAndClick("xpath://a[@id='ca-watch']");
        waitForElementTitleIsAdd("xpath://a[@id='ca-watch']");
        driver.navigate().back();
        driver.navigate().refresh();
//        try {
//            Thread.sleep(2_000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public List<WebElement> getSavedList() {
        return waitForList("xpath://li[contains(@class, 'page-summary')]/a/h3");
    }
}
