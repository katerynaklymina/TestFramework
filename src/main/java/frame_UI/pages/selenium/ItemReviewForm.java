package frame_UI.pages.selenium;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ItemReviewForm extends BasePage {

    public ItemReviewForm() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "write-mess")
    private WebElement reviewForm;

    @FindBy(xpath = "//div[@id='write-mess']//input[@name= 'ru[plus]']")
    private WebElement advantageField;

    @FindBy(xpath = "//div[@id='write-mess']//input[@name= 'ru[minus]']")
    private WebElement disadvantageField;

    @FindBy(xpath = "//div[@id='write-mess']//textarea[@name= 'ru[comment]']")
    private WebElement textField;

    @FindBy(xpath = "//div[@id='write-mess']//input[@name= 'ru[name]']")
    private WebElement nameField;

    @FindBy(xpath = "//div[@id='write-mess']//input[@name= 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@id='write-mess']//button[@data-callback= 'onReviewSubmit']")
    private WebElement leaveReviewButton;

    @FindBy(xpath = "//div[@id='write-mess']//img")
    private List<WebElement> starsReviewList;

    @FindBy(xpath = "//div[@id='write-comment']//textarea[@name= 'ru[comment]']")
    private WebElement commentTextField;

    @FindBy(xpath = "//div[@id='write-comment']//input[@name= 'ru[name]']")
    private WebElement nameCommentField;

    @FindBy(xpath = "//div[@id='write-comment']//input[@name= 'email']")
    private WebElement emailCommentField;

    @FindBy(xpath = "//div[@id='write-comment']//button[@data-callback= 'onCommentSubmit']")
    private WebElement leaveCommentButton;

    @FindBy(xpath = "span[contains(text(), 'Отзыв о товаре')]")
    private WebElement reviewItemTab;

    @FindBy(xpath = "//span[contains(text(), 'Комментарий')]")
    private WebElement commentItemTab;

    @FindBy(xpath = "//div[@class = 'ttl js_title']")
    private WebElement confirmationMessage;

}
