package tests_UI.selenide;

import frame_UI.helper.Randomizer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import frame_UI.pages.selenide.ItemDetailsPage;
import frame_UI.pages.selenide.ItemReviewForm;
import frame_UI.pages.selenide.SearchPage;
import frame_UI.test_data.data_provider.DataProviderClass;
import frame_UI.utils.WaitSelenide;

import static com.codeborne.selenide.Selenide.open;
import static frame_UI.constants.HostConstants.AVIC_HOST;
import static java.lang.String.format;
import static frame_UI.test_data.TestData.CONFIRM_COMMENT_SEND;
import static frame_UI.test_data.TestData.CONFIRM_REVIEW_SEND;

public class ItemInformationTest extends BaseTest {

    SearchPage searchPage;
    ItemDetailsPage itemDetailsPage;
    ItemReviewForm itemReviewForm;
    WaitSelenide wait;

    @BeforeMethod
    public void initialize() {
        searchPage = new SearchPage();
        itemDetailsPage = new ItemDetailsPage();
        itemReviewForm = new ItemReviewForm();
        wait = new WaitSelenide();
        open(AVIC_HOST);
    }

    @Test(dataProvider = "dataForSearch", dataProviderClass = DataProviderClass.class)
    public void verifyItemInformation(String searchWord) {
        searchPage.inputSearchField(searchWord);
        searchPage.clickOnSearchButton();
        searchPage.clickOnFirstItem();
        itemDetailsPage.clickOnDeliveryAndPaymentMethodsButton();
        itemDetailsPage.clickOnItemOfAdditionalInfoList("Характеристики");
        itemDetailsPage.assertCharacteristicTableIsDisplayed();
        itemDetailsPage.assertCharacteristicTableRowsDisplayed();
    }

    @org.testng.annotations.Test(dataProvider = "dataProviderForReviewForm", dataProviderClass = DataProviderClass.class)
    public void verifyItemReviewForm(String searchWord, int advantage, int disadvantage, int email, int name, int text) {
        searchPage.inputSearchField(searchWord);
        searchPage.clickOnSearchButton();
        searchPage.clickOnFirstItem();
        itemDetailsPage.clickOnDeliveryAndPaymentMethodsButton();
        itemDetailsPage.clickOnItemOfAdditionalInfoList("Отзывы");
        wait.waitVisible(itemReviewForm.getReviewForm());
        itemReviewForm.assertIsItemReviewFormDisplayed();
        itemReviewForm.assertAreStarsDisplayed();
        itemReviewForm.fillStars(5);
        itemReviewForm.sendReview(
                Randomizer.randomAlphanumeric(advantage),
                Randomizer.randomAlphanumeric(disadvantage),
                Randomizer.randomEmail(email),
                Randomizer.randomAlphanumeric(name),
                Randomizer.randomAlphanumeric(text)
        );
        itemReviewForm.scroll();
        itemReviewForm.clickOnLeaveReviewButton();
        itemReviewForm.assertThatReviewSent(CONFIRM_REVIEW_SEND);
    }

    @Test
    public void verifyItemCommentForm() {
        searchPage.inputSearchField("apple");
        searchPage.clickOnSearchButton();
        searchPage.clickOnFirstItem();
        itemDetailsPage.clickOnDeliveryAndPaymentMethodsButton();
        itemDetailsPage.clickOnItemOfAdditionalInfoList("Отзывы");
        wait.waitVisible(itemReviewForm.getReviewForm());
        itemReviewForm.assertIsItemReviewFormDisplayed();
        itemReviewForm.clickOnCommentTab();
       // wait.waitVisible(itemReviewForm.getCommentItemTab());
        itemReviewForm.sendComment(
                Randomizer.randomAlphanumeric(5),
                Randomizer.randomAlphanumeric(5),
                Randomizer.randomEmail(10)
        );

        itemReviewForm.clickOnLeaveCommentButton();
        itemReviewForm.assertThatReviewSent(CONFIRM_COMMENT_SEND);
    }

}
