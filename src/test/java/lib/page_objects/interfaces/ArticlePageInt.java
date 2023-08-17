package lib.page_objects.interfaces;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ArticlePageInt {
    @Step("save article")
    void saveArticle(WebElement element);
    @Step("delete article from saved")
    void deleteArticleFromSaved(WebElement element);

    @Step("getting saved list")
    List<WebElement> getSavedList();
}
