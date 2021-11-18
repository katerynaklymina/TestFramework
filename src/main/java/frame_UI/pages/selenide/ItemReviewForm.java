package frame_UI.pages.selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class ItemReviewForm {
    private final SelenideElement reviewForm = $(By.id("write-mess"));
    private final SelenideElement advantageField = $x("//div[@id='write-mess']//input[@name= 'ru[plus]']");
    private final SelenideElement disadvantageField = $x("//div[@id='write-mess']//input[@name= 'ru[minus]']");
    private final SelenideElement textField = $x("//div[@id='write-mess']//textarea[@name= 'ru[comment]']");
    private final SelenideElement nameField = $x("//div[@id='write-mess']//input[@name= 'ru[name]']");
    private final SelenideElement emailField = $x("//div[@id='write-mess']//input[@name= 'email']");
    private final SelenideElement leaveReviewButton = $x("//div[@id='write-mess']//button[@data-callback= 'onReviewSubmit']");
    private final ElementsCollection starsReviewList = $$x("//div[@id='write-mess']//img");
    private final SelenideElement commentTextField = $x("//div[@id='write-comment']//textarea'");
    private final SelenideElement nameCommentField = $x("//div[@id='write-comment']//input[@name= 'ru[name]']");
    private final SelenideElement emailCommentField = $x("//div[@id='write-comment']//input[@name= 'email']");
    private final SelenideElement leaveCommentButton = $x("//div[@id='write-comment']//button[@data-callback= 'onCommentSubmit']");
    private final SelenideElement confirmationMessage = $x("//div[@class = 'ttl js_title']");
    private final SelenideElement commentItemTab = $x("//span[contains(text(), 'Комментарий')]");

    public void assertIsItemReviewFormDisplayed() {
        reviewForm.shouldBe(Condition.visible);
    }

    public void fillStars(int index) {
        $$(starsReviewList).get(index-1).click();
    }

    public void assertAreStarsDisplayed(){
        $$(starsReviewList).shouldBe(CollectionCondition.allMatch("Not all elements are visible", WebElement::isDisplayed));

    }
    public void sendReview(String plus, String minus, String text, String email, String name){
        advantageField.setValue(plus);
        disadvantageField.setValue(minus);
        textField.setValue(text);
        emailField.setValue(email);
        nameField.setValue(name);
    }

    public void sendComment(String comment, String commentName, String commentEmail) {
        commentTextField.setValue(comment);
        nameCommentField.setValue(commentName);
        emailCommentField.setValue(commentEmail);
    }

    public void clickOnLeaveCommentButton() {
        leaveCommentButton.click();
    }

    public void clickOnLeaveReviewButton() {
        leaveReviewButton.click();
    }

    public void clickOnCommentTab() {
        commentItemTab.click();
    }

    public void assertThatReviewSent(String message) {
        confirmationMessage.shouldHave(Condition.text(message));
    }

    public void scroll(){
        reviewForm.scrollTo();
    }
}