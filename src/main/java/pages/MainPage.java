package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static properties.TestProperties.getProperty;
import static test_data.Constants.SORT_BY_ASC;
import static test_data.Constants.SORT_BY_DESC;

public class MainPage {

    private final SelenideElement CREATE = $x("//button[contains(text(), 'Создать')]");
    private final SelenideElement SEARCH_FIELD = $x("//input[@class='chakra-input css-1owg1hr']");
    private final SelenideElement SEARCH = $x("//button[@class='chakra-button css-1oamcjg']");
    private final SelenideElement ITEMS_ON_PAGE = $x("//button[@class='chakra-button chakra-menu__menu-button css-98wh1e']");
    private final SelenideElement FILTER_BY_ORDER = $x("//button[@id='menu-button-:rh:']");
    private final SelenideElement FILTER_BY_DESC = $x("//button[@id='menu-list-:rh:-menuitem-:ri:']");
    private final SelenideElement FILTER_BY_ASC = $x("//button[@id='menu-list-:rh:-menuitem-:rj:']");
    private final SelenideElement FILTER_BY_PARAMETERS = $x("//button[@id='menu-button-:rc:");
    private final SelenideElement FILTER_BY_PRICE = $x("//button[@id='menu-list-:rc:-menuitem-:rd:']");
    private final SelenideElement FILTER_BY_VIEWS = $x("//button[@id='menu-list-:rc:-menuitem-:re:']");
    private final SelenideElement FILTER_BY_LIKES = $x("//button[@id='menu-list-:rc:-menuitem-:rf:']");
    private final ElementsCollection ITEMS_ON_PAGE_NUMBERS = $$x("//button[@class='chakra-menu__menuitem css-18esm8n']");
    private final ElementsCollection ITEMS_COLLECTION = $$x("//div[@class='css-1cickmn']");
    private final ElementsCollection ITEMS_PRICES_COLLECTION = $$x("//div[@class='css-1n43xc7']");
    private final ElementsCollection ITEMS_VIEWS_COLLECTION = $$x("//span[@class='css-1v235bj']");
    private final ElementsCollection ITEMS_LIKES_COLLECTION = $$x("//span[@class='css-1529eig']");


    @Step
    public MainPage searchAd(String itemName) {
        return enterItemSearchName(itemName)
                .clickSearch()
                .checkIsAdVisible(itemName);
    }

    @Step
    public MainPage checkIsAdNotSearched(String itemName) {
        return enterItemSearchName(itemName)
                .clickSearch()
                .checkIsAdNotVisible(itemName);

    }

    public MainPage openPage() {
        Selenide.open(getProperty("baseUrl"));
        return this;
    }

    public CreateAdModal clickCreate() {
        CREATE.click();
        return new CreateAdModal();
    }

    public AdPage clickOnAdCardForEditing() {
        ITEMS_COLLECTION.get(0).click();
        return new AdPage();
    }

    public MainPage enterItemSearchName(String itemName) {
        SEARCH_FIELD.sendKeys(itemName);
        return this;
    }

    public MainPage clickSearch() {
        SEARCH.click();
        return this;
    }

    public MainPage checkIsAdVisible(String itemName) {
        ITEMS_COLLECTION.get(0).shouldHave(text(itemName));
        return this;
    }

    public MainPage checkIsAdNotVisible(String itemName) {
        ITEMS_COLLECTION.filterBy(text(itemName)).shouldBe(CollectionCondition.empty);
        return this;
    }

    public MainPage clickItemsOnPage() {
        ITEMS_ON_PAGE.click();
        return this;
    }

    public MainPage selectNumberOfItems(int index) {
        ITEMS_ON_PAGE_NUMBERS.get(index).click();
        return this;
    }

    public MainPage checkAmountOfItems(int size) {
        ITEMS_COLLECTION.shouldHave(CollectionCondition.size(size));
        return this;
    }

    public MainPage clickParametersMenu() {
        FILTER_BY_PARAMETERS.click();
        return this;
    }

    public MainPage clickOrderMenu() {
        FILTER_BY_ORDER.click();
        return this;
    }

    public MainPage clickFilterByPrice() {
        FILTER_BY_PRICE.click();
        return this;
    }

    public MainPage clickFilterByViews() {
        FILTER_BY_VIEWS.click();
        return this;
    }

    public MainPage clickFilterByLikes() {
        FILTER_BY_LIKES.click();
        return this;
    }

    public MainPage clickFilterByDesc() {
        FILTER_BY_DESC.click();
        return this;
    }

    public MainPage clickFilterByAsc() {
        FILTER_BY_ASC.click();
        return this;
    }

    public List<String> getActualListOfItemsPrices() {
        return ITEMS_PRICES_COLLECTION
                .stream()
                .map(SelenideElement::getText)
                .toList();
    }

    public List<String> getActualListOfItemsViews() {
        return ITEMS_VIEWS_COLLECTION
                .stream()
                .map(SelenideElement::getText)
                .filter(str -> !str.equals(" просмотр"))
                .toList();
    }

    public List<String> getActualListOfItemsLikes() {
        return ITEMS_LIKES_COLLECTION
                .stream()
                .map(SelenideElement::getText)
                .filter(str -> !str.equals(" лайк"))
                .toList();
    }

    public List<String> getExpectedListOfItemsPrices(String filterType) {
        List<String> sortedItems = new ArrayList<>();
        switch (filterType) {
            case SORT_BY_DESC -> sortedItems = ITEMS_PRICES_COLLECTION
                    .stream()
                    .map(SelenideElement::getText)
                    .sorted(Comparator.reverseOrder())
                    .toList();
            case SORT_BY_ASC -> sortedItems = ITEMS_PRICES_COLLECTION
                    .stream()
                    .map(SelenideElement::getText)
                    .sorted()
                    .toList();
        }
        return sortedItems;
    }

    public List<String> getExpectedListOfItemsViews(String filterType) {
        List<String> sortedItems = new ArrayList<>();
        switch (filterType) {
            case SORT_BY_DESC -> sortedItems = ITEMS_VIEWS_COLLECTION
                    .stream()
                    .map(SelenideElement::getText)
                    .filter(str -> !str.equals(" просмотр"))
                    .sorted(Comparator.reverseOrder())
                    .toList();
            case SORT_BY_ASC -> sortedItems = ITEMS_VIEWS_COLLECTION
                    .stream()
                    .map(SelenideElement::getText)
                    .filter(str -> !str.equals(" просмотр"))
                    .sorted()
                    .toList();
        }
        return sortedItems;
    }

    public List<String> getExpectedListOfItemsLikes(String filterType) {
        List<String> sortedItems = new ArrayList<>();
        switch (filterType) {
            case SORT_BY_DESC -> sortedItems = ITEMS_LIKES_COLLECTION
                    .stream()
                    .map(SelenideElement::getText)
                    .filter(str -> !str.equals(" лайк"))
                    .sorted(Comparator.reverseOrder())
                    .toList();
            case SORT_BY_ASC -> sortedItems = ITEMS_LIKES_COLLECTION
                    .stream()
                    .map(SelenideElement::getText)
                    .filter(str -> !str.equals(" лайк"))
                    .sorted()
                    .toList();
        }
        return sortedItems;
    }
}
