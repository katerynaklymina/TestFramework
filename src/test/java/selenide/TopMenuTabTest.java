package selenide;

import org.testng.annotations.Test;
import pages.selenide.SearchPage;
import test_data.data_provider.DataProviderClass;

import static com.codeborne.selenide.Selenide.open;
import static constants.HostConstants.AVIC_HOST;

public class TopMenuTabTest {

    @Test(dataProvider = "dataForSearch", dataProviderClass = DataProviderClass.class)
    public void verifySearchFunctionality(String searchData) {
        SearchPage searchPage = new SearchPage();
        open(AVIC_HOST);
        searchPage.inputSearchField(searchData);
        searchPage.assertSearchList(searchData);
    }
}
