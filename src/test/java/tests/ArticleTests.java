package tests;

import io.qameta.allure.*;
import lib.page_objects.factories.AllPagesFactory;
import lib.page_objects.interfaces.ArticlePageInt;
import lib.page_objects.interfaces.MainPageInt;
import lib.page_objects.interfaces.SearchPageInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;


@Epic("Article tests")
public class ArticleTests extends BaseTest {

    @Test
    @Features(value = {@Feature("Article"), @Feature("MainPage"), @Feature("Search")})
    @DisplayName("delete article success test")
    @Description("adding two saved title, deletig one")
    @Severity(value = SeverityLevel.BLOCKER)
    public void deleteArticleSuccessTest(){
        AllPagesFactory factory = new AllPagesFactory(driver);
        MainPageInt mainPage = factory.getMainPage();
        SearchPageInt searchPage = factory.getSearchPage();
        ArticlePageInt articlePage = factory.getArticlePage();

        mainPage.skipOnboarding();

        String searchWord = "Java";

        searchPage.searchInWiki(searchWord);

        List<WebElement> elementList = searchPage.getSearchResults();
        articlePage.saveArticle(elementList.get(0));

        mainPage.backToSearchPage(searchWord);

        List<WebElement> newElementList = searchPage.getSearchResults();
        articlePage.saveArticle(newElementList.get(1));

        searchPage.goToMainMenu();
        mainPage.openSavedList();

        List<WebElement> savedList = articlePage.getSavedList();

        WebElement elementForDelete = savedList.stream()
                .filter(s -> s.getText().equals("Java"))
                .findFirst()
                .orElseThrow();

        articlePage.deleteArticleFromSaved(elementForDelete);

        List<WebElement> savedList2 = articlePage.getSavedList();
        Assertions.assertEquals("Java (programming language)", savedList2.get(0).getText());

    }
}
