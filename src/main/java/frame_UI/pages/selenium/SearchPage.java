package frame_UI.pages.selenium;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class SearchPage extends BasePage {

    public SearchPage() {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id = 'input_search']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> itemsTextList;

    @FindBy(xpath = "//button[@class= 'button-reset search-btn']")
    private WebElement searchButton;

}



