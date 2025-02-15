package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAdModal {

    private final SelenideElement NAME = $x("//input[@name='name']");
    private final SelenideElement PRICE = $x("//input[@name='price']");
    private final SelenideElement DESCRIPTION = $x("//input[@name='description']");
    private final SelenideElement IMAGE_URL = $x("//input[@name='imageUrl']");
    private final SelenideElement SUBMIT = $x("//button[@type='submit']");
    private final SelenideElement CREATE_MODAL_WINDOW = $x("//div[@class='chakra-modal__body css-qlig70']");
    private final ElementsCollection ERROR_MESSAGES = $$x("//div[@class='chakra-form__error-message css-502kp3']");

    @Step
    public CreateAdModal fillAdForm(String name, String price, String description, String imageUrl) {
        return enterName(name)
                .enterPrice(price)
                .enterDescription(description)
                .enterImageUrl(imageUrl);
    }

    public CreateAdModal checkIsCreateModalInteractabal() {
        CREATE_MODAL_WINDOW.shouldBe(interactable);
        return this;
    }

    public CreateAdModal checkErrorMessageExist(String text) {
        ERROR_MESSAGES.should(allMatch(
                "Все элементы должны содержать '" + text + "'",
                el -> el.getText().contains(text)));
        return this;
    }

    public CreateAdModal enterName(String name) {
        NAME.setValue(name);
        return this;
    }

    public CreateAdModal enterPrice(String price) {
        PRICE.setValue(price);
        return this;
    }

    public CreateAdModal enterDescription(String description) {
        DESCRIPTION.setValue(description);
        return this;
    }

    public CreateAdModal enterImageUrl(String imageUrl) {
        IMAGE_URL.setValue(imageUrl);
        return this;
    }

    public CreateAdModal clickSubmit() {
        SUBMIT.click();
        return this;
    }
}

