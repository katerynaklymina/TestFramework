package page_steps.selenium;

import pages.selenium.ItemReviewForm;

public class ItemReviewFormSteps {

    private ItemReviewForm itemReviewForm = new ItemReviewForm();

    public ItemReviewForm getItemReviewForm(){
        return itemReviewForm;
    }

    public boolean isFormReviewDisplayed() {

        return itemReviewForm.getReviewForm().isDisplayed();
    }

    public void fillAdvantageField(String text) {
        itemReviewForm.getAdvantageField().sendKeys(text);
    }

    public void fillDisadvantageField(String text) {
        itemReviewForm.getDisadvantageField().sendKeys(text);
    }

    public void fillTextField(String text) {
        itemReviewForm.getTextField().sendKeys(text);
    }

    public void fillNameField(String text) {
        itemReviewForm.getNameField().sendKeys(text);
    }

    public void fillEmailField(String text) {
        itemReviewForm.getEmailField().sendKeys(text);
    }

    public void clickOnLeaveReviewButton() {
        itemReviewForm.getLeaveReviewButton().click();
    }

    public void fillStars(int quantityOfStars) {
        itemReviewForm.getStarsReviewList().get(quantityOfStars - 1).click();
    }

    public void clickOnCommentItemTab() {
        itemReviewForm.getCommentItemTab().click();
    }

    public void fillCommentTextField(String text) {
        itemReviewForm.getCommentTextField().sendKeys(text);
    }

    public void fillNameCommentText(String text) {
        itemReviewForm.getNameCommentField().sendKeys(text);
    }

    public void fillEmailCommentField(String text) {
        itemReviewForm.getEmailCommentField().sendKeys(text);
    }

    public void clickOnLeaveCommentButton() {
        itemReviewForm.getLeaveCommentButton().click();
    }

    public String getConfirmationMessage() {
        return itemReviewForm.getConfirmationMessage().getText();
    }
}
