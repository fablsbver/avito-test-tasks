package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class AdPage {

    private final SelenideElement EDIT_AD = $x("//*[name()='svg' and @stroke='currentColor']");
    private final SelenideElement EDIT_IMAGE_URL = $x("//input[@name='imageUrl']");
    private final SelenideElement EDIT_NAME = $x("//input[@name='name']");
    private final SelenideElement EDIT_PRICE = $x("//input[@name='price']");
    private final SelenideElement EDIT_DESCRIPTION = $x("//textarea[@name='description']");
    private final SelenideElement SAVE_AD = $x("//*[name()='svg' and @stroke='currentColor']");
    private final SelenideElement NEW_IMAGE_URL = $x("//img[@alt='product image']");
    private final SelenideElement NEW_NAME = $x("//h2[@class='chakra-heading css-1mr9o9q']");
    private final SelenideElement NEW_PRICE = $x("//p[@class='chakra-text css-r1bsln']");
    private final SelenideElement NEW_DESCRIPTION = $x("//p[@class='chakra-text css-i3jkqk']");

    public AdPage clickEdit() {
        EDIT_AD.click();
        return this;
    }

    public AdPage editImageUrl(String imageUrl) {
        EDIT_IMAGE_URL.setValue(imageUrl);
        return this;
    }

    public AdPage editName(String name) {
        EDIT_NAME.setValue(name);
        return this;
    }

    public AdPage editPrice(String price) {
        EDIT_PRICE.setValue(price);
        return this;
    }

    public AdPage editDescription(String description) {
        EDIT_DESCRIPTION.setValue(description);
        return this;
    }

    public AdPage clickSaveAd() {
        SAVE_AD.click();
        return this;
    }

    public AdPage checkIsImgUrlIsEdited(String url) {
        NEW_IMAGE_URL.shouldHave(attribute("src", url));
        return this;
    }

    public AdPage checkIsNameIsEdited(String name) {
        NEW_NAME.shouldHave(text(name));
        return this;
    }

    public AdPage checkIsPriceIsEdited(String price) {
        NEW_PRICE.shouldHave(text(price));
        return this;
    }

    public AdPage checkIsDescriptionIsEdited(String description) {
        NEW_DESCRIPTION.shouldHave(text(description));
        return this;
    }

    public AdPage checkIsImgUrlIsNotEdited(String url) {
        NEW_IMAGE_URL.shouldNotHave(attribute("src", url));
        return this;
    }

    public AdPage checkIsNameIsNotEdited(String name) {
        NEW_NAME.shouldNotHave(text(name));
        return this;
    }

    public AdPage checkIsPriceIsNotEdited(String price) {
        NEW_PRICE.shouldNotHave(text(price));
        return this;
    }

    public AdPage checkIsDescriptionIsNotEdited(String description) {
        NEW_DESCRIPTION.shouldNotHave(text(description));
        return this;
    }

    public AdPage deleteImageUrl() {
        EDIT_NAME.clear();
        return this;
    }

    public AdPage deleteName() {
        EDIT_NAME.clear();
        return this;
    }

    public AdPage deletePrice() {
        EDIT_NAME.clear();
        return this;
    }

    public AdPage deleteDescription() {
        EDIT_NAME.clear();
        return this;
    }
}
