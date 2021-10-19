package selenium;

import org.testng.annotations.DataProvider;
import test_data.TestData;
import helper.Randomizer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_steps.selenium.ItemDetailsPageSteps;
import page_steps.selenium.ItemReviewFormSteps;
import page_steps.selenium.SearchPageSteps;
import test_data.data_provider.DataProviderClass;
import utils.Wait;

import static java.lang.String.format;

public class ItemInformationTest extends BaseTest {

    SearchPageSteps searchPageSteps;
    ItemDetailsPageSteps itemDetailsPageSteps;
    ItemReviewFormSteps itemReviewFormSteps;

    @org.testng.annotations.Test(dataProvider = "dataForSearch", dataProviderClass = DataProviderClass.class)
    public void verifyItemInformation(String searchWord) {
        searchPageSteps = new SearchPageSteps();
        Assert.assertTrue(searchPageSteps.isSearchButtonEnabled());
        searchPageSteps.inputText(searchWord);
        searchPageSteps.clickOnSearchButton();
        Assert.assertTrue(searchPageSteps.isListContainExpectedText(searchWord),
                "Actual list does not contain expected text");
        searchPageSteps.clickOnFirstItemInList();
        itemDetailsPageSteps = new ItemDetailsPageSteps();
        itemDetailsPageSteps.clickOnDeliveryAndPaymentMethodsButton();
        itemDetailsPageSteps.clickOnItemOfAdditionalInfoList("Характеристики");
        Wait.waitVisibilityOfElement(itemDetailsPageSteps.getItemDetailsPage().getCharacteristicTable());
        Assert.assertTrue(itemDetailsPageSteps.isCharacteristicTableDisplayed(), "Item details are not displayed");
        Assert.assertTrue(itemDetailsPageSteps.isCharacteristicTableRowsDisplayed(), "Characteristic table rows are not displayed");
    }

    @org.testng.annotations.Test
    public void verifySearchPage() {
        searchPageSteps = new SearchPageSteps();
        Wait.waitElementToBeClickable(searchPageSteps.getSearchPage().getSearchButton());
        Assert.assertTrue(searchPageSteps.isSearchButtonEnabled());
        searchPageSteps.inputText("apple");
        searchPageSteps.clickOnSearchButton();
        Assert.assertTrue(searchPageSteps.isListContainExpectedText("apple"),
                "Actual list does not contain expected text");
        searchPageSteps.clickOnFirstItemInList();
        itemDetailsPageSteps = new ItemDetailsPageSteps();
        Assert.assertTrue(itemDetailsPageSteps.isLikeIconDisplayed());
        String actualResultForAdditionalInfoList = itemDetailsPageSteps.getStringFromAdditionalInfoList();
        Assert.assertEquals(actualResultForAdditionalInfoList, TestData.EXPECTED_RESULT_ADDITIONAL_INFO,
                "Expected result and actual are different.");
        itemDetailsPageSteps.clickOnDeliveryAndPaymentMethodsButton();
        String actualResult = itemDetailsPageSteps.getStringFromAdditionalInfoTabs();
        Assert.assertEquals(actualResult, TestData.EXPECTED_RESULT_ADDITIONAL_INFO_CHARACTERISTIC,
                "Expected result and actual are different.");
    }

    @org.testng.annotations.Test(dataProvider = "dataProviderForReviewForm", dataProviderClass = DataProviderClass.class)
    public void verifyItemReviewForm(String searchWord, int a, int b, int c, int d, int e) {
        searchPageSteps = new SearchPageSteps();
        searchPageSteps.inputText(searchWord);
        searchPageSteps.clickOnSearchButton();
        searchPageSteps.clickOnFirstItemInList();
        itemDetailsPageSteps = new ItemDetailsPageSteps();
        itemDetailsPageSteps.clickOnDeliveryAndPaymentMethodsButton();
        Wait.waitVisibilityOfElementsList(itemDetailsPageSteps.getItemDetailsPage().getAdditionalInfoTabs());
        itemDetailsPageSteps.clickOnItemOfAdditionalInfoList("Отзывы");
        itemReviewFormSteps = new ItemReviewFormSteps();
        Wait.waitVisibilityOfElement(itemReviewFormSteps.getItemReviewForm().getReviewForm());
        Assert.assertTrue(itemReviewFormSteps.isFormReviewDisplayed(), "The form is not displayed");
        itemReviewFormSteps.fillStars(Randomizer.randomNumberForStars());
        itemReviewFormSteps.fillAdvantageField(Randomizer.randomAlphanumeric(a));
        itemReviewFormSteps.fillDisadvantageField(Randomizer.randomAlphanumeric(b));
        itemReviewFormSteps.fillEmailField(Randomizer.randomEmail(c));
        itemReviewFormSteps.fillNameField(Randomizer.randomAlphanumeric(d));
        itemReviewFormSteps.fillTextField(Randomizer.randomAlphanumeric(e));
        itemReviewFormSteps.clickOnLeaveReviewButton();
        Wait.waitVisibilityOfElement(itemReviewFormSteps.getItemReviewForm().getConfirmationMessage());
        Assert.assertTrue(itemReviewFormSteps.getConfirmationMessage().contains("Успешно!"),
                format("'%s' message is not equal to expected message.", itemReviewFormSteps.getConfirmationMessage()));
    }

    @org.testng.annotations.Test
    public void verifyItemCommentForm() {
        searchPageSteps = new SearchPageSteps();
        searchPageSteps.inputText("apple");
        searchPageSteps.clickOnSearchButton();
        searchPageSteps.clickOnFirstItemInList();
        itemDetailsPageSteps = new ItemDetailsPageSteps();
        itemDetailsPageSteps.clickOnDeliveryAndPaymentMethodsButton();
        itemDetailsPageSteps.clickOnItemOfAdditionalInfoList("Отзывы");
        itemReviewFormSteps = new ItemReviewFormSteps();
        Wait.waitVisibilityOfElement(itemReviewFormSteps.getItemReviewForm().getReviewForm());
        Assert.assertTrue(itemReviewFormSteps.isFormReviewDisplayed(), "The form is not displayed");
        itemReviewFormSteps.clickOnCommentItemTab();
        Wait.waitVisibilityOfElement(itemReviewFormSteps.getItemReviewForm().getCommentTextField());
        itemReviewFormSteps.fillCommentTextField(Randomizer.randomAlphanumeric(19));
        itemReviewFormSteps.fillNameCommentText(Randomizer.randomAlphanumeric(10));
        itemReviewFormSteps.fillEmailCommentField(Randomizer.randomEmail(16));
        itemReviewFormSteps.clickOnLeaveCommentButton();
        Assert.assertTrue(itemReviewFormSteps.getConfirmationMessage().contains("Успешно!"),
                format("'%s' message is not equal to expected message.", itemReviewFormSteps.getConfirmationMessage()));
    }

}
