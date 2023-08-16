package lib.page_objects.interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface ArticlePageInt {
    void saveArticle(WebElement element);
    void deleteArticleFromSaved(WebElement element);

    List<WebElement> getSavedList();
}
